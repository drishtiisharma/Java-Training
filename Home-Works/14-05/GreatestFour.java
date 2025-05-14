import java.util.Scanner;

class GreatestFour{
public static void main(String[] args){
int a,b,c,d,max;
Scanner sc=new Scanner(System.in);
System.out.println("enter 1st number:");
a=sc.nextInt();
System.out.println("enter 2nd number:");
b=sc.nextInt();
System.out.println("enter 3rd number:");
c=sc.nextInt();
System.out.println("enter 4th number:");
d=sc.nextInt();

max=a;
if(b>max){
max=b;
}
if(c>max){
max=c;
}
if(d>max){
max=d;
}

System.out.println(max+" is the greatest number.");
}
}