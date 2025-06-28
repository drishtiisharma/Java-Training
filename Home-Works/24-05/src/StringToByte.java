public class StringToByte {

	public static void main(String[] args) {
		String s="byte";
		
		byte[] b=s.getBytes();
		System.out.println("string elements as byte array:");
		
		for(byte by: b) {
			System.out.println(by+" ");
		}

	}

}
