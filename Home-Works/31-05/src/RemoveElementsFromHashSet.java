import java.util.HashSet;

public class RemoveElementsFromHashSet {

	public static void main(String[] args) {
		HashSet<String> h=new HashSet<String>();
		h.add("apple");
		h.add("banana");
		h.add("kiwi");
		h.add("avocado");
		h.add("grapes");
		h.add("pineapple");
		h.add("mango");
		h.add("peach");
		h.add("litchi");
		
		System.out.println("hashset before deleting all elements:\n"+h);
		System.out.println("number of elements in the hashset before deletion is: "+h.size()+"\n");
		h.clear();
		System.out.println("hashset before deleting all elements:\n"+h);
		System.out.println("number of elements in the hashset after deletion is: "+h.size());
		
	
	}

}
