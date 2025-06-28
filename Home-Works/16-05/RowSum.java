import java.util.Scanner;

class RowSum{
public static void main(String[] args){
int arr[][]=new int[4][4];
Scanner sc=new Scanner(System.in);
System.out.println("enter 4x4 array elements:");
for(int i=0;i<4;i++){
for(int j=0;j<4;j++){
arr[i][j]=sc.nextInt();
}
}
for(int i=0;i<4;i++){
int sum=0;
for(int j=0;j<4;j++){
sum+=arr[i][j];
}
System.out.println("sum of row "+(i+1)+": "+sum);
}
}
}
