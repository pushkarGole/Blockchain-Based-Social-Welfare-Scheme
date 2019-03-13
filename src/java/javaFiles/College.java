/*
        Document   : College Class
        Created on : ‎February ‎7, ‎2019, ‏‎6:56:33 AM
        Author     : Pushkar and Shivani

        This class contains various fields related to a College, getter and setter functions to access and modify these fields 
*/
package javaFiles;

public class College {
    private String collegeID;       //College identity or college code 
    private String collegeName;     //College name
    private String collegeEmail;    //College E-mail
    private String collegePhone;    //College phone number
    private String collegetype;     //College type like goverment or private
    private String collegeAddress;  //College address
    private String collegePublicAddress;    //Cryptographic public address assigned to college

    public College(String courseID, String collegeName, String collegeEmail, String collegePhone, String collegetype, String collegeAddress) {
        this.collegeID = courseID;
        this.collegeName = collegeName;
        this.collegeEmail = collegeEmail;
        this.collegePhone = collegePhone;
        this.collegetype = collegetype;
        this.collegeAddress = collegeAddress;
    }

    //Getter and Setter functions for various fields
    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getCollegePhone() {
        return collegePhone;
    }

    public void setCollegePhone(String collegePhone) {
        this.collegePhone = collegePhone;
    }

    public String getCollegetype() {
        return collegetype;
    }

    public void setCollegetype(String collegetype) {
        this.collegetype = collegetype;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegePublicAddress() {
        return collegePublicAddress;
    }

    public void setCollegePublicAddress(String collegePublicAddress) {
        this.collegePublicAddress = collegePublicAddress;
    }
    
    @Override
    public String toString() {
        return "College{" + "courseID=" + collegeID + ", collegeName=" + collegeName + ", collegeEmail=" + collegeEmail + ", collegePhone=" + collegePhone + ", collegetype=" + collegetype + ", collegeAddress=" + collegeAddress + '}';
    }

    
    
}
