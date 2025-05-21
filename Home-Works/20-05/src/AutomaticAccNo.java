import java.util.Scanner;

class Account {
    static int StartingAccNo = 1000; 
    int accno;
    String name;
    double bal;

    void openAcc() {
        Scanner sc = new Scanner(System.in);

        StartingAccNo++;          
        accno = StartingAccNo;    

        System.out.println("Account Number: " + accno);

        System.out.println("Enter account name:");
        name = sc.next();

        System.out.println("Enter account balance:");
        bal = sc.nextDouble();
    }

    void enq() {
        System.out.println("Account number: " + accno);
        System.out.println("Account name: " + name);
        System.out.println("Account balance: " + bal);
    }

}

public class AutomaticAccNo {

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.openAcc();
        System.out.println();

        Account a2 = new Account();
        a2.openAcc();
        System.out.println();
        
        a1.enq();
        System.out.println();
        a2.enq();


    }
}
