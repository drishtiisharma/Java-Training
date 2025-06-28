import java.util.ArrayList;

public class AddingElementInJavaArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList();
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(12);
		System.out.println("ArrayList before adding an element:\n" +al+"\n");
		al.add(2, 15);
		System.out.println("ArrayList after adding an element:\n" +al);

		
	}

}
