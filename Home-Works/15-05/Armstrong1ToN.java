import java.util.Scanner;
class Armstrong1ToN{
public static void main(String[] args){
int n;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number:");
n=sc.nextInt();
for(int i=1; i<=n; i++) {
int num = i, sum = 0, temp = num;
int digits = String.valueOf(num).length();
while(temp > 0) {
int digit = temp % 10;
sum += Math.pow(digit, digits);
temp /= 10;
}
if(sum == num) {
System.out.println(num);
}
}
}
}
