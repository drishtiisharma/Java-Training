import java.util.Scanner;

class TwoDArray1{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int r,c;
System.out.println("enter number of rows:");
r=sc.nextInt();
System.out.println("enter number of columns:");
c=sc.nextInt();
int arr[][]=new int[r][c];


for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
arr[i][j]=sc.nextInt();
}
}
System.out.println("matrix:");
for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
System.out.print(arr[i][j]);
}
System.out.println(" ");
}
}
}