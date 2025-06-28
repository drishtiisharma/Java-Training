import java.util.Scanner;

class VolumeOfBox{
public static void main(String[] args){
double l,b,h,vol;
Scanner sc=new Scanner(System.in);
System.out.println("Enter length of the box: ");
l=sc.nextDouble();
System.out.println("Enter breadth of the box: ");
b=sc.nextDouble();
System.out.println("Enter height of the box: ");
h=sc.nextDouble();
vol=l*b*h;

System.out.println("Volume of the box: "+vol);

}
}