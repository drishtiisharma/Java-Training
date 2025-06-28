class Prime{
public static void main(String[] args){
int n=Integer.parseInt(args[0]);
boolean isPrime=true;

if(n<=0){
isPrime=false;
}
else{
for(int i=2;i<=n/2;i++){
if(n%i==0){
isPrime=false;
break;
}
}
}

if(isPrime){
System.out.println(n+" is prime");
}
else{
System.out.println(n+" is not prime");
}

}
}