import java.io.File;

public class RenamingAFile {

	public static void main(String[] args) throws Exception {
		File x=new File("D:\\Apps\\26-05\\Project ideas.txt");
		File y=new File("D:\\\\Apps\\\\26-05\\\\ideas.txt");
		
		x.renameTo(y);
		System.out.println(x.getName()+" renamed to "+y.getName());

	}

}
