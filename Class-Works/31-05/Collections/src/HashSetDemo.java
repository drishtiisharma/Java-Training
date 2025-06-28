import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet<String>hs = new HashSet<>();
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
