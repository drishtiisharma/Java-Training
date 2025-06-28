import java.util.Scanner;

class ReverseArray{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("enter the size of array:");
n=sc.nextInt();
int arr[]=new int[n];
System.out.println("enter array elements:");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}
System.out.println(" ");
System.out.println("array elements in reverse order:");
for(int i=n-1;i>=0;i--){
System.out.println(arr[i]);
}

}
}