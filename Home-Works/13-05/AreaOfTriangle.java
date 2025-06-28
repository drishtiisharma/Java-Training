import java.util.Scanner;

class AreaOfTriangle{
public static void main(String[] args){
double b,h,ar;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the breadth of the triangle: ");
b=sc.nextDouble();
System.out.println("Enter the height of the triangle: ");
h=sc.nextDouble();
ar=0.5*b*h;
System.out.println("Area of triangle: "+ar);
}
}