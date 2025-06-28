class Thread3 implements Runnable{
	int count=0;
	public void run() {
		synchronized(Thread3.class) {
			for(int i=0;i<5;i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" :"+count);
			}
		}
	}
	
}

public class ThreadSynchronization {

	public static void main(String[] args) {
		Thread3 a=new Thread3();
		Thread3 b=new Thread3();
		Thread3 c=new Thread3();
				
		Thread t1=new Thread(a);
		Thread t2= new Thread(b);
		Thread t3= new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
