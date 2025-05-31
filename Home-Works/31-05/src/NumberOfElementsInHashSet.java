import java.util.HashSet;

public class NumberOfElementsInHashSet {

	public static void main(String[] args) {
		HashSet<String> h=new HashSet<String>();
		h.add("apple");
		h.add("banana");
		h.add("kiwi");
		h.add("avocado");
		h.add("grapes");
		int count=0;
		for(int i=0;i<h.size();i++) {
			count++;
		}
		System.out.println("hashset is:\n"+h);
		System.out.println("number of elements in the hashset using for loop: "+count);
		System.out.println("number of elements in the hashset using size: "+h.size());

	}

}
