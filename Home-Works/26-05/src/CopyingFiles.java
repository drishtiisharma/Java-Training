import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyingFiles {

	public static void main(String[] args) throws Exception{
		String source="D:\\Apps\\26-05\\songs.txt";
		String dest="D:\\Apps\\26-05\\songscopy.txt";
		
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(dest);
		
		int b;
		while((b=fis.read()) != -1) {
			fos.write(b);
		}
		
		fis.close();
		fos.close();
		System.out.println("File copied successfully.");

	}

}
