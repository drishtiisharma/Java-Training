import java.util.ArrayList;
import java.util.Scanner;

public class SearchItemInArrayList {

	public static void main(String[] args) {
		ArrayList<String> c=new ArrayList<String>();
		c.add("BMW");
		c.add("Volkswagen");
		c.add("Audi");
		c.add("Dodge");
		c.add("Porsche");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the car u want to search: ");
		String car=sc.next();
		boolean found=false;
		for (int i=0;i<c.size();i++) {
			if(car.equalsIgnoreCase(c.get(i))) {
				System.out.println(car+" is found in the ArrayList!");
				found=true;
				
				break;
			}
		}
		if(!found) {
			System.out.println(car+" is not found in the ArrayList!");
		}
		

	}

}
