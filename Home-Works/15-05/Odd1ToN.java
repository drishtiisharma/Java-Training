import java.util.Scanner;

class Odd1ToN{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("enter a limit:");
n=sc.nextInt();

for(int i=1;i<=n;i++){
if(i%2!=0){
System.out.println(i);
}
}

}
}