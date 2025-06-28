import java.util.Scanner;

class SwapWithTemp{
public static void main(String[] args){
int a,b,temp;
Scanner sc=new Scanner(System.in);
System.out.println("Enter value of a: ");
a=sc.nextInt();
System.out.println("Enter value of b: ");
b=sc.nextInt();

temp=a;
a=b;
b=temp;

System.out.println("New Value of a: "+a);
System.out.println("New Value of b: "+b);
}
}