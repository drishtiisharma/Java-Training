import java.util.Scanner;

class SumOfArrayElements{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("enter the size of the array:");
n=sc.nextInt();

int arr[]=new int[n];
System.out.println("enter the array elements:");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}

int sum=0;
for(int i=0;i<n;i++){
sum+=arr[i];
}
System.out.println("sum of all array elements is: "+sum);




}
}