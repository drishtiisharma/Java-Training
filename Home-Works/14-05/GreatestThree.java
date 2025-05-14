import java.util.Scanner;

class GreatestThree{
public static void main(String[] args){
int a,b,c,max;
Scanner sc=new Scanner(System.in);
System.out.println("1st number:");
a=sc.nextInt();
System.out.println("2nd number:");
b=sc.nextInt();
System.out.println("3rd number:");
c=sc.nextInt();

max=a;
if(b>max){
max=b;
}
if(c>max){
max=c;
}

System.out.println(max+" is the greatest");

}
}


