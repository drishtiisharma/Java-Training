abstract class Pqr{
	 abstract void show();
	 void display() {
		 System.out.println("inside normal method");
	 }
}

class Xyz extends Pqr{

	@Override
	void show() {
		System.out.println("inside abstract method");
		
	}
	
}
public class AbstractDemo {

	public static void main(String[] args) {
		// Pqr p=new Pqr(); ->cannot instantiate "abstract" class
		Xyz x=new Xyz();
		x.show();
		x.display();
	}

}
