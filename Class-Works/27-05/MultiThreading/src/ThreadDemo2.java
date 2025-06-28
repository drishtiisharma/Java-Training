class A1 implements Runnable
{
	public void run()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println("i = "+i);
		}
	}
}

class B1 implements Runnable
{
	public void run()
	{
		for(int j=1; j<=10; j++)
		{
			System.out.println("j = "+j);
		}
	}
}

class C1 implements Runnable
{
	public void run()
	{
		for(int k=1; k<=10; k++)
		{
			System.out.println("k = "+k);
		}
	}
}

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		A1 a = new A1();
		B1 b = new B1();
		C1 c = new C1();
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		
		

	}

}
