import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws Exception 
	{
		String s = "This is demo of FileOutputStream Class,\n used to write data in bytes format.";
		
		FileOutputStream f1 = new FileOutputStream("file1.txt");
		byte b[] = s.getBytes();
		
		for(int i=0; i<b.length; i++)
		{
			f1.write(b[i]);
		}
		f1.close();
		FileOutputStream f2 = new FileOutputStream("file2.txt");
		for(int i=0; i<b.length; i+=2)
		{
			f2.write(b[i]);
		}
		f2.close();
		
		FileOutputStream f3 = new FileOutputStream("file3.txt");
		f3.write(b);
		f3.close();
		
		FileOutputStream f4 = new FileOutputStream("file4.txt");
		f4.write(b, b.length-b.length/4,b.length/4);
		f4.close();

	}

}



