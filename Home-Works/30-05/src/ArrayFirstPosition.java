import java.util.ArrayList;

public class ArrayFirstPosition {

	public static void main(String[] args) {
		ArrayList<Integer> n=new ArrayList<Integer>();
		n.add(1);
		n.add(2);
		n.add(3);
		n.add(4);
		n.add(5);
		System.out.println("Before inserting element at 1st position:\n"+n+"\n");
		n.add(0, 0);
		System.out.println("After inserting element at 1st position:\n"+n);

	}

}
