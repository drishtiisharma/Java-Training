class A{
	void show() {
		System.out.println("inside A");
	}
}

class B extends A{
	
	void show1() {
		System.out.println("inside B");
	}
}
public class SingleLevelDemo {

	public static void main(String[] args) {
		A a=new A();
		B b=new B();
		
		a.show();
		b.show();
		b.show1();

	}

}
