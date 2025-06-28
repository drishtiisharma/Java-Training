import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		
		HashMap<String, Double> hs = new HashMap<>();
		hs.put("Bhavesh", 10.0);
		hs.put("Ishika", 7.5);
		hs.put("Topi", 9.0);
		hs.put("Chhuti Singh", 7.0);
		hs.put("Ishika", 7.5);
		
		
		System.out.println(hs);
		System.out.println(hs.get("Bhavesh"));
		Double d = hs.get("Bhavesh");
		System.out.println(d);
		
		for(Map.Entry<String, Double> e: hs.entrySet())
		{
			System.out.println("key = "+e.getKey()
			+"\t"+"value = "+e.getValue());
		}

		hs.remove("Topi");
		System.out.println(hs);
	}

}
