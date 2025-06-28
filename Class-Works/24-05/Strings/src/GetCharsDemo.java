
public class GetCharsDemo {

	public static void main(String[] args) {
		
		String s="This is the demo of getChars method.";
		char ch[] = new char[5];
		
		s.getChars(12, 16, ch, 0);
		for (char c : ch) {
		System.out.println(c);	
		}
		

	}

}
