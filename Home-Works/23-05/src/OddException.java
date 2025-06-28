class Odd{
	static void checkEven(int n) throws Exception {
		if(n%2==0) {
			System.out.println("number is even!");
		}
		else {
			throw new Exception ("number is odd");
		}
	}
}
public class OddException {

	public static void main(String[] args) {
		try {
			Odd.checkEven(10);
			Odd.checkEven(3);
		}
		catch(Exception e) {
			System.out.println("exception caught: "+e);
		}


	}

}
