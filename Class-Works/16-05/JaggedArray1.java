import java.util.Scanner;

class JaggedArray1{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int r,c;
System.out.println("enter number of rows:");
r=sc.nextInt();
System.out.println("enter number of columns:");
c=sc.nextInt();
int arr[][]=new int[r][c];

for(int i=0;i<=r;i++){
for(int j=0;j<arr[i].length;j++){
System.out.print(arr[i][j]);
}
}
System.out.println("Jagged Array:");
for(int i=0;i<=4;i++){
for(int j=0;j<arr[i].length;j++){
System.out.print(arr[i][j]);
}
System.out.println();
}
}
}