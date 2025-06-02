import java.util.Comparator;
import java.util.TreeSet;

class StrCmp implements Comparator
{

	@Override
	public int compare(Object ob1, Object ob2) 
	{
		
		String str1 = (String)ob1;
		String str2 = (String)ob2;
		//int diff = str1.compareTo(str2);
		int diff = str2.compareTo(str1);
		
		return diff;
	}
	
}
public class StringCmpDemo {

	public static void main(String[] args) {
		
		StrCmp cmp = new StrCmp();
		TreeSet ts = new TreeSet<>(cmp);
		
		ts.add("Radhe");
		ts.add("Ankit");
		ts.add("Mohan");
		ts.add("Shyam");
		ts.add("Geeta");
		ts.add("Babblu");
		ts.add("Dabblu");
		
		System.out.println(ts);
		
		

	}

}
