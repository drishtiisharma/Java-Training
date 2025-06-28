import java.util.Iterator;
import java.util.TreeSet;

public class NumberOfElementsInTreeSet {

	public static void main(String[] args) {
		TreeSet<String> s=new TreeSet<String>();
		s.add("abhay");
		s.add("helen");
		s.add("hariom");
		s.add("grey");
		s.add("khushi");
		s.add("blue");
		s.add("yellow");
		s.add("blue");
		
		System.out.println("number of elements using size: "+s.size()+"\n");
		
		int count=0;
		Iterator<String> itr=s.iterator();
		while(itr.hasNext()) {
			itr.next();
			count++;
		}
		System.out.println("number of elements using iterator: "+count++);
		
		
		int count1=0;
		for (String string : s) {
			count1++;
		}
		System.out.println("\nnumber of elements using for each loop: "+count1);

	}

}
