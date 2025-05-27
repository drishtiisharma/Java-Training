class A extends Thread
{
	public void run()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println("i = "+i);
		}
	}
}

class B extends Thread
{
	public void run()
	{
		for(int j=1; j<=10; j++)
		{
			System.out.println("j = "+j);
		}
	}
}

class C extends Thread
{
	public void run()
	{
		for(int k=1; k<=10; k++)
		{
			System.out.println("k = "+k);
		}
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		a.start();
		b.start();
		c.start();
		
		

	}

}
