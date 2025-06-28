import java.util.Scanner;

class ArraySearching{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);

System.out.println("enter the size of the array");
n=sc.nextInt();
int arr[]=new int[n];
System.out.println("enter array elements");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}

//array element to be searched
System.out.println("enter array element to be searched:");
int x=sc.nextInt();

for(int i=0;i<n;i++){
if(x==arr[i]){
System.out.println(x+" found at index: "+i);
return;
}
}
System.out.println(x+" is not found in the array");

}
}