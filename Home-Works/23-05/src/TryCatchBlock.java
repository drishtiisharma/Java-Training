//1.Write a Java program that throws an exception and catch it using a try-catch block.

import java.util.Scanner;

public class TryCatchBlock {

	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		n=sc.nextInt();

		try {
			int res=1523/n;
			System.out.println("result: "+res);
		}
		catch(ArithmeticException a) {
			System.out.println("the denominator must not be 0!");
		}
		
		
		

	}

}
