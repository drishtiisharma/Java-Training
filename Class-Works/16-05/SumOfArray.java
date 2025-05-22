import java.util.Scanner;

class SumOfArray{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n;
int sum=0;
System.out.println("enter the size of array: ");
n=sc.nextInt();
int arr[]=new int[n];

System.out.println("enter array elements:");
for(int i=0;i<=n-1;i++){
arr[i]=sc.nextInt();
}

System.out.println("sum of array elements:");
for(int i=0;i<n;i++){
sum+=arr[i];
}
System.out.print(sum);
}
}