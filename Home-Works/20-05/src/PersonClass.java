import java.util.Scanner;

class Person{
	String name;
	String address;
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name: ");
		name=sc.next();
		System.out.println("enter address: ");
		address=sc.next();

	}
	void showData() {
		System.out.println("name: "+name);
		System.out.println("address: "+address);
	}
}

class Employee extends Person{
	int empid;
	double salary;
	void getData1() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id: ");
		empid=sc.nextInt();
		System.out.println("enter employee salary: ");
		salary=sc.nextDouble();
		
	}
	void showData1() {
		System.out.println("employee id: "+empid);
		System.out.println("employee salary: "+salary);
	}
}

class Student extends Person{
	int rollno;
	double percentage;
	void getData2() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student rollno: ");
		rollno=sc.nextInt();
		System.out.println("enter student percentage: ");
		percentage=sc.nextDouble();

	}
	void showData2() {
		System.out.println("student roll no: "+rollno);
		System.out.println("student percentage: "+percentage);
	}
}

class Manager extends Employee{
	int mgrid;
	String dept;
	void getData3() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter manager id: ");
		mgrid=sc.nextInt();
		System.out.println("enter manager department: ");
		dept=sc.next();

	}
	void showData3() {
		System.out.println("manager id: "+mgrid);
		System.out.println("manager department: "+dept);
	}
}

public class PersonClass {

	public static void main(String[] args) {
		Employee e=new Employee();
		System.out.println("employee details:");
		System.out.println();
		e.getData();
		e.getData1();
		e.showData();
		e.showData1();
		System.out.println();
		
		Student s=new Student();
		System.out.println("student details:");
		System.out.println();
		s.getData();
		s.getData2();
		s.showData();
		s.showData2();
		System.out.println();
		
		Manager m=new Manager();
		System.out.println("manager details:");
		System.out.println();
		m.getData();
		m.getData1();
		m.getData3();
		m.showData();
		m.showData1();
		m.showData3();
		

	}

}
