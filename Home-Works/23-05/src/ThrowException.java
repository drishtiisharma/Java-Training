import java.util.Scanner;
class Age{
	static void verify(int age) {
		if(age<18) {
			throw new ArithmeticException("youre not eligible");
		}
		else {
			System.out.println("youre eligible");
		}
		
	}
}
public class ThrowException {

	public static void main(String[] args) {
		try {
			Age.verify(13);
		}
		catch(Exception e) {
			System.out.println("exception caught: "+e);
		}

	}

}
