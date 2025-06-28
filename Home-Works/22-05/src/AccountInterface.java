// 4. Write a Java programming to create a banking system with three classes - Bank, Account, SavingsAccount, and CurrentAccount. The bank should have a list of accounts and methods for adding them. Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances. SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.

import java.util.Scanner;

interface Account{
	double deposit(double amt);
	double withdraw(double amt);
	double calcint();
	double viewbal();
}




class SavingsAccount implements Account{
	double bal;
	double intrate;
	public SavingsAccount(double bal, double intrate) {
		this.bal = bal;
		this.intrate = intrate;
	}
	
	@Override
	public double deposit(double amt) {
		bal+=amt;
		System.out.println(amt+" deposited to the savings account.");
		return bal;
	}
	@Override
	public double withdraw(double amt) {
		if(bal>=amt) {
			bal-=amt;
			System.out.println(amt + " withdrawn from the savings account.");
		}
		else {
			System.out.println("insufficient balance in the savings account.");
		}
		return bal;
	}
	@Override
	public double calcint() {
		return bal*intrate/100;
	}
	@Override
	public double viewbal() {
		System.out.println("savings account balance: "+bal);
		return bal;
	}
	
	
	
}





class CurrentAccount implements Account{
	public double bal;
	

	public CurrentAccount(double b) {
		this.bal = b;
	}

	@Override
	public double deposit(double amt) {
		bal += amt;
		System.out.println(amt + " deposited to the current account.");
		return bal;
	}

	@Override
	public double withdraw(double amt) {
		if(bal>=amt) {
		bal-=amt;
		System.out.println(amt + " withdrawn from the current account.");
		}
		else {
			System.out.println("Insufficient balance in the current account.");
		}
		return bal;
	}

	@Override
	public double calcint() {
		return 0;
	}

	@Override
	public double viewbal() {
		System.out.println("current account balance: "+bal);
		return bal;
	}
	
}



class Bank{
	Account[] acc=new Account[10];
	int count=0;
	
	void addAcc(Account acco) {
		if(count<acc.length) {
			acc[count++]=acco;
			System.out.println("account added to the bank!");
		}
		else {
			System.out.println("bank is full, cannot accommodate more accounts!");
		}
		
	}
	void showAllAccounts() {
		for(int i=0;i<count;i++) {
			acc[i].viewbal();
		}
	}
}


public class AccountInterface {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bank b=new Bank();
		
		//savings account
		System.out.println("enter the balance for savings account: ");
		double sbal=sc.nextDouble();
		System.out.println("enter the interest rate for savings account: ");
		double srate=sc.nextDouble();
		SavingsAccount sa= new SavingsAccount(sbal,srate);
		b.addAcc(sa);
		
		
		//current account
		System.out.println();
		System.out.println("enter the balance for current account: ");
		double cbal=sc.nextDouble();
		CurrentAccount ca= new CurrentAccount(cbal);
		b.addAcc(ca);
		
		System.out.println();
		sa.deposit(1500);
		sa.withdraw(200);
		System.out.println("savings interest: "+sa.calcint());
		
		System.out.println();
		ca.deposit(800);
		ca.withdraw(100);
		System.out.println("current interest: "+ca.calcint());
		
		System.out.println();		
		System.out.println("all accounts:");
		b.showAllAccounts();

	}

}
