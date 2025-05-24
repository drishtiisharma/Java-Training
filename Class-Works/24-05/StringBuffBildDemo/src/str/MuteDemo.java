package str;

public class MuteDemo {

	public static void main(String[] args) {
	
		StringBuffer sb = new StringBuffer("Rahul");
		System.out.println("sb = "+sb);
		System.out.println("sb.hashCode():"+sb.hashCode());
		
		sb.append(" Sharma");
		System.out.println("sb = "+sb);
		System.out.println("sb.hashCode():"+sb.hashCode());
		
	}

}
