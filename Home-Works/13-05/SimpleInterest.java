import java.util.Scanner;

class SimpleInterest{
public static void main(String[] args){
double p,r,t,si;
Scanner sc= new Scanner(System.in);
System.out.println("Enter principal amount: ");
p=sc.nextDouble();
System.out.println("Enter rate: ");
r=sc.nextDouble();
System.out.println("Enter time period: ");
t=sc.nextDouble();
si= (p*r*t)/100;
System.out.println("Simple Interest: "+si);

}
}