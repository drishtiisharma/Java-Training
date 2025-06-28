class MyThread extends Thread{
	public void run() {
		for(int i=0;i<=10;i++) {
			if(i%2!=0) {
				System.out.println(i);
			}
		}
	}
}
public class ExtendingThreadClass {

	public static void main(String[] args) {
		MyThread t1=new MyThread();
		System.out.println("priority of "+t1.getName()+" :"+t1.getPriority());
		t1.start();
	}

}
