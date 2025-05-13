import java.util.Scanner;

class AreaOfRectangle{
public static void main(String[] args){
double l,b,ar;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the length of the rectangle: ");
l=sc.nextDouble();
System.out.println("Enter the breadth of the rectangle: ");
b=sc.nextDouble();
ar=l*b;
System.out.println("Area of rectangle: "+ar);

}
}