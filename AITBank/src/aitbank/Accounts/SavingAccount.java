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
public class SavingAccount extends AITBank{

    
    
    
    public SavingAccount() {
        accountNumber = 1234;
        accountType = "Savings";
        balance = 0;
        interestRate = (float) 0.02;
        withdrawLimit = 150;
        hasWithdrawLimit = true;
        dailySpentCounter = 0;
    }

    // can set withdraw limit
    public void changeWithdrawLimit(int newWithdrawLimit){
        super.withdrawLimit = newWithdrawLimit;
    }


}
    
    
