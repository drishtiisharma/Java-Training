@FunctionalInterface
interface SayHello11
{
	String printMsg(String msg);
}

public class LambdaExp4 {

	public static void main(String[] args) {
		
		SayHello11 s =(String msg)->{
			
			return "Hello "+msg;
		};
		System.out.println(s.printMsg("Shivam"));
		
		SayHello11 s1 =(msg)->{
			
			return "Hello "+msg;
		};
		System.out.println(s1.printMsg("Shivam Bhiya"));
		
		SayHello11 s2 =(msg)->("Hello "+msg);
		System.out.println(s1.printMsg("Rahul Bhiya"));
	}

}
