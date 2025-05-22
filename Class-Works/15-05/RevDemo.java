import java.util.Scanner;
class RevDemo{
public static void main(String[] args){
int n,i,r=0;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number: ");
n=sc.nextInt();
for(i=n;i>0;i=i/10){
r=r*10;
r=r+(i%10);
}
System.out.println("reversed number: "+r);
}
}