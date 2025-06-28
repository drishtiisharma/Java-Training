//Q1. Write a Java program to create a class called "Person" with a name and age attribute. Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.

class Person{
	String name;
	int age;
	
	Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	void show() {
		System.out.println("name: "+name);
		System.out.println("age: "+age);
	}
}
public class PersonClass {

	public static void main(String[] args) {
		Person p1=new Person("john",16);
		Person p2=new Person("alice",17);
		
		p1.show();
		p2.show();

	}

}
