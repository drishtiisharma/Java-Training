import java.util.ArrayList;

public class RemovingElementFromArrayList {

	public static void main(String[] args) {
		ArrayList<String> al1=new ArrayList();
		al1.add("Apple");
		al1.add("Banana");
		al1.add("Cherry");
		al1.add("Laptop");
		al1.add("Dragon Fruit");
		System.out.println("ArrayList before removing an element:\n"+al1+"\n");
		al1.remove(3);
		System.out.println("ArrayList after removing an element:\n"+al1);
		

	}

}
