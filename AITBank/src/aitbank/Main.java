
package aitbank;
import aitbank.Accounts.AITBank;
import aitbank.Accounts.ChequeAccount;
import aitbank.Accounts.FixedAccount;
import aitbank.Accounts.NetSavingAccount;
import aitbank.Accounts.SavingAccount;

public class Main {
    
    public static void main(String[] args) {
       ChequeAccount testCheque = new ChequeAccount();
       FixedAccount testFixed = new FixedAccount();
       NetSavingAccount testNetSavings = new NetSavingAccount();
       SavingAccount testSavings = new SavingAccount();
       
       
       
       System.out.println("Cheque Test");
       System.out.println(testCheque.toString());
       System.out.println(testCheque.checkBalance());
       System.out.println("Deposit 100");
       testCheque.deposit(100);
       System.out.println(testCheque.checkBalance());
       System.out.println("withdraw 1000");
       System.out.println(testCheque.withdraw(1000));      
       System.out.println(testCheque.checkBalance());
       System.out.println("withdraw 45                -------  check correct notes 50,20,10 needed/available for withdraw");   
       System.out.println(testCheque.withdraw(45));
       System.out.println(testCheque.checkBalance());
       
       System.out.println("");
       System.out.println("");
       
       System.out.println("savings Test");
       System.out.println(testSavings.toString());
       System.out.println(testSavings.checkBalance());
       System.out.println("Deposit 100");
       testSavings.deposit(100);
       System.out.println(testSavings.checkBalance());
       System.out.println("withdraw 1000");
       System.out.println(testSavings.withdraw(1000));
       System.out.println("Deposit 1000");
       testSavings.deposit(1000);
       System.out.println(testSavings.checkBalance());
       System.out.println("withdraw 200");
       System.out.println(testSavings.withdraw(200));
       System.out.println("withdraw limit set 500                   -----------  check withdraw limit change");
       testSavings.changeWithdrawLimit(500);
       System.out.println("withdraw 200");
       System.out.println(testSavings.withdraw(200));
       System.out.println(testSavings.checkBalance());
       
       System.out.println("");
       System.out.println("");
       
       System.out.println("Netsavings Test");
       System.out.println(testNetSavings.toString());
       System.out.println(testNetSavings.checkBalance());
       System.out.println("Deposit 100");
       testNetSavings.deposit(100);
       System.out.println(testNetSavings.checkBalance());
       System.out.println("withdraw 1000");
       System.out.println(testNetSavings.withdraw(1000));
       System.out.println(testNetSavings.checkBalance());
       System.out.println("withdraw 50");
       System.out.println(testNetSavings.withdraw(50));
       System.out.println(testNetSavings.checkBalance());
       
       System.out.println("");
       System.out.println("");
       
       System.out.println("Fixed Test");
       System.out.println(testFixed.toString());
       System.out.println(testFixed.checkBalance());
       System.out.println("Deposit 100");
       testFixed.deposit(152.5);
       System.out.println(testFixed.checkBalance());
       System.out.println("withdraw 1000");
       System.out.println(testFixed.withdraw(1000));
       System.out.println(testFixed.checkBalance());
       System.out.println("withdraw 50");
       System.out.println(testFixed.withdraw(50));
       System.out.println(testFixed.checkBalance());
       System.out.println("Calculate Interest                 ----- test addInterest()");
       testFixed.addInterest();
       System.out.println(testFixed.checkBalance());
       System.out.println("                     -------   below checking earlyWithdrawn boolean");
       System.out.println(testFixed.toString());
    }
     
     
     
}
