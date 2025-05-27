// This program is synchronized.

class Callme1
{
void call(String msg) 
{
System.out.print("[" + msg);
try
{
Thread.sleep(3000);
}
catch(InterruptedException e) 
{
System.out.println("Interrupted");
}
System.out.println("]");
}
}

class Caller1 implements Runnable 
{
String msg;
Callme1 target;
Thread t;
 Caller1(Callme1 targ, String s) 
{
this.target = targ;
this.msg = s;
this.t = new Thread(this);
this.t.start();
}
public void run() 
{
	synchronized (target)
	{
		this.target.call(this.msg);		
	}

}

}
class SynchronizationDemo1 
{
public static void main(String args[]) 
{
Callme1 target = new Callme1();

Caller1 ob1 = new Caller1(target, "Hello");
Caller1 ob2 = new Caller1(target, "Synchronized");
Caller1 ob3 = new Caller1(target, "World");
}
}