import java.util.Scanner;

class ArraySorting{
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

//using bubble sort
for(int i=0;i<n-1;i++){
for(int j=0;j<n-1-i;j++){
if(arr[j]>arr[j+1]){
int temp=arr[j];
arr[j]=arr[j+1];
arr[j+1]=temp;
}
}
}

System.out.println("sorted array:");
for(int i=0;i<n;i++){
System.out.print(arr[i]+" ");
}

}
}