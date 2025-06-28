import java.util.Scanner;

class Account{
	
	int accno;
	String name;
	double bal;
	
	void openAcc() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account number:");
		this.accno=sc.nextInt();
		System.out.println("enter account name");
		name=sc.next();
		System.out.println("enter account balance");
		bal=sc.nextDouble();
		sc.close();
		
	}
	
	void enq() {
		System.out.println("account number:"+accno);
		System.out.println("account name:"+name);
		System.out.println("account balance:"+bal);
	}
	
	void deposit() {
		double amt;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter amount to deposit:");
		amt=sc.nextDouble();
		bal=bal+amt;
		System.out.println("current balance: "+bal);
		sc.close();

	}
	
	void withdraw() {
		double amt;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter amount to withdrawn:");
		amt=sc.nextDouble();
		bal=bal-amt;
		System.out.println("current balance: "+bal);
		sc.close();

	}

	
}
public class AccountDemo {

	public static void main(String[] args) {
		Account a1=new Account();
		a1.openAcc();
		
		Account a2=new Account();
		a2.openAcc();
		
		a1.enq();
		a2.enq();
		
		a1.deposit();
		a2.withdraw();
		
		
		

	}
}
