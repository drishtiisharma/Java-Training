
public class StringDemo1 {

	public static void main(String[] args) {
		
		String s = "Rahul";
		System.out.println("s = "+s);
		System.out.println("s.hashCode():"+s.hashCode());
		
		s = s+" Sharma";
		System.out.println("s = "+s);
		System.out.println("s.hashCode():"+s.hashCode());
		
		String s2 = "Rahul";
		System.out.println("s2 = "+s2);
		System.out.println("s2.hashCode():"+s2.hashCode());
		
		
		String s3 = "Rahul Sharma";
		System.out.println("s3 = "+s3);
		System.out.println("s3.hashCode():"+s3.hashCode());
		
		
		

	}

}
