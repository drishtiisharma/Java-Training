import java.util.Scanner;

class RelationalOpDemo
{
public static void main(String args[])
{
int a,b;
Scanner s = new Scanner(System.in);
System.out.println("Enter value of a:");
a = s.nextInt();
System.out.println("Enter value of b:");
b = s.nextInt();

System.out.println("a<b = "+(a<b)); //true
System.out.println("a>b = "+(a>b));//false
System.out.println("a<=b = "+(a<=b));//true
System.out.println("a>=b = "+(a>=b));//false
System.out.println("a==b = "+(a==b));//false
System.out.println("a!=b = "+(a!=b));//true


}
}
