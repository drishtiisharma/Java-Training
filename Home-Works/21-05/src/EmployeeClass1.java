// Q7. Write a Java program to create a class called "Employee" with a name, salary, and hire date attributes, and a method to calculate years of service.

import java.util.Scanner;

class Employee1{
	String name;
	double salary;
	int hd,exp;
	
	Employee1(String n, double s, int h){
		name=n;
		salary=s;
		hd=h;
	}
	int exp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter current year:");
		int cyear= sc.nextInt();
		return cyear-hd;
	}
	
	void show() {
		System.out.println("employee name: "+name);
		System.out.println("employee salary: "+salary);
		System.out.println("employee experience(in years): "+exp());
	}
}

public class EmployeeClass1 {

	public static void main(String[] args) {
		Employee1 e1=new Employee1("Max", 90000, 2004);
		e1.show();
	}

}
