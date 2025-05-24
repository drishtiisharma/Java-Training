
public class ASCIICode {

	public static void main(String[] args) {
		
		for(byte i = -128; ; i++)
		{
			System.out.println(i+"-->"+(char)i);
			if(i==127)
				break;
		}

	}

}
