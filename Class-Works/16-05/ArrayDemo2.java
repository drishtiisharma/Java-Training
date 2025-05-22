import java.util.Scanner;

class ArrayDemo2{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n;

System.out.println("enter the size of array: ");
n=sc.nextInt();
int arr[]=new int[n];

System.out.println("enter array elements:");
for(int i=0;i<=n-1;i++){
arr[i]=sc.nextInt();
}

System.out.println("array elements are:");
for(int i=n-1;i>=0;i--){
System.out.println(arr[i]);
}

}
}