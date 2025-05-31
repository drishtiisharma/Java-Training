import java.util.Scanner;

class PalindromDemo
{
public static void main(String args[])
{
int n,r=0,i;
Scanner s = new Scanner(System.in);
System.out.println("Enter a value:");
n = s.nextInt();

for(i=n; i>0; i=i/10)
{
	r = r*10;
	r = r+(i%10);
}
if(r==n)
{
System.out.println(n+" is a palindrom no");
}
else
{
System.out.println(n+" is not a palindrom no");
}

}
}






