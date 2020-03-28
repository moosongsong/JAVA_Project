import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String sID;
	private String major;
	private int score;
	
	public Student(String name, String sID, String major, int score) {
		super();
		this.name = name;
		this.sID = sID;
		this.major = major;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public String getsID() {
		return sID;
	}
	public String getMajor() {
		return major;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setScore(int score) {
		this.score = score;
	}	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Student)) return false;
		Student tmp = (Student)obj;
		if(this.name != null && tmp.name != null) {
			if(this.name.equals(tmp.name)) {
				if(this.sID != null && tmp.sID != null) {
					if(this.sID.equals(tmp.sID)) {
						if(this.major != null && tmp.major != null) {
							if(this.major.equals(tmp.major)) {
								if(this.score == tmp.score) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		int prime = 31;
		int hashcode = 1;
		hashcode  = prime * score + name.hashCode() + sID.hashCode() + major.hashCode();
		return hashcode;
	}
	@Override
	public int compareTo(Student o) {
		if(score<o.score) {
			return -1;
		}
		else if (score == o.score) {
			return 0;
		}else {
			return 1;
		}
	}
}

