import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDeno {

	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector();
		v.addElement(30);
		v.addElement(10);
		v.addElement(40);
		v.addElement(30);
		v.addElement(20);
		v.addElement(50);
		v.addElement(60);
		v.add(709);
		v.add(3, 100);
		System.out.println("v.size() : "+v.size());
		System.out.println(v);
		
		v.remove(1);
		Integer x = 20;
		v.remove(x);
		System.out.println("After Deletion v.size() : "+v.size());
		System.out.println(v);
		
		v.set(4, x);
		System.out.println("After Modification v.size() : "+v.size());
		System.out.println(v);
		
		System.out.println("Display by using index loop :");
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		System.out.println("Display by using for-each loop :");
		for (Integer integer : v) {
			System.out.println(integer);
		}
		
		System.out.println("Display by using iterator loop :");
		Iterator<Integer>itr = v.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		System.out.println("Display by using Enumaration loop :");
		Enumeration<Integer>e = v.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
	}

}
