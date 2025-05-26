import java.io.File;
import java.util.Date;

public class ModificationDateAndTime {

	public static void main(String[] args) throws Exception{
		File f4 =new File("D:\\Apps\\26-05\\songscopy.txt");
		Date d=new Date(f4.lastModified());
		System.out.println("date and time of last modification: "+d);

	}

}
