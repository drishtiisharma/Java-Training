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
		System.out.println("enter empid: ");
		empid=sc.nextInt();
		System.out.println("enter salary: ");
		salary=sc.nextDouble();
	}
	
	void showData1() {
		System.out.println("empid: "+empid);
		System.out.println("salary: "+salary);
	}
}
public class InheritanceDemo {

	public static void main(String[] args) {
		Employee e=new Employee();
		e.getData();
		e.getData1();
		e.showData();
		e.showData1();

	}

}
