import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue q = new PriorityQueue<>();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(60);
		
		System.out.println(q);
		for (Object object : q) {
			System.out.println(object);
		} 

	}

}
