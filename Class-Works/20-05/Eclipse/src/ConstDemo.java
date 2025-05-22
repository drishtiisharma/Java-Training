class Counter{
	int count; //instance variable
	
	Counter(){ //no argument constructor
		System.out.println("**no arguments constructor**");
		count=0;
	}
	
	Counter(int count){//local variable
		System.out.println("**one argument constructor**");
		this.count= count;
	}
	
	
	void show() {
		System.out.println("count: "+count);
	}
	
	void increment() {
		count++;
	}
	
	void decrement() {
		count--;
	}
	
}
public class ConstDemo {

	public static void main(String[] args) {
		Counter c1= new Counter();
		c1.show();
		Counter c2=new Counter(10);
		c2.show();
		
		c1.increment();
		c2.decrement();
		c1.show();
		c2.show();
	}
}
