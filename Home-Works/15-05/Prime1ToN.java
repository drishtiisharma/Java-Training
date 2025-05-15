import java.util.Scanner;
class Prime1ToN{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number:");
n=sc.nextInt();
for(int i=2; i<=n; i++) {
boolean isPrime = true;
for(int j=2; j<=i/2; j++) {
if(i%j==0) {
isPrime = false;
break;
}
}
if(isPrime) {
System.out.println(i);
}
}
}
}
