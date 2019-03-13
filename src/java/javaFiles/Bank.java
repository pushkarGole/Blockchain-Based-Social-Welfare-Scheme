/*
        Document   : Bank Class
        Created on : February ‎7, ‎2019, ‏‎6:58:30 AM
        Author     : Pushkar and Shivani

        This class contains various fields related to a Bank, getter and setter functions to access and modify these fields 
*/
package javaFiles;

public class Bank {
    private String bankIFSC;    //Bank IFSC code
    private String bankName;    //Bank Name
    private String bankAddress; //Bank Address
    private String bankPublicAddress; //Cryptographic public address assigned to bank

    //A constructor with three parameter account number, bank IFSC code, and bank address which is called when a new bank is created
    public Bank(String bankIFSC, String bankName, String bankAddress) {
        this.bankIFSC = bankIFSC;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    //Getter and Setter functions for various fields
    public String getBankIFSC() {
        return bankIFSC;
    }

    public void setBankIFSC(String bankIFSC) {
        this.bankIFSC = bankIFSC;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankPublicAddress() {
        return bankPublicAddress;
    }

    public void setBankPublicAddress(String bankPublicAddress) {
        this.bankPublicAddress = bankPublicAddress;
    }
    
    @Override
    public String toString() {
        return "Bank{" + "bankIFSC=" + bankIFSC + ", bankName=" + bankName + ", bankAddress=" + bankAddress + '}';
    }    
    
}
