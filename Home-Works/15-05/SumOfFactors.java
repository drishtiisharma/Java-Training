import java.util.Scanner;

class SumOfFactors{
public static void main(String[] args){
int n;
double sum=0.0;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number");
n=sc.nextInt();
for(int i=1;i<=n;i++){
sum+=1.0/i;
}
System.out.println("sum of factors: "+sum);
}
}