interface A
{
	void show();
}
interface B extends A
{
	void displya();
}
class BImpl implements B
{

	@Override
	public void show() {
		System.out.println("Inside show");		
	}

	@Override
	public void displya() {
		System.out.println("Inside Dipslay");
		
	}
	
}
public class InterfaceDemo2 {

	public static void main(String[] args) {
		
		BImpl b = new BImpl();
		b.show();
		b.displya();

	}

}
