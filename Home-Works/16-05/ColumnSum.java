import java.util.Scanner;

class ColumnSum{
public static void main(String[] args){
int arr[][]=new int[4][4];
Scanner sc=new Scanner(System.in);
System.out.println("enter 4x4 array elements:");
for(int i=0;i<4;i++){
for(int j=0;j<4;j++){
arr[i][j]=sc.nextInt();
}
}
for(int j=0;j<4;j++){
int sum=0;
for(int i=0;i<4;i++){
sum+=arr[i][j];
}
System.out.println("sum of column "+(j+1)+": "+sum);
}
}
}
