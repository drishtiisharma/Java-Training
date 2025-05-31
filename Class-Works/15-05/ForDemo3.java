import java.util.Scanner;
class ForDemo3
{
public static void main(String args[])
{
int i,m,n;
Scanner s = new Scanner(System.in);
System.out.println("Enter first value :");
m = s.nextInt();
System.out.println("Enter last value :");
n = s.nextInt();

for(i=m; i<=n; i++)
{
System.out.println("i ="+i); 	
}
for(i=m; i>=n; i--)
{
System.out.println("i ="+i); 	
}

}
}
