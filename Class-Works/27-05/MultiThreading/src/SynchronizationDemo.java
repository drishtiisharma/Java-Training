// This program is not synchronized.

class Callme
{
void call(String msg) 
{
System.out.print("[" + msg);
try
{
Thread.sleep(1000);
}
catch(InterruptedException e) 
{
System.out.println("Interrupted");
}
System.out.println("]");
}
}


class Caller implements Runnable 
{
String msg;
Callme target;
Thread t;
Caller(Callme targ, String s) 
{
this.target = targ;
this.msg = s;
this.t = new Thread(this);//Thread t = new Thread(runnable)

this.t.start();
}
public void run() 
{
this.target.call(this.msg);
}

}
class SynchronizationDemo 
{
public static void main(String args[]) 
{
Callme target = new Callme();

Caller ob1 = new Caller(target, "Hello");
Caller ob2 = new Caller(target, "Synchronized");
Caller ob3 = new Caller(target, "World");
}
}