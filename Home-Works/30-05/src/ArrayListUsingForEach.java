import java.util.ArrayList;

public class ArrayListUsingForEach {

	public static void main(String[] args) {
		ArrayList<String> s=new ArrayList<String>();
		s.add("Physics");
		s.add("Chemistry");
		s.add("Mathematics");
		s.add("Computer Science");
		s.add("Information Practices");
		s.add("Robotics");
		s.add("Artificial Intelligence");
		System.out.println("Printing ArrayList using For-Each loop:");
		for (String string : s) {
			System.out.println(string);
		}

	}

}
