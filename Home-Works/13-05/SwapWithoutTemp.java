import java.util.Scanner;

class SwapWithoutTemp{
public static void main(String[] args){
int a,b;
Scanner sc=new Scanner(System.in);
System.out.println("Enter value of a: ");
a=sc.nextInt();
System.out.println("Enter value of b: ");
b=sc.nextInt();

a=a+b;
b=a-b;
a=a-b;

System.out.println("New value of a: "+a);
System.out.println("New value of b: "+b);
}
}