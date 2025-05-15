class Pattern16{
public static void main(String[] args){
for(int i=1; i<=5; i++) {
for(int space=0; space<5-i; space++) {
System.out.print(" ");
}
for(int j=0; j<i; j++) {
System.out.print("* ");
}
System.out.println();
}
}
}
