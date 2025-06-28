
public class BytreToStringDemo {

	public static void main(String[] args) {
		
		byte b[] = {65,66,67,68,69,70};
		//byte to string
		String s = new String(b);
		System.out.println(s);
		
		String s1 = new String(b,2,3);
		System.out.println(s1);
		
		//string to bytes
		String s2  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		byte bt[] = s2.getBytes();
		
		for (byte c : bt) {
			System.out.println(c);
		}
		
		
		
		
		
		
		
	}

}
