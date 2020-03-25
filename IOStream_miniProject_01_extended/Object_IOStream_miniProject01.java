import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class Person_ob implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public Person_ob(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public int hashCode() {
		return name.hashCode()+Integer.valueOf(age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(!(obj.getClass().getName().equals(this.getClass().getName()))) {
			return false;
		}
		
		if(this.name==null) {
			if(((Person_ob)obj).name!=null) {
				return false;
			}
			if(((Person_ob)obj).name.equals(this.name)) {
				return this.age == ((Person_ob)obj).age;
			}
		}
		else {
			if(((Person_ob)obj).name==null) {
				return false;
			}
			if(((Person_ob)obj).name.equals(this.name)) {
				return this.age == ((Person_ob)obj).age;
			}
		}
		return false;
	}
}

class School{
	HashSet<Person_ob>school;
	private Object_IOStream_miniProject_Accessable accessable;
	
	public School(HashSet<Person_ob> school) {
		this.school = school;
		this.accessable = null;
	}
	
	public void setAccessable(Object_IOStream_miniProject_Accessable accessable) {
		this.accessable = accessable;
	}

	public HashSet<Person_ob> getSchool() {
		return school;
	}

	public void setSchool(HashSet<Person_ob> school) {
		this.school = school;
	}
	
	public void setSchool(TreeSet<Person_ob> school) {
		this.school = new HashSet<Person_ob>(school);
	}
	
	public void addPerson(Person_ob person) {
		school.add(person);
	}
	
	public void addPerson(String name, int age) {
		school.add(new Person_ob(name, age));
	}
	
	public Person_ob findPerson(String name) {
		
		Iterator<Person_ob> it = school.iterator();
		while(it.hasNext()) {
			Person_ob temp = it.next();
			if(temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	public boolean removePerson(String name) {
		Person_ob temp = findPerson(name);
		if(temp==null) {
			return false;
		}
		school.remove(temp);
		return true;
//		return this.school.remove(findPerson(name));
	}
	
	public void clear() {
		school.clear();
	}
	
	public void saveFile(String fileName) {
		
		
		BufferedOutputStream bos =null;
		ObjectOutputStream oos = null;
		Iterator<Person_ob>it = school.iterator();
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream(fileName), 2048);
			oos = new ObjectOutputStream(bos);
			while(it.hasNext()) {
				Person_ob temp = it.next();
				oos.writeObject(temp);
			}
			oos.flush();
			System.out.println("파일에 저장");
		} catch (IOException e) {
			System.out.println("Fail");
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				System.out.println("close Fail");
			}
		}
	}
	
	public void restoreFile(String fileName) {
		File file = new File(fileName);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis, 2048);
			ois = new ObjectInputStream(bis);
			while(true) {
				try {
					Person_ob person = (Person_ob) ois.readObject();
					if(person != null) {
						school.add(person);
					}
				} catch (EOFException e) {
					System.out.println("모든 데이터를 읽어들임.");
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("input Fail");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("close Fail");
			}
		}
		
		System.out.println("파일로부터 읽어들임");
	}
	
	public void showList() {
		System.out.println("현재 등록된 학생수 : "+school.size());
		Iterator<Person_ob> it = school.iterator();
		while(it.hasNext()) {
			Person_ob temp = it.next();
			System.out.println(temp.getName()+", "+temp.getAge());
		}
	}
}

public class Object_IOStream_miniProject01 {

	public static void main(String[] args) {
		String fileName = "C:\\bigdataprograming\\data.txt";
		HashSet<Person_ob> hs = new HashSet<Person_ob>();
		hs.add(new Person_ob("JIN", 29));
		hs.add(new Person_ob("Sugar", 28));
		hs.add(new Person_ob("RM", 27));
		
				
		School school = new School(hs);
		school.saveFile(fileName);
		school.clear();
		hs.add(new Person_ob("V", 26));
		school.restoreFile(fileName);
		school.showList();
	}

}
