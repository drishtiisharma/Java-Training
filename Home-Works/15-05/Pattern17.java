class Pattern17{
public static void main(String[] args){
for(int i=5; i>=1; i--) {
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
