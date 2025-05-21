import java.util.Scanner;

class Person3{
	String name;
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name:");
		name=sc.next();
	}
	void showData() {
		System.out.println("name: "+name);
	}
}
class Teacher extends Person3{
	int teacherid;
	String subject;
	void getData() {
		super.getData();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter teacher id:");
		teacherid=sc.nextInt();
		System.out.println("enter teacher's subject:");
		subject=sc.next();
	}
	
	void showData() {
		super.showData();
		System.out.println("teacher id: "+teacherid);
		System.out.println("teacher's subject: "+subject);
	}
}

class Studentt extends Person3{
	int age;
	double percentage;
	void getData() {
		super.getData();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student's age:");
		age=sc.nextInt();
		System.out.println("enter student's percentage:");
		percentage=sc.nextDouble();
	}
	
	void showData() {
		super.showData();
		System.out.println("student's age: "+age+" years");
		System.out.println("student's percentage: "+percentage+"%");
	}
	
	
}
public class HierarchicalInheritance {

	public static void main(String[] args) {
		Teacher t=new Teacher();
		System.out.println("Teacher details:");
		t.getData();
		t.showData();
		System.out.println();
		
		Studentt s=new Studentt();
		System.out.println("Student details:");
		s.getData();
		s.showData();
		
	}

}
