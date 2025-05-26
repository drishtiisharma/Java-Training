import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileLineByLine{ 
	public static void main(String args[]) throws Exception { 
		int i=0;
		FileReader fr = new FileReader("D:\\Apps\\26-05\\songs.txt");
		BufferedReader br = new BufferedReader(fr); 
		String s;
		while((s = br.readLine()) != null) 
		{ 
			System.out.println(s); 
			i++;
		}

		fr.close();
		System.out.println("\nno Of Lines:"+i);
	}
}


