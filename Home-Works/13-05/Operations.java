import java.util.Scanner;

class Operations{
public static void main(String[] args){
int a;
int b;
int sub, prod, div;
Scanner sc=new Scanner(System.in);
System.out.println("Enter 1st number: ");
a=sc.nextInt();
System.out.println("Enter 2nd number: ");
b=sc.nextInt();
sub= a-b;
prod=a*b;
div=a/b;
System.out.println("difference: "+sub);
System.out.println("product: "+prod);
System.out.println("quotient: "+div);

}
}