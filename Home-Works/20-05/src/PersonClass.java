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
		sc.close();
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
		sc.close();
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
		System.out.println("enter employee salary: ");
		percentage=sc.nextDouble();
		sc.close();
	}
	void showData2() {
		System.out.println("employee id: "+rollno);
		System.out.println("employee salary: "+percentage);
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
		sc.close();
	}
	void showData3() {
		System.out.println("manager id: "+mgrid);
		System.out.println("manager department: "+dept);
	}
}

public class PersonClass {

	public static void main(String[] args) {
		Person p=new Person();
		System.out.println();
		System.out.println("person details:");
		p.getData();
		p.getData1();
		p.showData();
		p.showData1();

	}

}
