package com.pkg2;

import com.pkg1.Super;

public class SubPkg2 extends Super{

	public SubPkg2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubPkg2(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}

	void show()
	{
//		System.out.println("private : "+a);
//		System.out.println("default : "+b);
		System.out.println("protected : "+c);
		System.out.println("public : "+d);
	}
}
