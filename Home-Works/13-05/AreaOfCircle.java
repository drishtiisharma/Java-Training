import java.util.Scanner;

class AreaOfCircle{
public static void main(String[] args){
double ar,r;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the radius of the circle: ");
r=sc.nextDouble();
ar=3.14*r*r;
System.out.println("Area of circle: "+ar);

}
}