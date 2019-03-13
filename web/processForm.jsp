<%-- 
    Document   : processForm
    Created on : Feb 4, 2019, 7:21:53 AM
    Author     : pushkar
    
    This JSP page process CSSS form and update the database
--%>



<%@page import="javaFiles.BankAccount"%>
<%@page import="javaFiles.Bank"%>
<%@page import="javaFiles.Course"%>
<%@page import="javaFiles.College"%>
<%@page import="javaFiles.Database"%>
<%@page import="javaFiles.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Untitled Page</title>
    </head>
    <body>
        <%
           
            /*Fetch Personal Details from HTTP Request object*/
            int rollnumber=Integer.parseInt(request.getParameter("rollnum"));
            String Name=request.getParameter("firstname")+" "+request.getParameter("lname");
            String mothername=request.getParameter("mname");
            String fathername=request.getParameter("fname");
            String studentEmail=request.getParameter("semail");
            String studentPhone=request.getParameter("sphn");
            String adhaar=request.getParameter("adhaar");
            String address=request.getParameter("address");
            String gender=request.getParameter("gender");
            String DOB=request.getParameter("DOB");
            
            //out.print(Name+":"+mothername+":"+fathername+":"+studentEmail+":"+studentPhone+":"+adhaar+":"+address+":"+gender+":"+DOB);
            
            /*Fetch College Details from HTTP Request object*/
            String collegeID=request.getParameter("cid");
            String collegeName=request.getParameter("cname");
            String collegeEmail=request.getParameter("cemail");
            String collegePhone=request.getParameter("cphn");
            String collegetype=request.getParameter("ctype");
            String collegeAddress=request.getParameter("caddress");
            
            //out.print(collegeName+":"+collegeEmail+":"+collegePhone+":"+collegetype+":"+collegeAddress);
            
            /*Fetch Course Details from HTTP Request object*/
            String courseID=request.getParameter("coid");
            String courseName=request.getParameter("coname");
            String courseSubject=request.getParameter("csubject");
            String courseType=request.getParameter("cotype");
            String courseApproval=request.getParameter("coapproval");
            String coursePattern=request.getParameter("copattren");
            String courseDuration=request.getParameter("codur");
            float courseMarks=Float.parseFloat(request.getParameter("marks"));
            //out.print(courseName+":"+courseSubject+":"+courseType+":"+courseApproval+":"+coursePattern+":"+courseDuration+":"+marks);
            
            /*Fetch Bank Details from HTTP Request object*/            
            String bankAccnumber=request.getParameter("baccnum");
            String bankIFSC=request.getParameter("bifsc");
            String bankName=request.getParameter("bname");
            String adhaarStat=request.getParameter("aadharstatus");
            String bankAddress=request.getParameter("baddress");
            //out.print(bankAccnumber+":"+bankIFSC+":"+bankName+":"+adhaarStat+":"+bankAddress);
            
            
            boolean flag=false;
            //Create a new student with necessary details using Student class defined in javaFiles package
            Student s=new Student(rollnumber, Name, mothername, fathername, studentEmail, studentPhone, adhaar, address, gender, DOB, bankAccnumber, courseID, collegeID, courseMarks);
            //Create a new database object which is used to perform various operations on the database
            Database db=new Database();
            try
            {
                db.RetriveStudent("rollno",rollnumber);
                //If Student applied already for the scholarship then redirect it to error page with parameter applied=true
                response.sendRedirect("error.jsp?applied=true");
            }
            catch(IndexOutOfBoundsException e)
            {
                //If student not applied before then add it to the database and set the flag to true
                flag=true;
                db.create_row(s); 
            }
            
            College college=new College(collegeID, collegeName, collegeEmail, collegePhone, collegetype, collegeAddress);
            try
            {
                //If College exist then do nothing
                db.RetriveCollege("collegeID",collegeID);
            }
            catch(IndexOutOfBoundsException e)
            {
                //else add the college to database
                db.create_row(college);
            }
            Course course=new Course(courseID, courseName, courseSubject, courseType, courseApproval, coursePattern, courseDuration);
            try
            {
                //If Course exist then do nothing
                db.RetriveCourse("courseID",courseID);
            }
            catch(IndexOutOfBoundsException e)
            {
                //else add the college to database
                db.create_row(course);
            }
            Bank bank=new Bank(bankIFSC, bankName, bankAddress);
            try
            {
                //If Bank exist then do nothing
                out.print(db.RetriveBank("bankIFSC",bankIFSC));
            }
            catch(IndexOutOfBoundsException e)
            {
                //else add the Bank to database
                db.create_row(bank);
            }
            BankAccount bankAccount=new BankAccount(bankAccnumber, bankIFSC);
            try
            {
                //If Bank Account exist then do nothing
                db.RetriveBankAccount("accountNumber", bankAccnumber);
            }
            catch(IndexOutOfBoundsException e)
            {
                //else add the Bank account to database
                db.create_row(bankAccount);
            }
            if(adhaarStat.equals("No"))
            {
                //Update the account active status if it is closed
                db.UpdateQueryBankAccount("accountNumber", bankAccnumber,"activeStatus", false);
            }
            if(flag)
            {
                response.sendRedirect("success.html");
            }
            
        %>
    </body>
</html>
