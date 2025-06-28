import java.util.Scanner;

class Reverse2D{
public static void main(String[] args){
int arr[][]=new int[3][3];
Scanner sc=new Scanner(System.in);
System.out.println("enter 3x3 array elements:");
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
arr[i][j]=sc.nextInt();
}
}
System.out.println("elements in reverse input order:");
for(int i=2;i>=0;i--){
for(int j=2;j>=0;j--){
System.out.print(arr[i][j]+" ");
}
System.out.println();
}
}
}
