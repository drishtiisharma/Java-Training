import java.util.Iterator;
import java.util.TreeSet;

public class IterateThroughAllElementsOfTreeSet {

	public static void main(String[] args) {
		TreeSet<String>u=new TreeSet<String>();
		u.add("ankit");
		u.add("maya");
		u.add("john");
		u.add("ramesh");
		u.add("jitendra");
		u.add("stuti");
		u.add("john");
		
		System.out.println("iterating using iterator:");
		Iterator itr=u.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("iterating using for each loop");
		for (String obj : u) {
			System.out.println(obj);
		}
		
		

	}

}
