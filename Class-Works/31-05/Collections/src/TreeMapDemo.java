import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Product11
{
	private String pName;
	private double price;
	public Product11() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product11(String pName, double price) {
		super();
		this.pName = pName;
		this.price = price;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return pName + "\t" + price;
	}
	
}


public class TreeMapDemo {

	public static void main(String[] args) {
		
		TreeMap<Integer, Product11>hs = new TreeMap<>();
		
		hs.put(101, new Product11("Mic",1250));
		hs.put(105, new Product11("Key Board",650));
		hs.put(102, new Product11("Mouse",450));
		hs.put(104, new Product11("RAM",1150));
		hs.put(103, new Product11("ROM",3250));
		hs.put(101, new Product11("SSD",2250));
		
		//System.out.println(hs);
		
		for(Map.Entry<Integer, Product11> e : hs.entrySet())
		{
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		

	}

}
