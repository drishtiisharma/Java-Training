import java.util.Scanner;

class SumOfNDigits{
public static void main(String[] args){
int num;
int sum=0;
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number:");
num=sc.nextInt();
int count=0;
int temp=num;
if(temp==0){
count=1;
}
else{
while(temp!=0){
int digit=temp%10; //to get the last digit
sum=sum+digit; //adding it to the sum
temp=temp/10; //removing the last digit
}
}

System.out.println("the number of digits in "+num+" is: "+count+" and the sum of those digits is: "+sum);

}
}