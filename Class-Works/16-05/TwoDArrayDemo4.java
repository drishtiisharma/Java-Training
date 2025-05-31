import java.util.Scanner;
class TwoDArrayDemo4
{
public static void main(String args[])
{
int a[][] = new int[5][5];
int i,j;
Scanner s = new Scanner(System.in);
System.out.println("Enter 25 values in 5*5 two d array:");
for(i=0; i<=4; i++)
{
	for(j=0; j<=4; j++)
	{
	a[i][j] = s.nextInt();
	}
}
System.out.println("Output :");					
for(i=0; i<=4; i++)
{
	for(j=0; j<=4; j++)
	{
	System.out.print(a[i][j]);	
	}
	System.out.println();
}					
}
}
