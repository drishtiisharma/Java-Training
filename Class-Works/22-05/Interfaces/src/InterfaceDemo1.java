interface Power
{
	int p=2;
	double square(double x);
}
class PowerImpl implements Power
{

	public double square(double x) 
	{
		return Math.pow(x, p);
	}
	
}
public class InterfaceDemo1 {

	public static void main(String[] args) {
		
		PowerImpl p = new PowerImpl();
		double pow = p.square(5);
		System.out.println("Square = "+pow);

	}

}
