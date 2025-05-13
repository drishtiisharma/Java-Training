import java.util.Scanner;

class CToF{
public static void main(String[] args){
double c,f;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the temperature in Celsius: ");
c=sc.nextDouble();
f=(1.8*c)+32;
System.out.println("Temperature in fahrenheit: "+f);
}
}