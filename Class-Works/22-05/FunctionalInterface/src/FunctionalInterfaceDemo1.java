@FunctionalInterface
interface Hello
{
	void hello();
	default void show()
	{
		System.out.println("Inside Default Method");
	}
	static void sayHello()
	{
		System.out.println("Inside Static Method");
	}
}
class HelloImpl implements Hello
{
	public void hello()
	{
		System.out.println("Inside Abstract Method");
	}
}
public class FunctionalInterfaceDemo1 {

	public static void main(String[] args) {
		
		HelloImpl h = new HelloImpl();
		h.hello();
		h.show();
		
		Hello.sayHello();

	}

}
