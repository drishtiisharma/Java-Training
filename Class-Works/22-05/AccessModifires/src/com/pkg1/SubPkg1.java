package com.pkg1;

public class SubPkg1 extends Super{

	public SubPkg1() {
		super();
	}

	public SubPkg1(int a, int b, int c, int d) {
		super(a, b, c, d);//Super(1,1,1,1)
	}
	void show1()
	{
		//System.out.println("private : "+a);
		System.out.println("default : "+b);
		System.out.println("protected : "+c);
		System.out.println("public : "+d);
	}
	
}
