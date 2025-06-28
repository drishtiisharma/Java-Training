import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception 
	{
		
		FileInputStream fis = 
		new FileInputStream("/home/administrator/IPS@25/FILEIO/src/SerializationDemo.java");
		
		int size;
		System.out.println("No Of Bytes = "+(size = fis.available()));
		
		byte b[] = new byte[size];
		fis.read(b);
		
		String s = new String(b,0,b.length);
		System.out.println(s);
		fis.close();

	}

}
