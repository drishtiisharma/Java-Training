import java.util.Scanner;

class RevNum{
public static void main(String[] args){
int n,r=0;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number:");
n=sc.nextInt();
int rev;

for(int i=n;i>0;i=i/10){
r=r*10;
r=r+(i%10);
}
System.out.println("original number: "+n);
System.out.println("reversed number: "+r);
}

}
