import java.util.Scanner;

class IfElseDemo1
{
public static void main(String args[])
{
int n,r;
Scanner s = new Scanner(System.in);
System.out.println("Enter a value:");
n = s.nextInt();
r = n%2;
if(r==0)
{
System.out.println(n+" is even no");
}
else
{
System.out.println(n+" is odd no");
}
}
}





