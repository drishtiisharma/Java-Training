import java.util.Scanner;

public class ExDemo6 {

	public static void main(String[] args) {
	
		System.out.println("Hello.....!");
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a value :");
		n = s.nextInt();
		try 
		{
			if(n==0)
			{
				//throw new RuntimeException("5 is not allowed");
				throw new ArithmeticException("0 is not allowed");
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}		
		System.out.println("Bye........!");
	}
}
