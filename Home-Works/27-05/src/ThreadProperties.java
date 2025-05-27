class Properties implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"'s properties:"+Thread.currentThread());
	}
}
public class ThreadProperties {

	public static void main(String[] args) {
		Properties p=new Properties();
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		Thread t3=new Thread(p);
		Thread t4=new Thread(p);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.setName("first thread");
		t2.setName("second thread");
		t3.setName("third thread");
		t4.setName("fourth thread");
		
		t1.setPriority(4);
		t2.setPriority(2);
		t3.setPriority(1);
		t4.setPriority(2);
		
		
	

	}

}
