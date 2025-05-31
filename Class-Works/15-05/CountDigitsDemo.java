import java.util.Scanner;

class CountDigitsDemo
{
public static void main(String args[])
{
int n,count=0,i;
Scanner s = new Scanner(System.in);
System.out.println("Enter a value:");
n = s.nextInt();

for(i=n; i>0; i=i/10)
{
count++;
}

System.out.println("No Of Digits = "+count);
}
}






