import java.io.FileOutputStream;
public class AppendTextInFile {

	public static void main(String[] args) throws Exception {
		String og= "D:\\Apps\\26-05\\Project ideas.txt";
		String toAppend= "appending text in file....";
		FileOutputStream fos1=new FileOutputStream(og,true);
		byte[] b=toAppend.getBytes(); //converting string to bytes
		fos1.write(b);
		fos1.close();
		System.out.println("text successfully appended in "+og);

	}

}
