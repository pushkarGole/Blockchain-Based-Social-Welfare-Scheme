/*
        Document   : CBSE Students Class
        Created on : ‎February ‎7, ‎2019, ‏‎6:46:20 AM
        Author     : Pushkar and Shivani

        This class contains various fields related to a CBSE student, getter and setter functions to access and modify these fields 
*/
package javaFiles;

public class CBSEStudent {
    
    private String CSSSRegNumber; //CSSS Registration number
    private String rollNumber;       //Roll number of class 12
    private String CertificateNumber;   //Certificate number of class 12 marksheet
    private int passingYear;            //Passing year
    private float amountReceived;       //Amount Received 
    private int marks;                //Marks in class 12
    private boolean appliedForCSSS;     //Status bit to check wheather student applied or not
    public CBSEStudent(String rollNumber, String CertificateNumber, int passingYear, int marks) {
        this.rollNumber = rollNumber;
        this.CertificateNumber = CertificateNumber;
        this.passingYear = passingYear;
        this.marks = marks;
        this.amountReceived=0.0f;   //Intially amount received is 0
        this.appliedForCSSS=false;
    }
    
    //Getter and Setter functions for various fields
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCertificateNumber() {
        return CertificateNumber;
    }

    public void setCertificateNumber(String CertificateNumber) {
        this.CertificateNumber = CertificateNumber;
    }

    public String getCSSSRegNumber() {
        return CSSSRegNumber;
    }

    public void setCSSSRegNumber(String CSSSRegNumber) {
        this.CSSSRegNumber = CSSSRegNumber;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public float getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(float amountReceived) {
        this.amountReceived = amountReceived;
    }

    public boolean isAppliedForCSSS() {
        return appliedForCSSS;
    }

    public void setAppliedForCSSS(boolean appliedForCSSS) {
        this.appliedForCSSS = appliedForCSSS;
    }

    @Override
    public String toString() {
        return "CBSEStudent{" + "CSSSRegNumber=" + CSSSRegNumber + ", rollNumber=" + rollNumber + ", CertificateNumber=" + CertificateNumber + ", passingYear=" + passingYear + ", amountReceived=" + amountReceived + ", marks=" + marks + ", appliedForCSSS=" + appliedForCSSS + '}';
    }
    
    
}
