
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class School {
	private TreeSet<Student> students = null;
	private Printable printable = null;
	
	public School() {
		students = new TreeSet<Student>();
	}
	
	public void addStudent(Student student) {
		synchronized (students) {
			students.add(student);
		}
	}
	
	public void removeStudent(String ID) {
		Student temp =null;
		synchronized (students) {
			for (Student s : students) {
				if(ID.equals(s.getsID())) {
					temp = s;
				}
			}
			students.remove(temp);
		}
	}
	
	public Student searchByName(String name) {
		Student temp =null;
		synchronized (students) {
			for (Student s : students) {
				if(name.equals(s.getName())) {
					temp = s;
				}
			}
		}
		return temp;
	}
	
	public Student searchByID(String sID) {
		Student temp =null;
		synchronized (students) {
			for (Student s : students) {
				if(sID.equals(s.getsID())) {
					temp = s;
				}
			}
		}
		return temp;
	}
	
	public Student[] searchByMajor(String major) {
		Student [] temp = new Student[students.size()];
		int count = 0;
		synchronized (students) {
			for (Student student : students) {
				if(student.getMajor().equals(major)) {
					temp[count]=student;
					count++;
				}
			}
		}
		return temp;
	}
	
	public void showStudent() {
		
		printable.print(students);
	}
	
	public void setPrintMethod(Printable printable) {
		this.printable = printable;
		if(!(printable instanceof Printable)) {
			System.out.println("출력불가");
			return;
		}
		//showStudent();
	}
	
	public void loadstudentFile(String data) {
		
		File file = new File(data);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		//StringTokenizer stringTokenizer = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			int count = -1;
			while(true) {
				String strTemp = bufferedReader.readLine();
				if(strTemp == null) {
					break;
				}
				count++;
				if(count % 4 == 0) {
					System.out.println("====학생 정보====");
				}
				System.out.println(strTemp);
				
				//stringTokenizer = new StringTokenizer(strTemp, ":");
				
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}		
}



