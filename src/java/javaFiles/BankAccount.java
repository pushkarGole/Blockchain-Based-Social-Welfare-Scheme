/*
        Document   : Bank Account Class
        Created on : Feb 20, 2019, ‏‎2:29:23 PM
        Author     : Pushkar and Shivani

        This class contains various fields related to a Bank Account and getter and setter functions to access and modify these fields 
*/

package javaFiles;

public class BankAccount {
    private String accountNumber;        //Bank account number 
    private String bankIFSC;            //Bank IFSC code
    private int accountBalance;       //Balance of the bank account
    private boolean activeStatus;       //Account active status

    //A constructor with two parameter account number and bank IFSC code which is called when a new account is created
    public BankAccount(String accountNumber, String bankIFSC) {
        this.accountNumber = accountNumber;
        this.bankIFSC = bankIFSC;
        this.accountBalance=0;       //Initial account balance is 0 INR 
        this.activeStatus=true;         //Intially account status is active
    }
    
    //Getter and Setter functions for various fields
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankIFSC() {
        return bankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        this.bankIFSC = bankIFSC;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isActive() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + ", bankIFSC=" + bankIFSC + ", accountBalance=" + accountBalance + ", aadhaarStatus=" + activeStatus + '}';
    }
    
    
    
}
