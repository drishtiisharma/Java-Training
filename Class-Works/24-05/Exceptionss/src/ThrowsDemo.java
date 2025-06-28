class Throws
{
	void exception(int x)throws ArithmeticException,
	ArrayIndexOutOfBoundsException,NumberFormatException
	{
		int a = 123/x;
		System.out.println("x = "+x);
		
		if(x==1)
		{
			int ar[]= {1,2,3};
			ar[5]=78;
		}
		if(x==2)
		{
			String s = "234vdg";
			int y = Integer.parseInt(s);
		}
		
	}
}
public class ThrowsDemo {

	public static void main(String[] args) {
		
		System.out.println("Hello.....!");
		Throws t = new Throws();
		try
		{
			t.exception(2);	
		}
		catch (Exception e) 
		{
			System.out.println("catch second time :"+e);
		}
		

		System.out.println("Bye.......!");
	}

}
