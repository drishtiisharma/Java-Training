import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		File f3= new File("D:\\Apps\\26-05\\uploads.txt");
		
		if(f3.exists()) {
			if(f3.delete()) {
				System.out.println(f3.getName()+" deleted successfully.");
			}
			else {
				System.out.println(f3.getName()+" couldnt be deleted");
			}
		}
		else {
			System.out.println(f3.getName()+" doesnt exist!");
		}


	}

}
