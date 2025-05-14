import java.util.Scanner;

class GreatestTwo{
public static void main(String[] args){
int a;
int b;
Scanner sc=new Scanner(System.in);
System.out.println("enter 1st number:");
a=sc.nextInt();
System.out.println("enter 2nd number:");
b=sc.nextInt();

if(a>b){
System.out.println(a+" is greater than "+b);
}
else if(b>a){
System.out.println(b+" is greater than "+a);
}
else{
System.out.println(a+" and "+b+" are equal");
}

}
}