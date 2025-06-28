import java.util.ArrayList;
public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(123.45);
		al.add("Rahul");
		
		System.out.println(al);
		
		for (Object object : al) {
			System.out.println(object);
		}

	}

}
