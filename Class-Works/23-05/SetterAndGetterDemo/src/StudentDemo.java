class Student
{
	private int rollNo;
	private String studName;
	private double perMarks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNo, String studName, double perMarks) {
		super();
		this.rollNo = rollNo;
		this.studName = studName;
		this.perMarks = perMarks;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public double getPerMarks() {
		return perMarks;
	}
	public void setPerMarks(double perMarks) {
		this.perMarks = perMarks;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", studName=" + studName + ", perMarks=" + perMarks + "]";
	}
	
}
public class StudentDemo {

	public static void main(String[] args) {
		
		Student s1 = new Student(101, "Shyam Bihari", 89);
		
		Student s2 = new Student();
		s2.setRollNo(102);
		s2.setStudName("ram Kumar");
		s2.setPerMarks(78);
		
		System.out.println(s1);
		System.out.println(s2);
	}

}
