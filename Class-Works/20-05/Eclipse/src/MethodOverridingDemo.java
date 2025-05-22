class Super{
	void show() {
		System.out.println("inside super class");
	}
}

class Sub extends Super{
	super.show();
	void show() { //method overriding
		System.out.println("inside sub class");
	}
}
public class MethodOverridingDemo {

	public static void main(String[] args) {
		Sub s=new Sub();
		s.show();	

	}

}
