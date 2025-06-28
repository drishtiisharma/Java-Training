
interface Addition1
{
	int add(int x, int y);
}
public class FunctionalInterfaceDemo3 {

	public static void main(String[] args) {
		

		Addition1 ad = new Addition1()
		{//anonymous inner class
			public int add(int x,int y)  //method reference
			{
				return x+y;
			}
		};
		
		System.out.println("Sum = " +ad.add(100, 200));
		
		Addition1 ad1 = new Addition1()
		{//anonymous inner class
			public int add(int x,int y)  //method reference
			{
				return x+y;
			}
		};
		
		System.out.println("Sum = " +ad1.add(1000, 2000));
	}

}
