import java.util.Scanner;
class TablesMToN{
public static void main(String[] args){
int m,n;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number:");
m=sc.nextInt();
System.out.println("enter another number:");
n=sc.nextInt();
for(int i=m; i<=n; i++) {
for(int j=1; j<=10; j++) {
System.out.println(i + " x " + j + " = " + (i*j));
}
System.out.println();
}
}
}
