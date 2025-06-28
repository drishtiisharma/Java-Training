
import java.io.BufferedReader;
import java.io.FileReader;

// Demonstrate FileReader. import java.io.*;
class FileReaderDemo 
{ 
public static void main(String args[]) throws Exception 
{ 
int i=0;
FileReader fr = new FileReader("/home/administrator/IPS@25/FILEIO/src/SerializationDemo.java");
BufferedReader br = new BufferedReader(fr); 
String s;
while((s = br.readLine()) != null) 
{ 
System.out.println(s); 
i++;
}
//fr.read(cbuf, offset, length)
fr.close();
System.out.println("no Of Lines:"+i);
}
}
