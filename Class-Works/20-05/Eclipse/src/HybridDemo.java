class A1{
	void show() {
		System.out.println("inside A");
	}
}

class B1 extends A1{
	
	void show1() {
		System.out.println("inside B");
	}
}

class C1 extends A1{
	
	void show2() {
		System.out.println("inside C");
	}
}

class D1 extends B1{
	
	void show3() {
		System.out.println("inside D");
	}
}

public class HybridDemo {

	public static void main(String[] args) {
		A1 a=new A1();
		B1 b=new B1();
		C1 c=new C1();
		D1 d=new D1();
		
				
		a.show();
		b.show();
		b.show1();
		c.show();
		c.show2();
		d.show();
		d.show1();
		d.show3();

	}

}
