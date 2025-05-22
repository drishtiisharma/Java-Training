package pkg2;

import pkg1.A;

public class B extends A{
	public void show() {
		System.out.println("this is class B from package 2, subclass of A ");
	}
	public static void main(String[] args) {
		B b=new B();
		b.display();
		b.show();
	}

}
