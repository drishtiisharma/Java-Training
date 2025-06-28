import java.util.ArrayList;

public class ArrayListUsingForLoop {

	public static void main(String[] args) {
		ArrayList b=new ArrayList();
		b.add("Joyce");
		b.add("Akshay");
		b.add(12);
		b.add(15.6);
		b.add("Savitri");
		
		System.out.println("Printing ArrayList elements using For-Loop:");
		for(int i=0;i<b.size();i++) {
			System.out.println(b.get(i));
		}
		
		

	}

}
