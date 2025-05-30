import java.util.ArrayList;

public class RemovingThirdElementFromArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> x=new ArrayList<Integer>();
		x.add(2);
		x.add(4);
		x.add(6);
		x.add(7);
		x.add(8);
		x.add(10);
		x.add(12);
		x.add(14);
		System.out.println("ArrayList before removal:\n"+x+"\n");
		x.remove(3);
		System.out.println("ArrayList after removal:\n"+x);
		

	}

}
