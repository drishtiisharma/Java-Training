//Q5. Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.
class Employee{
	String name;
	String jobtitle;
	double salary;
	
	Employee(String n, String jt, double s){
		name=n;
		jobtitle=jt;
		salary=s;
	}
	void display() {
		System.out.println();
		System.out.println("employee name: "+name);
		System.out.println("employee job title: "+jobtitle);
		System.out.println("employee salary: "+salary);
	}
	double addBonus(double bonus) {
		return salary+bonus;
	}
	
	void updateSalary(double inc) {
		salary+=inc;
		System.out.println();
		System.out.println("salary update by: "+inc);		
	}
}

public class EmployeeClass {

	public static void main(String[] args) {
		System.out.println("before increment:");
		Employee e=new Employee("john","junior developer",12000);
		e.display();
		
		System.out.println();
		System.out.println("after increment:");
		e.updateSalary(7000);
		e.display();
		
		

	}

}
