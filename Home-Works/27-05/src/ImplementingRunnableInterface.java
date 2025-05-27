import java.util.Scanner;

class MyRunnable implements Runnable{
	public void run() {
		int age;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your age: ");
		age= sc.nextInt();
		System.out.println((age>=18)? "you can vote": "you cannot vote");
	}
	
}
public class ImplementingRunnableInterface {

	public static void main(String[] args) {
		MyRunnable r=new MyRunnable();
		Thread t=new Thread(r);
		t.start();
	}

}
