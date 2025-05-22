import java.util.Scanner;

class JaggedArray{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int arr[][]={
{1,3,2},
{5,7},
{9,1,5,6},
};
System.out.println("array elements are:");
for(int i=0;i<=4;i++){
for(int j=0;j<arr[i].length;j++){
System.out.print(arr[i][j]);
}
System.out.println();
}

}
}