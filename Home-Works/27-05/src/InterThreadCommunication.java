class Shared{
	int n;
	boolean valueSet = false;

	synchronized int get() {
		while(!valueSet) {
			try {
				wait();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("got: " + n);
		valueSet = false;
		notify();
		return n;

	}

	synchronized void put(int x) {
		while(valueSet) {
			try {
				wait();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		this.n=x;
		valueSet=true;
		System.out.println("put: "+n);
		notify();
	}
}

class Producer implements Runnable{
	Shared s;

	public Producer(Shared s) {
		super();
		this.s = s;
		Thread t=new Thread(this,"Producer");
		t.start();
	}
	public void run() {
		int i=0;
		while(true) {
			s.put(i++);
		}
	}
}

class Consumer implements Runnable{
	Shared s;

	public Consumer(Shared s) {
		super();
		this.s = s;
		Thread t=new Thread(this,"Consumer");
		t.start();
	}
	public void run() {
		while(true) {
			s.get();
		}
	}
}
public class InterThreadCommunication {

	public static void main(String[] args) {
		Shared s=new Shared();
		new Producer(s);
		new Consumer(s);
	}
}

