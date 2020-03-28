
public class AppStart {
	public static void main(String [] args) {
		School school = new School();
		
		school.addStudent(new Student("���", "2017", "SW", 97));
		school.addStudent(new Student("ȿ��", "2018", "SC", 40));
		school.addStudent(new Student("����", "2019", "FE", 50));
		school.addStudent(new Student("����", "2020", "EE", 120));
		school.addStudent(new Student("�ٶ�", "2016", "FR", 3));
		school.addStudent(new Student("����", "2015", "JP", 0));
		
		
		school.setPrintMethod(new PrintOutput2());
		//school.setPrintMethod(new FileOutput());
		//school.setPrintMethod(new ConsoleOutput());
		school.showStudent();
		
		school.removeStudent("2015");
		
		//school.showStudent();

	}
}