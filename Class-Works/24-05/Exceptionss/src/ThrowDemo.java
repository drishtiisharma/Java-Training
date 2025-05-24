class Throw
{
	void exception(int x)
	{
		try {
			int a = 123/x;
			System.out.println("x = "+x);
		} 
		catch (ArithmeticException e)
		{
			System.out.println("catch first time");
			throw e;
		}
		
	}
}
public class ThrowDemo {

	public static void main(String[] args) {
		
		System.out.println("Hello.....!");
		Throw t = new Throw();
		try {
			t.exception(0);	
		} catch (ArithmeticException e) {
			System.out.println("catch second time");
		}
		

		System.out.println("Bye.......!");
	}

}
