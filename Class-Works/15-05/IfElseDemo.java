import java.util.Scanner;

class IfElseDemo
{
public static void main(String args[])
{
int n;
Scanner s = new Scanner(System.in);
System.out.println("Enter a value:");
n = s.nextInt();

if(n<100)
{
System.out.println(n+" is less than 100");
}
else
{
System.out.println(n+" is not less than 100");
}

}
}





