package com.pkg1;

public class Super {

	private int a;
	int b;
	protected int c;
	public int d;
	public Super() {
		
	}
	public Super(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	void show()
	{
		System.out.println("private : "+a);
		System.out.println("default : "+b);
		System.out.println("protected : "+c);
		System.out.println("public : "+d);
	}
}
