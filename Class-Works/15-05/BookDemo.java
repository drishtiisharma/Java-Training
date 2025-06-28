import java.util.Scanner;
class BookDemo
{
public static void main(String args[])
{
double books,price,disc,total;
Scanner s = new Scanner(System.in);
System.out.println("Enter no of books :");
books = s.nextDouble();
System.out.println("Enter price of one book :");
price = s.nextDouble();
total = books*price;
if(books<20)
disc = 5;
else
	if(books<50)
	disc = 10;
	else
		if(books<100)
		disc = 15;
		else
		disc = 20;
	
total = total-(total*disc/100);
System.out.println("Total Payble Amount = "+total);
}
}

