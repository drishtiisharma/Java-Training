import java.io.File;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		
		File f = new File("/home/administrator/IPS@25/FILEIO/stud.doc");
		System.out.println("File Name : "+f.getName());
		System.out.println("Path : "+f.getPath());
		System.out.println("AbsolutePath : "+f.getAbsolutePath());
		System.out.println("parent : "+f.getParent());
		
		System.out.println("Exist : "+f.exists());
		System.out.println("f.canWrite() : "+f.canWrite());
		System.out.println("f.canRead() : "+f.canRead());
		
		System.out.println("f.isDirectory():" +f.isDirectory());
		System.out.println("f.isFile() : "+f.isFile());
		
		System.out.println("Last Modify : "+f.lastModified());

		Date d = new Date(f.lastModified());
		
		System.out.println(d);
		
		if(f.delete())
		{
			System.out.println("File Deleted");
		}
		
	}

}
