import java.util.Scanner;

class ArmstrongFinal{
public class static void main(String[] args){
Scanner sc=new Scanner(System.in);

System.out.println("enter a number:");
int num=sc.nextInt();

int original=num;
int sum=0;

while(num>0){
int digit=num%10; //for the last digit
sum+=digit*digit*digit;
num/=10; //to remove the last digit

if(sum==original){
System.out.println(original+" is armstrong");
}
else{
System.out.println(original+" is not armstrong);
}
}
}