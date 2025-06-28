import java.util.StringTokenizer;

public class STDemo {

	public static void main(String[] args) {
		
		String s = "Madhur:Ujjain;Abhishek:Betul;Drishti:Indore;Aliya:Indore";
		
		StringTokenizer st = new StringTokenizer(s,":;");
		System.out.println("st.countTokens():"+st.countTokens());
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken()+":\t"+st.nextToken());
		}
		
		System.out.println("s.length():"+s.length());
		System.out.println("s.charAt(5):"+s.charAt(5));
		System.out.println(s.indexOf('j'));
		System.out.println("s.toLowerCase():"+s.toLowerCase());
		System.out.println("s.toUpperCase():"+s.toUpperCase());
		System.out.println("s.startsWith(Madhur):"+s.startsWith("Madhur"));
		System.out.println("s.endsWith(Indore):"+s.endsWith("Indore"));

	}

}
