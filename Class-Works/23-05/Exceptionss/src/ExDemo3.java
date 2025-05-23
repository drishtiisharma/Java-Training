import java.util.Scanner;

public class ExDemo3 {

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
			if(n==1)
			{
				int ar[] = {1,2,3};
				ar[5] = 56;
			}
		}
		catch (ArithmeticException e) 
		{
			System.out.println("zero input not allowed : "+e);
		}		
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Array Index Exceeeedddd : "+e);
		}		
		System.out.println("Bye........!");
	}
}
