interface SayHello1
{
	String printMsg(String msg);
}

public class LambdaExp3 {

	public static void main(String[] args) {
		
		SayHello1 h = new SayHello1()
		{
			public String printMsg(String msg)
			{
				return "Hello "+msg;
			}
		};
		System.out.println(h.printMsg("Rahul"));
		
	}

}
