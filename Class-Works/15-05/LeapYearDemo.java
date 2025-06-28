import java.util.Scanner;
class LeapYearDemo
{
public static void main(String args[])
{
int y;
Scanner s = new Scanner(System.in);
System.out.println("Enter year:");
y = s.nextInt();
if(y%100==0)
{
	if(y%400==0)
	{
	System.out.println(y+" is a leap year");
	}
	else
	{
	System.out.println(y+" is not a leap year");
	}
}
else
{
	if(y%4==0)
	{
	System.out.println(y+" is a leap year");
	}
	else
	{
	System.out.println(y+" is not a leap year");
	}
}

}
}
