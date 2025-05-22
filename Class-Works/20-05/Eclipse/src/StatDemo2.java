class StaticBlock{
	static int a; //static data member
	
	static { //static block: runs only once
		a=5;
		System.out.println("inside static block");
		
	}
	static void show(int x) { //static member method
		System.out.println("a= "+a);
		System.out.println("x= "+x);
	}
	
}
public class StatDemo2 {

	public static void main(String[] args) {
		StaticBlock.show(5);
		StaticBlock.show(6);
		StaticBlock.show(7);

	}

}
