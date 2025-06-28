import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<String> al = new LinkedList();
		al.add(new String("Rahul"));
		al.add("Ankit");
		al.add("Shyam");
		al.add("Abhay");
		al.add("Bheem");
		al.add("Reeta");
		al.add("Meeta");
		al.add("Shyam");
		System.out.println("al.size() : "+al.size());
		System.out.println(al);
		
		al.remove("Abhay");
		al.remove(3);
		
		System.out.println("After deletion al.size() : "+al.size());
		System.out.println(al);
		
		al.set(1, "Mohan");
		System.out.println("After modification al.size() : "+al.size());
		System.out.println(al);
		
		System.out.println("Display by using index - loop : ");
		for(int i=0; i<al.size(); i++)
		{
			System.out.println(al.get(i));
		}
		System.out.println("Display by using for-each loop : ");
		for (String string : al) {
			
			System.out.println(string);
		}
		System.out.println("Display by using Iterator : ");
		
		Iterator<String>itr = al.iterator();
		while(itr.hasNext())
		{
			String s = itr.next();
			if(s.equals("Meeta"))
			{
				itr.remove();
			}
			System.out.println(s);
		}
		
		System.out.println(al);
	}

}
