import java.util.Scanner;

class PowerDemo
{
public static void main(String args[])
{
int m,n,p=1,i;
Scanner s = new Scanner(System.in);
System.out.println("Enter first value:");
m = s.nextInt();
System.out.println("Enter second value:");
n = s.nextInt();

for(i=1; i<=n; i++)
{
	p = p*m;
}
System.out.println(m+" ^ "+n+" = "+p);
}
}

