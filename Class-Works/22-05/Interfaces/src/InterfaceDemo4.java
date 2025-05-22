interface Greeting
{
	void greet();
}

class Hindi implements Greeting
{
	public void greet()
	{
		System.out.println("Namaskar......!");
	}
}
class English implements Greeting
{
	public void greet()
	{
		System.out.println("Hello..........!");
	}
}

class Gujarati implements Greeting
{
	public void greet()
	{
		System.out.println("Jai Shri Krishna.!");
	}
}

public class InterfaceDemo4 {

	public static void main(String[] args) {
		
		Greeting g;
		
		g = new Hindi();  //passing referencer of const
		g.greet();
		
		g = new English();
		g.greet();
		
		g = new Gujarati();
		g.greet();
		

	}

}
