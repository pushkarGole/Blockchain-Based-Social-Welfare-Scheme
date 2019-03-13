/*
        Document   : Course Class
        Created on : ‎February ‎7, ‎2019, ‏‎6:59:47 AM
        Author     : Pushkar and Shivani

        This class contains various fields related to a Course, getter and setter functions to access and modify these fields 
*/

package javaFiles;

public class Course {
    private final String courseID;  //Course id or course code
    private String courseName;      //Course name
    private String courseSubject;   //Course subject like Computer Science
    private String courseType;      //Course type like PG or UG
    private String courseApproval;  //Course approval authority like UGC or AICTE
    private String coursePattern;   //Course examination pattern like semester or annual
    private String courseDuration;  //Duration of the course

    public Course(String courseID, String courseName, String courseSubject, String courseType, String courseApproval, String coursePattern, String courseDuration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseSubject = courseSubject;
        this.courseType = courseType;
        this.courseApproval = courseApproval;
        this.coursePattern = coursePattern;
        this.courseDuration = courseDuration;
        
    }
    
    //Getter and Setter functions for various fields    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseApproval() {
        return courseApproval;
    }

    public void setCourseApproval(String courseApproval) {
        this.courseApproval = courseApproval;
    }

    public String getCoursePattern() {
        return coursePattern;
    }

    public void setCoursePattern(String coursePattern) {
        this.coursePattern = coursePattern;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", courseSubject=" + courseSubject + ", courseType=" + courseType + ", courseApproval=" + courseApproval + ", coursePattern=" + coursePattern + ", courseDuration=" + courseDuration + '}';
    }
            
}
