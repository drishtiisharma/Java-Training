import java.io.File;

public class CanReadFile {

	public static void main(String[] args) {
		File f1=new File("D:\\Apps\\26-05\\Project ideas.txt");
		try {
			System.out.println("checking if "+f1.getName()+" is read-only: ");
			System.out.println(f1.canRead());

		}
		catch(Exception e) {
			System.out.println(f1.getName()+"is not read only!");
		}

	}

}
