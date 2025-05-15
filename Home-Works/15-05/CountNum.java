import java.util.Scanner;

class CountNum{
public static void main(String[] args){
int num;

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
temp=temp/10;
count++;
}
}

System.out.println("the number of digits in "+num+" is: "+count);

}
}