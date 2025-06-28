import java.util.Scanner;

class InchesToFeet{
public static void main(String[] args){
double f,i;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the length in inches: ");
i=sc.nextDouble();
f=i/12;
System.out.println("Length in feet is: "+f);
}
}