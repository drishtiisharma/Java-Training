import java.util.Comparator;
import java.util.TreeSet;

class Employee
{
	private int empId;
	private String empName;
	private double salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return empId + "\t" + empName + "\t" + salary+"\n";
	}
	
}

class EmpCmp implements Comparator
{

	@Override
	public int compare(Object ob1, Object ob2) {
		
		Employee e1 = (Employee)ob1;
		Employee e2 = (Employee)ob2;
		
		int diff =(int) (e2.getSalary()-e1.getSalary());
		if(diff==0)
			diff = e1.getEmpName().compareTo(e2.getEmpName());
		if(diff==0)
			diff = e1.getEmpId()-e2.getEmpId();
		return diff;
	}
	
}
public class EmployeeCmpDemo {

	public static void main(String[] args) {
		
		EmpCmp cmp = new EmpCmp();
		TreeSet<Employee>ts = new TreeSet<>(cmp);
		
		ts.add(new Employee(101,"Radhe",53000));
		ts.add(new Employee(102,"Mohan",43000));
		ts.add(new Employee(103,"Shyam",73000));
		ts.add(new Employee(104,"Geeta",53000));
		ts.add(new Employee(106,"Ankit",50000));
		ts.add(new Employee(105,"Ankit",50000));
		
		System.out.println(ts);

	}

}
