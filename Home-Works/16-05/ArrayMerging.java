import java.util.Scanner;

class ArrayMerging{
public static void main(String[] args){
int n,m;
Scanner sc=new Scanner(System.in);

//1st array
System.out.println("enter the size of 1st array");
n=sc.nextInt();
int arr1[]=new int[n];
System.out.println("enter elements of 1st array:");
for(int i=0;i<n;i++){
arr1[i]=sc.nextInt();
}


//2nd array
System.out.println("enter the size of 2nd array");
m=sc.nextInt();
int arr2[]=new int[m];
System.out.println("enter elements of 2nd array:");
for(int i=0;i<m;i++){
arr2[i]=sc.nextInt();
}

//merged array
int arr3[]=new int[n+m];

//copying elements from arr1
for(int i=0;i<n;i++){
arr3[i]=arr1[i];
}

//copying elements from arr2
for(int i=0;i<m;i++){
arr3[n+i]=arr2[i];
}

System.out.println("merged array:");
for(int i=0;i<arr3.length;i++){
System.out.print(arr3[i]+" ");
}

}
}