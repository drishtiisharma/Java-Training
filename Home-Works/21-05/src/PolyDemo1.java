import java.util.Scanner;

abstract class Poly{
	public int a,b;
	abstract void op();
}

class Addition extends Poly{
	@Override
	void op() {
		System.out.println("sum: "+(a+b));
	}
}
class Subtraction extends Poly{
	@Override
	void op() {
		System.out.println("diff: "+(a-b));
	}
}
class Multiplication extends Poly{
	@Override
	void op() {
		System.out.println("prod: "+(a*b));
	}
}
class Division extends Poly{
	@Override
	void op() {
		System.out.println("quo: "+(a/b));
	}
}
public class PolyDemo1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a:");
		int a=sc.nextInt();
		System.out.println("enter b:");
		int b=sc.nextInt();
		
		Poly p;
		Addition o1=new Addition();
		Subtraction o2=new Subtraction();
		Multiplication o3=new Multiplication();
		Division o4=new Division();
		
		o1.a = a; 
		o1.b = b;
		
	    o2.a = a; 
	    o2.b = b;
	    
	    o3.a = a; 
	    o3.b = b;
	    
	    o4.a = a; 
	    o4.b = b;
		
		p=o1;
		p.op();

		p=o2;
		p.op();
		
		p=o3;
		p.op();
		
		p=o4;
		p.op();
		
		

	}

}
