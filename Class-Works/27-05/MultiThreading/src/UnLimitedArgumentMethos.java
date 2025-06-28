

class X
{
	void show(int...is)
	{
		System.out.println("is.length:"+is.length);
		int avg=0;
		for (int i : is) {
			avg = avg+i;
		}
		System.out.println("Avg = "+avg/5);
	}
}
public class UnLimitedArgumentMethos 
{

	public static void main(String[] args) 
	{
		X a = new X();
		a.show(1,2,3,4,5);

	}

}
