import java.util.TreeSet;

public class PrintingTreeSet {

	public static void main(String[] args) {
		TreeSet<String> t=new TreeSet<String>();
		t.add("blue");
		t.add("green");
		t.add("red");
		t.add("blue");
		t.add("green");
		t.add("red");
		t.add("blue");
		t.add("green");
		t.add("red");
		
		
		System.out.println("elemets of the tree set are:\n"+t);
		System.out.println("total numer of elements in the tree set: "+t.size());

	}

}
