import java.util.HashMap;

public class PrintingThroughHashList {

	public static void main(String[] args) {
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(101,"rahul");
		hm.put(102, "riya");
		hm.put(103, "mehul");
		hm.put(104, "kartik");
		hm.put(105, "khushi");
		
		System.out.println("printing elements through hashlist/hashmap:\n"+hm);
	}

}
