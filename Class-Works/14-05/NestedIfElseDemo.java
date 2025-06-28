import java.util.Scanner;

class NestedIfElseDemo{
public static void main(String[] args){
double p;
Scanner sc=new Scanner(System.in);
System.out.println("Enter your percentage: ");
p=sc.nextDouble();

//1st division: P>=60
//2nd division: P>=45
//3rd division: P>=33
//FAIL: P<33000000000

if(p<=60){
System.out.println("1st div");
}
else{
if(p>=45){
System.out.println("2nd div");
}
else{
if(p>=33){
System.out.println("3rd div");
}
else{
System.out.println("Fail!");
}
}
}
}
}