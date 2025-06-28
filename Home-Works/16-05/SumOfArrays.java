import java.util.Scanner;

class SumOfArrays{
public static void main(String[] args){
int n,m,i,j;
Scanner sc=new Scanner(System.in);

//input for arrays
System.out.println("enter the size of arrays:");
n=sc.nextInt();
int arr1[]=new int[n];
int arr2[]=new int[n];
int arr3[]=new int[n];

//1st array
System.out.println("enter the 1st array elements:");
for(i=0;i<n;i++){
arr1[i]=sc.nextInt();
}

//2nd array
System.out.println("enter the 2nd array elements:");
for(i=0;i<n;i++){
arr2[i]=sc.nextInt();
}


//sum of arrays
for(i=0;i<n;i++){
arr3[i]=arr1[i]+arr2[i];

}

System.out.println("addition of both arrays:");
for(i=0;i<n;i++){
System.out.print(arr3[i]+" ");
}

}
}
