import java.util.Scanner;

public class ExDemo2 {

	public static void main(String[] args) {
	
		System.out.println("Hello.....!");
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a value :");
		n = s.nextInt();
		try 
		{
			int x = 123/n;
			System.out.println("x = "+x);	
		}
		catch (ArithmeticException e) 
		{
			System.out.println("zero input not allowed");
		}		
		System.out.println("Bye........!");
	}
}
