package str;

class StringBufferExample
{  
public static void main(String args[])
{  
StringBuffer sb=new StringBuffer("Hello ");  
sb.append("Java");//now original string is changed  
System.out.println(sb);//prints Hello Java
String s = new String("Hello ");
String ss = s+"Hello";
if(s==ss)
{
System.out.println("both are equals");
}
else 
{
	System.out.println("both are not equals");
}
}  
}