package com.pkg1;

public class MainPkg1 {

	public static void main(String[] args) {
		Super sup = new Super(10,20,30,40);
		sup.show();
		
		SubPkg1 sub = new SubPkg1(100, 200, 300, 400);
		sub.show1();
		
		//System.out.println("private : "+sup.a);
		System.out.println("default : "+sup.b);
		System.out.println("protected : "+sup.c);
		System.out.println("public : "+sup.d);
		
	}

}
