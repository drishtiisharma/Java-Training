import java.util.Scanner;

class AdditionDemo1{
public static void main(String[] args){
int a;
int b;
int c;
Scanner s=new Scanner(System.in);

System.out.println("Enter 1st number: ");
a=s.nextInt();
System.out.println("Enter 2nd number: ");
b=s.nextInt();

c=a+b;
System.out.println("Sum: "+c);

}
}