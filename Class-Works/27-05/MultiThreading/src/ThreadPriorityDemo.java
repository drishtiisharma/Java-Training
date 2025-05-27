class A11 implements Runnable
{
	public void run()
	{
		System.out.println(Thread.currentThread());
		for(int i=1; i<=10; i++)
		{
			System.out.println("i = "+i);
		}
	}
}

class B11 implements Runnable
{
	public void run()
	{
		System.out.println(Thread.currentThread());
		for(int j=1; j<=10; j++)
		{
			System.out.println("j = "+j);
		}
	}
}

class C11 implements Runnable
{
	public void run()
	{
		System.out.println(Thread.currentThread());
		for(int k=1; k<=10; k++)
		{
			System.out.println("k = "+k);
		}
	}
}

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		
		Thread t = Thread.currentThread();
		A11 a = new A11();
		B11 b = new B11();
		C11 c = new C11();
		
		Thread.currentThread().setPriority(7);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(c);
		
		System.out.println("t1 = "+t1);
		System.out.println("t2 = "+t2);
		System.out.println("t3 = "+t3);
		
		t1.setPriority(2);
		t2.setPriority(6);
		t3.setPriority(9);
		
		System.out.println("t1.getPriority() : "+t1.getPriority());
		System.out.println("t2.getPriority() : "+t2.getPriority());
		System.out.println("t3.getPriority() : "+t3.getPriority());
		
		t1.setName("Anushk Thread");
		t2.setName("Parag Thread");
		t3.setName("Charu Thread");
		
		System.out.println("t1.getName(): "+t1.getName());
		System.out.println("t2.getName(): "+t2.getName());
		System.out.println("t3.getName(): "+t3.getName());
		
		System.out.println("t1.getId() : "+t1.getId());
		System.out.println("t2.getId() : "+t2.getId());
		System.out.println("t3.getId() : "+t3.getId());
		
		t1.start();
		t2.start();
		t3.start();
		
		

	}

}
