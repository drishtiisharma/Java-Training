import java.util.Scanner;

class ArmstronDemo
{
public static void main(String args[])
{
int n,count=0,p=1,sum=0,i,j,r,k;
Scanner s = new Scanner(System.in);
System.out.println("Enter the limit:");
n = s.nextInt();
for(k=1; k<=n; k++)
{
for(i=k; i>0; i=i/10)
{
count++;
}

for(i=k; i>0; i=i/10)
{
	r = i%10;
	for(j=1; j<=count; j++)
	{
		p = p*r;
	}
	sum = sum+p;
	p=1;
}
if(sum == k)
{
System.out.print(k+" ,");
}
count=0;
sum=0;
}

}
}
