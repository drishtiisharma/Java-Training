import java.util.Scanner;
class ForDemo3{
public static void main(String[] args){
int m,n;
Scanner sc=new Scanner(System.in);
System.out.println("enter a starting value:");
m=sc.nextInt();
System.out.println("enter a stopping value:");
n=sc.nextInt();

for(int i=m;i<=n;i++){
System.out.println(i);
}

for(int i=m;i>=n;i--){
System.out.println(i);
}


}
}