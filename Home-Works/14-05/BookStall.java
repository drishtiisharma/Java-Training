import java.util.Scanner;

class BookStall{
public static void main(String[] args){
int n;
double price;
double totalprice=0;
Scanner sc=new Scanner(System.in);
System.out.println("enter the number of books u want to buy:");
n=sc.nextInt();
System.out.println("enter the price of 1 book:");
price=sc.nextDouble();

//book<20 5 per disc
//book<50 10 per disc
//book<100 15 per disc
//book>=100 20 per disc

if(n<20){
totalprice=n*price;
totalprice=totalprice-(totalprice*5/100);
}
if(20<=n && n<50){
totalprice=n*price;
totalprice=totalprice-(totalprice*10/100);
}
if(50<=n && n<100){
totalprice=n*price;
totalprice=totalprice-(totalprice*15/100);
}
if(n>=100){
totalprice=n*price;
totalprice=totalprice-(totalprice*20/100);
}

System.out.println("Total payable amount for "+n+" books is: "+totalprice);
}
}