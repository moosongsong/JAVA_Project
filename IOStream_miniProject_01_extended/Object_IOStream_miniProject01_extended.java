package 입출력연습;

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
		
		//when using interface
		try {
			this.accessable.saveSchool(this, fileName);
		} catch (Exception e) {		}		
//		//		
		
	}
	
	public void restoreFile(String fileName) {
		//when using interface
		try {
			this.accessable.restoreSchool(this, fileName);
		} catch (Exception e) {		}
		//
		
		
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

public class Object_IOStream_miniProject01_extended {

	public static void main(String[] args) {
		String fileName = "C:\\bigdataprograming\\data.txt";
		HashSet<Person_ob> hs = new HashSet<Person_ob>();
		hs.add(new Person_ob("JIN", 29));
		hs.add(new Person_ob("Sugar", 28));
		hs.add(new Person_ob("RM", 27));
		
		Object_IOStream_miniProject_implementAccessable accessable=
				new Object_IOStream_miniProject_implementAccessable();
		
		School school = new School(hs);
		school.setAccessable(accessable);
		school.saveFile(fileName);
		school.clear();
		hs.add(new Person_ob("V", 26));
		school.restoreFile(fileName);
		school.showList();
	}

}
