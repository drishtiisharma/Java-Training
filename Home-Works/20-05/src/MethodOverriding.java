import java.util.Scanner;

class Person1{
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

class Employee1 extends Person1{
	int empid;
	double salary;
	void getData1() {
		super.getData();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id: ");
		empid=sc.nextInt();
		System.out.println("enter employee salary: ");
		salary=sc.nextDouble();
		
	}
	void showData1() {
		super.showData();
		System.out.println("employee id: "+empid);
		System.out.println("employee salary: "+salary);
	}
}

class Student1 extends Person1{
	int rollno;
	double percentage;
	void getData2() {
		super.getData();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student rollno: ");
		rollno=sc.nextInt();
		System.out.println("enter student percentage: ");
		percentage=sc.nextDouble();

	}
	void showData2() {
		super.showData();
		System.out.println("student roll no: "+rollno);
		System.out.println("student percentage: "+percentage);
	}
}

class Manager1 extends Employee1{
	int mgrid;
	String dept;
	void getData3() {
		super.getData1();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter manager id: ");
		mgrid=sc.nextInt();
		System.out.println("enter manager department: ");
		dept=sc.next();

	}
	void showData3() {
		super.showData1();
		System.out.println("manager id: "+mgrid);
		System.out.println("manager department: "+dept);
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
		Employee1 e=new Employee1();
		System.out.println("employee details:");
		System.out.println();
		e.getData1();
		e.showData1();
		System.out.println();
		
		Student1 s=new Student1();
		System.out.println("student details:");
		System.out.println();
		s.getData2();
		s.showData2();
		System.out.println();
		
		Manager1 m=new Manager1();
		System.out.println("manager details:");
		System.out.println();
		m.getData3();
		m.showData3();
		

	}

}
