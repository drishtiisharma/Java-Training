import java.io.File;

public class HiddenFile {

	public static void main(String[] args) {
		File m= new File("D:\\Apps\\26-05\\ideas.txt");
		System.out.println("checking if "+m.getName()+" is hidden: "+m.isHidden());
		

	}

}
