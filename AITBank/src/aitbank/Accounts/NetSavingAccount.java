
package aitbank.Accounts;


public class NetSavingAccount extends AITBank{
    
    
        public NetSavingAccount() {
        accountNumber = 1234;
        accountType = "Net Savings";
        balance = 0;
        interestRate = (float) 0.06;
        withdrawLimit = 200;
        hasWithdrawLimit = true;
        dailySpentCounter = 0;
        }
    
        
            // can set withdraw limit
    public void changeWithdrawLimit(int newWithdrawLimit){
        super.withdrawLimit = newWithdrawLimit;
    }
}
