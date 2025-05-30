import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack<Integer>stk = new Stack<>();
		
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		System.out.println(stk);
		System.out.println("stk.pop() : "+stk.pop());
		System.out.println(stk);
		
		stk.push(60);
		System.out.println(stk);
		System.out.println(stk.peek());
		
		System.out.println("Display by using for-each loop:");
		for (Integer integer : stk) {
			System.out.println(integer);
		}
		
		
		
		
		
	}

}

