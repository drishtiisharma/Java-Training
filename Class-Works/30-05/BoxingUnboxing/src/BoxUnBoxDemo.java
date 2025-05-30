
public class BoxUnBoxDemo {

	public static void main(String[] args) {
		
		//before jdk1.5
		int a = 10;
		Integer i = new Integer(a);
		int b = i.intValue();
		
		//After jdk1.5
		
		int x = 20;
		Integer j = x;// Autoboxing
		
		
		int y = j;//Unboxing
		

	}

}
