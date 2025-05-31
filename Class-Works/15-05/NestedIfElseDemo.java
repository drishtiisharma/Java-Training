import java.util.Scanner;

class NestedIfElseDemo
{
public static void main(String args[])
{
double p;
Scanner s = new Scanner(System.in);
System.out.println("Enter your percentage marks :");
p = s.nextDouble();
if(p>=60)
{
System.out.println("I Div");
}
else
{
	if(p>=45)
	{
	System.out.println("II Div");
	}
	else
	{
		if(p>=33)
		{
		System.out.println("III Div");
		}
		else
		{
		System.out.println("FAIL");
		}
	}
}
}
}
