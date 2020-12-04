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
public class ChequeAccount extends AITBank {

    
    public ChequeAccount() {
        accountNumber = 1234;
        accountType = "Cheque";
        balance = 0;
        interestRate = 0;
        withdrawLimit = 0;
        hasWithdrawLimit = false;
        dailySpentCounter = 0;
    }

    
}
