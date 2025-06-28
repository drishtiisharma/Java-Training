import java.util.Scanner;

public class Armstrong{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int num = sc.nextInt();
int original = num;
int digits = 0;

//counting digits
int temp = num;
while (temp > 0) {
digits++;
temp = temp / 10;
}

int sum = 0;
temp = num;

// Calculate sum of digits^digits manually
while (temp > 0) {
int digit = temp % 10;
int power = 1;
//digits^digits
for (int i = 1; i <= digits; i++) {
power = power * digit;
}
sum = sum + power;
temp = temp / 10;
}

if (sum == original) {
System.out.println(original + " is an Armstrong number.");
} 
else {
System.out.println(original + " is not an Armstrong number.");
}
}
}
