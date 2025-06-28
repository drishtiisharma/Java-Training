import java.util.Scanner;

public class AdditionDemo {

	public static void main(String[] args) {
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter value of a:");
		a=sc.nextInt();
		System.out.println("enter value of b:");
		b=sc.nextInt();
		
		c=a+b;
		System.out.println("sum: "+c);
		sc.close();
	}
	

}
