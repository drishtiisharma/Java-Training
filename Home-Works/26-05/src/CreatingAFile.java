import java.io.FileOutputStream;

public class CreatingAFile {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("file1.txt");
		System.out.println("file created successfully!");
		fos.close();


	}

}
