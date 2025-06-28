import java.util.Scanner;

class Student{
	int rollno;
	String name;
	double pmarks;
	double cmarks;
	double mathmarks;
	
	
	void getData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter rollno: ");
		rollno=sc.nextInt();
		System.out.println("enter name: ");
		name=sc.next();
		System.out.println("enter physics' marks: ");
		pmarks=sc.nextDouble();
		System.out.println("enter chemstry's marks: ");
		cmarks=sc.nextDouble();
		System.out.println("enter mathematics' marks: ");
		mathmarks=sc.nextDouble();
		
		sc.close();
	}
	
	void showData() {
		System.out.println();
		System.out.println("rollno: "+rollno);
		System.out.println("name: "+name);
		System.out.println("physics' marks: "+pmarks);
		System.out.println("chemistry's marks: "+cmarks);
		System.out.println("mathematics' marks: "+mathmarks);
	}
	
	void total() {
		System.out.println();
		double total=pmarks+cmarks+mathmarks;
		System.out.println("total of marks of all subjects: "+total);
	}
	
	void percentage() {
		System.out.println();
		double prc=(pmarks+cmarks+mathmarks)/3;
		System.out.println("percentage: "+prc);
		
	}
	
}
public class StudentClass {

	public static void main(String[] args) {
		
		Student s=new Student();
		s.getData();
		s.showData();
		s.total();
		s.percentage();
		

	}

}
