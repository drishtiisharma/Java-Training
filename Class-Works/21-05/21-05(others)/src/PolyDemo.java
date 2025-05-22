class Base{
	void show() {
		System.out.println("inside base class");
	}
}

class Drv1 extends Base{
	void show() {
		System.out.println("inside drv1");
	}
}

class Drv2 extends Base{
	void show() {
		System.out.println("inside drv2");
	}
}

class Drv3 extends Base{
	void show() {
		System.out.println("inside drv3");
	}
}

public class PolyDemo {

	public static void main(String[] args) {
		//Base b; ->reference object(pointer)
		Base b;
		Drv1 d1=new Drv1();
		Drv2 d2=new Drv2();
		Drv3 d3=new Drv3();
		
		b=d1;
		b.show();
		
		b=d2;
		b.show();
		
		b=d3;
		b.show();
	}

}
