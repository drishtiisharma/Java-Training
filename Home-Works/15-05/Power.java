import java.util.Scanner;

class Power{
public static void main(String[] args){
int m,n,result=1;
Scanner sc=new Scanner(System.in);
System.out.println("enter the base:");
m=sc.nextInt();
System.out.println("enter the exponent:");
n=sc.nextInt();

for(int i=1;i<=n;i++){
result=result*m;
}

System.out.println(m+" raised to "+n+" is: "+result);
}
}