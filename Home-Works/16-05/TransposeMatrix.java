import java.util.Scanner;

class TransposeMatrix{
public static void main(String[] args){
int arr[][]=new int[3][3];
int trans[][]=new int[3][3];
Scanner sc=new Scanner(System.in);
System.out.println("enter 3x3 matrix:");
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
arr[i][j]=sc.nextInt();
}
}
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
trans[j][i]=arr[i][j];
}
}
System.out.println("transpose of matrix:");
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
System.out.print(trans[i][j]+" ");
}
System.out.println();
}
}
}
