import java.io.File;

public class SizeOfFile {

	public static void main(String[] args) throws Exception{
		File d=new File("D:\\Apps\\26-05\\songs.txt");
		
		long bytes=d.length();
		double kilobytes = bytes/1024.0;
		double megabytes =kilobytes/1024.0;
		
		System.out.println("size of "+d.getName()+" in bytes: "+bytes);
		System.out.println("size of "+d.getName()+" in kilobytes: "+kilobytes);
		System.out.println("size of "+d.getName()+" in megabytes: "+megabytes);
	}

}
