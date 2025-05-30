import java.util.ArrayList;
import java.util.Collections;

public class ShuffleArrayList {

	public static void main(String[] args) {
		ArrayList<String>q=new ArrayList<String>();
		q.add("Alligator");
		q.add("Bear");
		q.add("Cat");
		q.add("Dog");
		q.add("Elephant");
		q.add("Fox");
		System.out.println("ArrayList before shuffling:\n"+q+"\n");
		Collections.shuffle(q);
		System.out.println("ArrayList after shuffling:\n"+q);

	}

}
