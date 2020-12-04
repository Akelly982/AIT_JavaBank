
package aitbank.Accounts;


interface ATMOperations {
    void deposit(double ammount);
    String withdraw(int ammount);
    String checkBalance();
    boolean login(String userPin);
}
