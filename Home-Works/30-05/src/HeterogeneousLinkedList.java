import java.util.LinkedList;

public class HeterogeneousLinkedList {

	public static void main(String[] args) {
		LinkedList g=new LinkedList();
		g.add("new");
		g.add(10);
		g.add("active");
		g.add(20);
		g.add("blocked/waiting");
		g.add(12.21);
		g.add("timed waiting");
		g.add(3000);
		g.add("terminated");
		g.add(0);
		System.out.println("Heterogeneous Linked List:\n"+g);
	}

}
