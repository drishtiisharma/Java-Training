import java.util.Comparator;
import java.util.TreeSet;


class Employee{
	private String name;
	private double salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return name + "\t" + salary+"\n";
	}
}



class Comp implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		
		int diff=(int)(e2.getSalary()-e1.getSalary());
		if(diff==0) {
			diff=e1.getName().compareTo(e2.getName());
		}
		return diff;
		
	}
	
	
}
public class EmployeeLinkedHashMap {

	public static void main(String[] args) {
		Comp c=new Comp();
		
		TreeSet<Employee>t=new TreeSet<Employee>(c);
		t.add(new Employee("ramesh", 3000.0));
		t.add(new Employee("rakesh", 8000.0));
		t.add(new Employee("suresh", 12000.0));
		t.add(new Employee("mahendra", 25411.0));
		t.add(new Employee("gurmeet", 8412.0));
		t.add(new Employee("kajal", 5151.0));
		t.add(new Employee("rahul", 3000.0));
		t.add(new Employee("suresh", 12000.0));
		
		
		System.out.println(t);

	}

}
