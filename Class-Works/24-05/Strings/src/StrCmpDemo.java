
public class StrCmpDemo {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "GoodBye";
		String s4 = "HELLO";
		
		System.out.println("s1.equals(s2): "+s1.equals(s2));//compare value / boolean
		System.out.println("s1.equals(s3): "+s1.equals(s3));
		System.out.println("s1.equals(s4): "+s1.equals(s4));
		System.out.println("s1.equals(s4): "+s1.equalsIgnoreCase(s4));
				
		String s5="abcd";
		String s6 = new String(s5);
		System.out.println("s5==s6 :"+(s5==s6));//compare address
		
		String s7 = s6;
		System.out.println("s6==s7 :"+(s6==s7));//compare address
		System.out.println();
		
		
		System.out.println("s1.compareTo(s2) : "+s1.compareTo(s2));
		System.out.println("s1.compareTo(s3) : "+s1.compareTo(s3));
		System.out.println("s1.compareTo(s4) : "+s1.compareTo(s4));
		System.out.println("s1.compareToIgnoreCase(s4) : "+s1.compareToIgnoreCase(s4));

	}

}
