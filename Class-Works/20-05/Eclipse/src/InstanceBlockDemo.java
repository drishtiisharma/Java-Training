class Hello{
	static int x;
	Hello(){
		x=10;
		System.out.println("inside constructor: "+x);
	}
	static { //static block
		x=15;
		System.out.println("inside static block: "+x);
	}
	
	{//instance block: runs first
		x=20;
		System.out.println("inside instance block: "+x);
	}
	static void show() { //static method
		x=5;
		System.out.println("inside static method: "+x);
		
	}
}
public class InstanceBlockDemo {

	public static void main(String[] args) {
		Hello h=new Hello();
		

	}

}
