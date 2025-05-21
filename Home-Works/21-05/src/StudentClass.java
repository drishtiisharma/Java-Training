//Q8. Write a Java program to create a class called "Student" with a name, grade, and courses attributes, and methods to add and display student details.

import java.util.Scanner;

class Student{
	String name;
	int grade;
	String course;
	
	void addDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student name: ");
		name=sc.next();
		System.out.println("enter student grade: ");
		grade=sc.nextInt();
		System.out.println("enter student course: ");
		course=sc.next();
	}
	
	void display() {
		System.out.println();
		System.out.println("STUDENT DETAILS:");
		System.out.println("student name: "+name);
		System.out.println("student grade: "+grade);
		System.out.println("student course: "+course);
	}
}

public class StudentClass {

	public static void main(String[] args) {
		Student s=new Student();
		s.addDetails();
		s.display();

	}

}
