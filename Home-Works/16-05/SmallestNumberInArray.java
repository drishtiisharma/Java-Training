import java.util.Scanner;

class SmallestNumberInArray{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);

System.out.println("enter the size of the array:");
n=sc.nextInt();

int arr[]=new int[n];
System.out.println("enter array elements:");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}

System.out.println("array elements are:");
for(int i=0;i<n;i++){
System.out.println(arr[i]);
}

int min=arr[0];
for(int i=1;i<n;i++){
if(arr[i]<min){
min=arr[i];
}
}
System.out.println("smallest number in the array is: "+min);

}
}