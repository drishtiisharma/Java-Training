
import java.io.File;

class DirList
{
public static void main (String []args)
{
	String dirname="/home/administrator/IPS@25/FILEIO";
    File f1=new File("/home/administrator/IPS@25/FILEIO");
        

if(f1.isDirectory())
{
	System.out.println("directory of "+dirname);
	String s[] = f1.list();

	for(int i=0;i<s.length;i++)
	{
		 File f=new File(dirname + "/"+s[i]);
		 if(f.isDirectory())
		{
			 System.out.println(s[i] + " is a directory");
		 }
		else
		{
			System.out.println(s[i] + " is a file");
		}
	}
}

else
{
System.out.println(dirname + "is not a directory");
}  

}
}