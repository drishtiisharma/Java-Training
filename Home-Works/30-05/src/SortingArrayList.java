import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> i=new ArrayList<Integer>();
		i.add(21);
		i.add(0);
		i.add(95);
		i.add(10);
		i.add(45);
		i.add(34);
		i.add(3);
		i.add(56);
		System.out.println("ArrayList before sorting:\n"+i+"\n");
		Collections.sort(i);
		System.out.println("ArrayList after sorting:\n"+i);
		

	}

}
