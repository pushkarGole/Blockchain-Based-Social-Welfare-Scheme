<%-- 
    Document   : processLogin
    Created on : Feb 3, 2019, 7:37:36 PM
    Author     : Pushkar and Shivani

    This document performs the processing after user submits the login form it 
    also checks that wheather a student exist or not in CBSE database.
    If Student exist then it redirects the page to CSSS form where student can fill the Scholarship form
    otherwise it redirects to the error page with necessary message.
--%>

<%@page import="javaFiles.CBSEStudent"%>
<%@page import="javaFiles.Database"%>
<%@page import="javaFiles.VerifyCaptcha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Untitled Page</title>
    </head>
    <body>
       
        <%
            /*
                Parse the necessary details from the HTTP Request that is made from previous page
            */
            int rollnum=Integer.parseInt(request.getParameter("rollnum"));
            String certinumber=request.getParameter("cnumber");
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");   //Parse the Google Recaptcha input from the HTTP Request
            
            //Verify the Google by sending a POST request to Google Recaptcha API 
            //POST request is done in a user defined function name verifyCaptcha in VerifyCaptcha class
            boolean verify=VerifyCaptcha.verifyCaptcha(gRecaptchaResponse);     //Output is stored in a boolean variable named verify
            
            if(!verify)                         //if verification fails then it redirects user back to login form
            {
                response.sendRedirect("index.jsp");
            }
            else            //Otherwise search the database against the specified Roll number and certificate number
            {
                Database db=new Database();
                CBSEStudent s;
                try
                {
                    s=db.RetriveCBSEStudent("rollNumber",Integer.toString(rollnum),"CertificateNumber",certinumber);
                    
                    if(s.getMarks()>80.0f)      //If the marks of the student is greater than 80% then only CSSS form is displayed
                    {
                        response.sendRedirect("csssform.jsp");
                    }
                    else    //Otherwise user is redirected to error page with necesaary message
                    { 
                        response.sendRedirect("error.jsp?marks=" +s.getMarks()+"&applied=null");
                    }
                }
                
                //If their is no record found against mentioned Roll number and certificate number 
                //then user is redirected to error page with necesaary message
                catch(IndexOutOfBoundsException e)
                {
                    response.sendRedirect("error.jsp?rollnum="+rollnum+"&certiNumber="+certinumber+"&marks=null&applied=null");
                }
            }
        %>
    </body>
</html>
