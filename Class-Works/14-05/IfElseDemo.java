import java.util.Scanner;

class IfElseDemo{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("Enter a value: ");
n=sc.nextInt();

//is given value < 100
if(n<100){
System.out.println(n+" is less than 100.");
}
else{
System.out.println(n+" is not less than 100.");
}

}
}