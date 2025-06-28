import java.util.Scanner;

class FToC{
public static void main(String[] args){
double c,f;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the temperature in Fahrenheit: ");
f=sc.nextDouble();
c=(f-32)*0.5556;
System.out.println("Temperature in Celsius is: "+c);


}
}