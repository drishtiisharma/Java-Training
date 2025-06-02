import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Product1
{
	private String pName;
	private double price;
	public Product1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product1(String pName, double price) {
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


public class LinkedHashMapDemo {

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, Product1>hs = new LinkedHashMap();
		
		hs.put(101, new Product1("Mic",1250));
		hs.put(105, new Product1("Key Board",650));
		hs.put(102, new Product1("Mouse",450));
		hs.put(104, new Product1("RAM",1150));
		hs.put(103, new Product1("ROM",3250));
		hs.put(101, new Product1("SSD",2250));
		
		//System.out.println(hs);
		
		for(Map.Entry<Integer, Product1> e : hs.entrySet())
		{
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		

	}

}
