import java.io.File;

public class FileSizeAndPath {

	public static void main(String[] args) throws Exception {
		File f=new File("D:\\Apps\\26-05\\songs.txt");
		System.out.println("file's path: "+f.getAbsolutePath()); //path of file
		System.out.println("file's size: "+f.length()); //size of file

	}

}
