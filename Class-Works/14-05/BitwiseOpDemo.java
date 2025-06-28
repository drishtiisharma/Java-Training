class BitwiseOpDemo{
public static void main(String[] args){
int a=15;
int b=5;
int c;

c=a&b;
System.out.println("a&b: "+c);

c=a|b;
System.out.println("a|b: "+c);

c=a<<2;
System.out.println("a<<2: "+c);

c=a>>2;
System.out.println("a>>b: "+c);

c=~a;
System.out.println("~a: "+c);

}
}