
interface Addition
{
	int add(int x, int y);
}
class AdditionImpl implements Addition
{
	public int add(int x,int y)
	{
		return x+y;
	}
}
public class FunctionalInterfaceDemo2 {

	public static void main(String[] args) {
		
		AdditionImpl a = new AdditionImpl();
		System.out.println("Sum = "+a.add(10, 20));

	}

}
