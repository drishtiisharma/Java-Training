import java.util.Scanner;

class MinInRows{
public static void main(String[] args){
int arr[][]=new int[3][4];
Scanner sc=new Scanner(System.in);
System.out.println("enter 3x4 array elements:");
for(int i=0;i<3;i++){
for(int j=0;j<4;j++){
arr[i][j]=sc.nextInt();
}
}
for(int i=0;i<3;i++){
int min=arr[i][0];
for(int j=1;j<4;j++){
if(arr[i][j]<min){
min=arr[i][j];
}
}
System.out.println("minimum in row "+(i+1)+": "+min);
}
}
}
