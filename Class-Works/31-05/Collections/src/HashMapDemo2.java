import java.util.HashMap;
import java.util.Map;

class Product
{
	private String pName;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String pName, double price) {
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


public class HashMapDemo2 {

	public static void main(String[] args) {
		
		HashMap<Integer, Product>hs = new HashMap<>();
		
		hs.put(101, new Product("Mic",1250));
		hs.put(105, new Product("Key Board",650));
		hs.put(102, new Product("Mouse",450));
		hs.put(104, new Product("RAM",1150));
		hs.put(103, new Product("ROM",3250));
		hs.put(101, new Product("SSD",2250));
		
		//System.out.println(hs);
		
		for(Map.Entry<Integer, Product> e : hs.entrySet())
		{
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		

	}

}
