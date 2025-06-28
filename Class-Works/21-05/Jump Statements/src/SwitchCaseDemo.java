import java.util.Scanner;

public class SwitchCaseDemo {

	public static void main(String[] args) {
		int a,b,c,choice,n=1;
		while(n==1) {
		System.out.println("choose from:");
		System.out.println("add: 1");
		System.out.println("sub: 2");
		System.out.println("mul: 3");
		System.out.println("div: 4");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your choice:");
		choice=sc.nextInt();
		
		System.out.println("enter a:");
		a=sc.nextInt();
		
		System.out.println("enter b:");
		b=sc.nextInt();
		switch(choice) {
		case 1:
			c=a+b;
			System.out.println("sum: "+c);
			break;
			
		case 2:
			c=a-b;
			System.out.println("diff: "+c);
			break;
			
		case 3:
			c=a*b;
			System.out.println("prod: "+c);
			break;
			
		case 4:
			c=a/b;
			System.out.println("quo: "+c);
			break;
			
		default:
			System.out.println("enter a valid choice");
		}
		
		System.out.println("do u want to continue?[y=1,n=0]");
		n=sc.nextInt();
		}

	}

}
