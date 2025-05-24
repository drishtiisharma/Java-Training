package str;

class StringBufferExample5
{  
public static void main(String args[])
{  
StringBuffer sb=new StringBuffer("RAHUL");  
sb.reverse();  
System.out.println(sb);//prints olleH  
char ch = sb.charAt(0);
System.out.println(ch);
sb.deleteCharAt(2);
System.out.println(sb);
}  
}  