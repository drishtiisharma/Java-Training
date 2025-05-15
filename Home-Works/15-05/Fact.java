import java.util.Scanner;

class Fact{
public static void main(String[] args){
int n;
int fact=1;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number:");
n=sc.nextInt();

for(int i=1;i<=n;i++){
fact=fact*i;
}

System.out.println("Factorial of "+n+" is: "+fact);
}
}