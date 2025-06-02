import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		
		TreeSet<String>hs = new TreeSet();
		hs.add("Radhe");
		hs.add("Mohan");
		hs.add("Shyam");
		hs.add("Bihari");
		hs.add("Radhe");
		hs.add("Ankit");
		System.out.println(hs);
		
		System.out.println("Display by using for-each loop :");
		
		for (String string : hs) {
			System.out.println(string);
		}
		System.out.println("Display by using iterator loop :");
		Iterator<String>itr = hs.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		hs.remove("Radhe");
		System.out.println("After deletion hs.size() :" +hs.size());
		System.out.println(hs);
		

	}

}
