// 13.Write a program for polymorphism with add,sub,multi and div operation. user super and constructor.

import java.util.Scanner;

abstract class Poly2{
	public int a,b;
	
	Poly2(int first,int second){
		a=first;
		b=second;
	}
	
	abstract void op();
}

class Add extends Poly2{
	Add(int a, int b){
		super(a,b);
	}
	void op() {
		System.out.println("sum: "+(a+b));
	}
}


class Sub extends Poly2{
	Sub(int a, int b){
		super(a,b);
	}
	void op() {
		System.out.println("sub: "+(a-b));
	}
}


class Mul extends Poly2{
	Mul(int a, int b){
		super(a,b);
	}
	void op() {
		System.out.println("prod: "+(a*b));
	}
}


class Div extends Poly2{
	Div(int a, int b){
		super(a,b);
	}
	void op() {
		System.out.println("quo: "+(a/b));
	}
}

public class PolyDemo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a:");
		int a = sc.nextInt();
		System.out.println("enter b:");
		int b = sc.nextInt();
	
		Poly2 p;
		
		p = new Add(a, b);
		p.op();

		p = new Sub(a, b);
		p.op();

		p = new Mul(a, b);
		p.op();

		p = new Div(a, b);
		p.op();

	}

}
