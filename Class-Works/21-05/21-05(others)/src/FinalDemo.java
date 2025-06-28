final class Final{
	final void show() {
		System.out.println("hello...");
	}
}

class FinalSub extends Final{
	void show() { //cannot override final method
		System.out.println("hello by sub..");
	}
} // cannot inherit final class
public class FinalDemo {

	public static void main(String[] args) {
		final int a=10; //final variable cannot be changed
		a=20; 
		

	}

}
