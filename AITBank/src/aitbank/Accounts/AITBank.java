
package aitbank.Accounts;


public abstract class AITBank implements ATMOperations {

    protected int accountNumber;
    protected String accountType;
    protected double balance;
    protected float interestRate;
    protected int withdrawLimit;
    protected boolean hasWithdrawLimit;
    protected int dailySpentCounter; 
    
    // login info
    protected String password = "1234";
    protected String userId = "1";



    public AITBank() {
    }



    
    @Override
    public void deposit(double ammount) {
        balance += ammount;
    }

    
    @Override  // check password is correct 
    public boolean login(String inputUserPin){     
        if (inputUserPin.equals(this.password)){
            return true;
        }
        return false;                     
    }
    
    @Override
    public String checkBalance(){
        String round = String.format("%.2f", this.balance);    // gets balance to 2 decimal places    (interest throws it off on calculation) 
        return "Balance = " + round;
    }

    @Override
    public String withdraw(int ammount) {
        if (hasWithdrawLimit){                                 // if you have a daily limit
           if (withdrawLimit > dailySpentCounter + ammount){  // if you arnt going over your daily limit
               if (ammount <= balance){                      // if you have enough funds
                   if ( ammount%20 == 0 || ammount%10 == 0 || ammount%50 == 0 ){  // if its is a multiple of note variations (50,20,10)
                       balance -= ammount;
                       dailySpentCounter += ammount;
                       return "Transaction Complete";
                   }
                   else {
                       return "Cant create requested ammount (50,20,10 notes only)";
                   }
                   
               }
               else{
                   return "Declined not enough funds in account";
               }
           }
           else{
               return "Declined over daily limit";
           }
            
        }
        else{
           if (ammount <= balance){   // if you haave enough funds
               if ( ammount%20 == 0 || ammount%10 == 0 || ammount%50 == 0 ){ // if its is a multiple of note variations
                       balance -= ammount;
                       dailySpentCounter += ammount;
                       return "Transaction Complete";
                }
                else {
                   return "Cant create requested ammount (50,20,10 notes)";
                }
            }
            else{
                return "Declined not enough funds in account";
            }
        }
        
    }
    
    public void addInterest(){
        balance += balance * interestRate;    // calculate and add interest
    }

    
    
    
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public boolean getHasWithdrawLimit() {
        return hasWithdrawLimit;
    }

    public void setHasWithdrawLimit(boolean hasWithdrawLimit) {
        this.hasWithdrawLimit = hasWithdrawLimit;
    }

    public int getDailySpentCounter() {
        return dailySpentCounter;
    }

    public void setDailySpentCounter(int dailySpentCounter) {
        this.dailySpentCounter = dailySpentCounter;
    }
    
    

    @Override
    public String toString() {
        return "AITBank{" + "accountNumber= " + accountNumber + ", accountType= " + accountType + ", balance= " + balance + ", interestRate= " + interestRate + ", withdrawLimit= " + withdrawLimit + ", hasWithdrawLimit= " + hasWithdrawLimit + ", dailySpentCounter= " + dailySpentCounter + '}';
    }
    

}
