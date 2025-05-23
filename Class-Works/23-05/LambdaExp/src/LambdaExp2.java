interface SayHello
{
	String printMsg(String msg);
}
class SayHelloImpl implements SayHello
{
	public String printMsg(String msg)
	{
		return "Hello "+msg;
	}
}
public class LambdaExp2 {

	public static void main(String[] args) {
		
		SayHelloImpl s = new SayHelloImpl();
		System.out.println(s.printMsg("Raj Kumar"));

	}

}
