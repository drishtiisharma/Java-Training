import java.util.Scanner;

class ArrayDemo4
{
public static void main(String args[])
{
int size;
Scanner s = new  Scanner(System.in);
System.out.println("Enter size of array :");
size = s.nextInt();

int a[]= new int[size];
int i;

System.out.println("Enter "+size+"values :");
for(i=0; i<size; i++)
{
a[i] = s.nextInt();
}
System.out.println("Output :");
for(i=0; i<size; i++)
{
System.out.println("a["+i+"]="+a[i]);
}
}
}
