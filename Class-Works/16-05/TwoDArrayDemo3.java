class TwoDArrayDemo3
{
public static void main(String args[])
{
int a[][] = {
			{1,1,1,1},
			{2,2},
			{3,3,3,3,3,3},
			{4,4,4,4},
			{5,5,5,}
						};
int i,j;
for(i=0; i<=4; i++)
{
	for(j=0; j<a[i].length; j++)
	{
	System.out.print(a[i][j]);	
	}
	System.out.println();
}					
}
}
