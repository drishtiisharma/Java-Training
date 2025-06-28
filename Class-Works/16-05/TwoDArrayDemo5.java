import java.util.Scanner;
class TwoDArrayDemo5
{
public static void main(String args[])
{
int a[][] = new int[5][];
a[0] = new int[3];
a[1] = new int[5];
a[2] = new int[6];
a[3] = new int[1];
a[4] = new int[4];
int i,j;
Scanner s = new Scanner(System.in);

for(i=0; i<=4; i++)
{
System.out.println("Enter "+a[i].length+" values :");
	for(j=0; j<a[i].length; j++)
	{
	a[i][j] = s.nextInt();
	}
}
System.out.println("Output :");					
for(i=0; i<=4; i++)
{
	for(j=0; j<a[i].length; j++)
	{
	System.out.print(a[i][j]);	
	}
	System.out.println();
}					
}
}
