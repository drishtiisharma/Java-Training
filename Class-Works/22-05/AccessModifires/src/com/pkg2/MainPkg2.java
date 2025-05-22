package com.pkg2;

import com.pkg1.Super;

public class MainPkg2 {

	public static void main(String[] args) {
		
		SubPkg2 sub = new SubPkg2(1,2,3,4);
		
		sub.show();
		Super sup = new Super(5,10,15,20);
		
//		System.out.println("private : "+sup.a);
//		System.out.println("default : "+sup.b);
//		System.out.println("protected : "+sup.c);
		System.out.println("public : "+sup.d);

	}

}
