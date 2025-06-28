
class Q 
{
int n=0;
synchronized int get() 
{
System.out.println("Got: " + n);
return n;
}
synchronized void put(int x) 
{
this.n = x;
System.out.println("Put: " + n);
}
}
class Producer implements Runnable 
{
Q q;
Producer(Q q) 
{
this.q = q;
Thread t = new Thread(this, "Producer");
t.start();
}
public void run() 
{
int i = 0;
while(true) 
{
this.q.put(i++);
}
}
}
class Consumer implements Runnable 
{
Q q;
Consumer(Q q) 
{
this.q = q;
new Thread(this, "Consumer").start();
}
public void run() 
{
while(true) 
{
q.get();
}
}
}
class PC 
{
public static void main(String args[]) 
{
Q q = new Q();
Producer p =  new Producer(q);
Consumer c =  new Consumer(q);
System.out.println("Press Control-C to stop.");
}
}
