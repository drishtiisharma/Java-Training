import java.util.Scanner;

class Palindrome{
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
if(r==n){
System.out.println("palindrome");
}
else{
System.out.println("not a palindrome");
}
}

}
