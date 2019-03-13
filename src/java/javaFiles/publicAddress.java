/*
        Document   : Public Address Class
        Created on : March ‎3, ‎2019, ‏‎2:23:24 PM
        Author     : Pushkar and Shivani

        This class contains various fields related to a Cryptographic Public address, getter and setter functions to access and modify these fields 
*/
package javaFiles;

public class publicAddress {
    private String PublicAddress;   //Cryptographic Public address
    private String addressType;     //Address assign to whom like student, bank, and college
    private boolean assigned;       //Address assigned or not

    public publicAddress(String PublicAddress, String addressType) {
        this.PublicAddress = PublicAddress;
        this.addressType = addressType;
        this.assigned = false;      //default assigned status is false
    }
    
    //Getter and Setter functions for various fields
    public String getPublicAddress() {
        return PublicAddress;
    }

    public void setPublicAddress(String PublicAddress) {
        this.PublicAddress = PublicAddress;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "publicAddress{" + "PublicAddress=" + PublicAddress + ", addressType=" + addressType + ", assigned=" + assigned + '}';
    }
    
       
    
}
