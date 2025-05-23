class Product
{
	private int pId;
	private String pName;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pId, String pName, double price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
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
		System.out.println("Inside toString Method");
		return  pId + "\t" + pName + "\t" + price;
	}
	
	
}
public class ProductDemo {

	public static void main(String[] args) {
		
		Product p1 = new Product(101, "Keyboard", 750);
		
		Product p2 = new Product();
		p2.setpId(102);
		p2.setpName("Mouse");
		p2.setPrice(380);
		
		System.out.println("p1.getpId():"+p1.getpId());
		System.out.println("p1.getpName():"+p1.getpName());
		System.out.println("p1.getPrice():"+p1.getPrice());
		
		System.out.println("p2 = "+p2.toString());
	}

}
