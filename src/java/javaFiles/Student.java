/*
        Document   : Student Class
        Created on : ‎February ‎7, ‎2019, ‏‎6:41:46 AM
        Author     : Pushkar and Shivani

        This class contains various fields related to a Student, getter and setter functions to access and modify these fields 
*/
package javaFiles;

public class Student {
    private int rollno;     //Roll number of class 12
    private String Name;    //Name of the student
    private String mothername;  //Mother's name of the student
    private String fathername;  //Father's name of the student
    private String studentEmail;    //Student e-mail
    private String studentPhone;    //Student mobile number
    private String adhaar;          //Student's aadhaar number
    private String address;         //Student's home address
    private String gender;          //Student's gender
    private String DOB;             //Date of birth of the student
    private String bankAccNumber;   //Bank account number of the student
    private String courseID;        //Course code of the student
    private String collegeID;       //College code in which student is studying
    private int courseMarks;      //Marks in pursuing course
    private int attendence;
    
    public Student(int rollno, String Name, String mothername, String fathername, String studentEmail, String studentPhone, String adhaar, String address, String gender, String DOB, String bankAccNumber, String courseID, String collegeID, int courseMarks) {
        this.rollno = rollno;
        this.Name = Name;
        this.mothername = mothername;
        this.fathername = fathername;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.adhaar = adhaar;
        this.address = address;
        this.gender = gender;
        this.DOB = DOB;
        this.bankAccNumber = bankAccNumber;
        this.courseID = courseID;
        this.collegeID = collegeID;
        this.courseMarks = courseMarks;
    }
    //Getter and Setter functions for various fields
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public int getCourseMarks() {
        return courseMarks;
    }

    public void setCourseMarks(int courseMarks) {
        this.courseMarks = courseMarks;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }
    
    
    @Override
    public String toString() {
        return "Student{" + "rollno=" + rollno + ", Name=" + Name + ", mothername=" + mothername + ", fathername=" + fathername + ", studentEmail=" + studentEmail + ", studentPhone=" + studentPhone + ", adhaar=" + adhaar + ", address=" + address + ", gender=" + gender + ", DOB=" + DOB + ", bankAccNumber=" + bankAccNumber + ", courseID=" + courseID + ", collegeID=" + collegeID + ", courseMarks=" + courseMarks + '}';
    }
   
    
}
