/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aitbank.Accounts;

/**
 *
 * @author 7884
 */
public class FixedAccount extends AITBank{
    
    boolean hasWithdrawnEarly = false;
    
    
    public FixedAccount() {
        accountNumber = 1234;
        accountType = "Fixed";
        balance = 0;
        interestRate = (float) 0.12;    // I think by default it wanted to be a double
        withdrawLimit = 250;
        hasWithdrawLimit = false;
        dailySpentCounter = 0;
    }

    
    @Override
    public String withdraw(int ammount) {
        hasWithdrawnEarly = true;               // early withdrawn boolan
        return super.withdraw(ammount);
    }
    
    
    @Override
    public String toString() {
        return "AITBank:fixed {"+ "hasWithdrawnEarly= " + hasWithdrawnEarly + ", accountNumber= " + accountNumber + ", accountType= " + accountType + ", balance= " + balance + ", interestRate= " + interestRate + ", withdrawLimit= " + withdrawLimit + ", hasWithdrawLimit= " + hasWithdrawLimit + ", dailySpentCounter= " + dailySpentCounter + '}';
    }

    public boolean getHasWithdrawnEarly() {
        return hasWithdrawnEarly;
    }

    public void setHasWithdrawnEarly(boolean hasWithdrawnEarly) {
        this.hasWithdrawnEarly = hasWithdrawnEarly;
    }
    
    
    
}
