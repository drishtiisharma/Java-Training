import java.util.Scanner;

class Employee{
	int empno;
	String name;
	double salary;
	double exp;
	
	
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee no:");
		empno=sc.nextInt();
		System.out.println("enter employee name: ");
		name=sc.next();
		System.out.println("enter employee salary:");
		salary=sc.nextDouble();
		System.out.println("enter employee experience(in years):");
		exp=sc.nextDouble();
		
		sc.close();
	}
	
	void showData() {
		System.out.println();
		System.out.println("employee no: "+empno);
		System.out.println("employee name: "+name);
		System.out.println("employee salary: "+salary);
		System.out.println("employee experience: "+exp+" years");
	}
	
	void increment() {
		System.out.println();
		if(exp<5) {
			salary=salary+(salary*0.05);
		}
		if(exp<10) {
			salary=salary+(salary*0.10);
		}
		if(exp>=10) {
			salary=salary+(salary*0.15);
		}
		
		System.out.println("salary after increment: "+salary);
	}
	
}

public class EmployeeClass {

	public static void main(String[] args) {
		Employee e=new Employee();
		e.getData();
		e.showData();
		e.increment();
	}

}
