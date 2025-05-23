import java.util.Scanner;

public class UniversalCatch {

	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a value:");
		n=sc.nextInt();
		
		try {
			int res=123/n;
			System.out.println("result: "+res);
			if(n%2==0) {
				System.out.println();
				int arr[]= {1,2,30,4};
				arr[8]=30;
			}
		}
		
		catch(Exception e) {
			System.out.println("exception caught universally: "+e);
		}
		
	
	}

}
