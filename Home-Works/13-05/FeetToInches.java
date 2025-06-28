import java.util.Scanner;

class FeetToInches{
public static void main(String[] args){
double f,i;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the length in feet: ");
f=sc.nextDouble();
i=f*12;
System.out.println("Length in Inches is: "+i);
}
}