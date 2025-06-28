import java.io.File;
import java.io.FileReader;

public class CountCharactersInFile {

	public static void main(String[] args) throws Exception {
		FileReader a=new FileReader("D:\\Apps\\26-05\\songs.txt");
		int count = 0;
		while(a.read()!=-1) {
			count++;
		}
		a.close();
		System.out.println("number of characters in file: "+count);

	}

}
