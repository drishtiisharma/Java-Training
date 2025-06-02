import java.util.ArrayDeque;

public class ArrayDeQueDemo {

	public static void main(String[] args) {
		
		ArrayDeque<Integer>dq = new ArrayDeque<>();
		dq.add(10);
		dq.add(20);
		dq.add(30);
		dq.add(40);
		
		System.out.println(dq);
		dq.addFirst(5);
		dq.addLast(50);
		System.out.println(dq);
		
		System.out.println("dq.removeFirst() : "+dq.removeFirst());
		System.out.println("dq.removeLast() : "+dq.removeLast());
		
		System.out.println("dq.getFirst() : "+dq.getFirst());
		System.out.println("dq.getLast(): "+dq.getLast());
		
		

	}

}
