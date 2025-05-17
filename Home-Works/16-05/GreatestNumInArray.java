import java.util.Scanner;

class GreatestNumInArray{
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

System.out.println("\narray elements: ");
for(int i=0;i<n;i++){
System.out.println(arr[i]);
}

int max=arr[0];
for(int i=1;i<n;i++){
if(arr[i]>max){
max=arr[i];
}
}

System.out.println("greatest element in the array: "+max);
}
}