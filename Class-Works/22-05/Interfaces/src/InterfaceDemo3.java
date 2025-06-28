interface A1
{
	void show();
}
interface B1
{
	void displya();
}
class ABImpl implements A,B
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
public class InterfaceDemo3 {

	public static void main(String[] args) {
		
		ABImpl b = new ABImpl();
		b.show();
		b.displya();

	}

}
