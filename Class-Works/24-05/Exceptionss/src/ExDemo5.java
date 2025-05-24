import java.util.Scanner;

public class ExDemo5 {

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
			if(n==2)
			{
				String ss = "123a";
				int y = Integer.parseInt(ss);
			}
		}
		catch (Exception e) 
		{
			System.out.println("catch by universal catch block : "+e);
		}		
		finally
		{
		System.out.println("I Will Execute Always.");	
		}
		System.out.println("Bye........!");
	}
}
