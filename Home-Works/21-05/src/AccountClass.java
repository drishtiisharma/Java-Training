//Q6. Write a Java program to create a class called "Account" with accno,name balance attributes and write methods openAcc,accEnq, withdraw, deposit.

import java.util.Scanner;

class Account{
	int accno;
	String name;
	double bal;
	
	void openAcc() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account number: ");
		accno=sc.nextInt();
		System.out.println("enter account name: ");
		name=sc.next();
		System.out.println("enter account balance: ");
		bal=sc.nextDouble();
	}
	
	void accEnq() {
		System.out.println();
		System.out.println("account number: "+accno);
		System.out.println("account name: "+name);
		System.out.println("account balance: "+bal);
	}
	
	void withdrawAmt(double amt) {
		bal-=amt;
		System.out.println("amount withdrawn: "+amt);
	}
	
	void depositAmt(double amt) {
		bal+=amt;
		System.out.println("amount deposited: "+amt);
	}
}


public class AccountClass {

	public static void main(String[] args) {
		Account a=new Account();
		a.openAcc();
		System.out.println();
		System.out.println("ACCOUNT DETAILS:");
		a.accEnq();
		a.withdrawAmt(200);
		System.out.println();
		System.out.println("ACCOUNT DETAILS AFTER WITHDRAWAL:");
		a.accEnq();
		a.depositAmt(1200);
		System.out.println();
		System.out.println("ACCOUNT DETAILS AFTER DEPOSITION:");
		a.accEnq();

	}

}
