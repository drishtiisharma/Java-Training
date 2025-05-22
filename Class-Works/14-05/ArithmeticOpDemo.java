class ArithmeticOpDemo{
public static void main(String[] args){
int a=40;
int b=20;
int c;

c=a+b;
System.out.println("Sum: "+c);

c=a-b;
System.out.println("Difference: "+c);

c=a*b;
System.out.println("Product: "+c);

c=a/b;
System.out.println("Quotient:  "+c);

c=a%b;
System.out.println("Remainder: "+c);

a++;
b--;

System.out.println("Increment: "+a);
System.out.println("Decrement: "+b);
}
}