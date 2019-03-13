<%-- 
    Document   : error page
    Created on : Feb 4, 2019, 7:21:53 AM
    Author     : Pushkar and Shivani

    This page shows various errors occured in our application
--%>
<html>
    <head>
        <title>Error Page</title>       <%-- Page Title --%>
        <link rel="shortcut icon" href="cbseLogo.gif">      <%-- Favicon image that appears on the left side of the page title --%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> <%-- Link the Bootstrap CSS file in our application --%>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">  <%-- Set the document font as Raleway from google fonts collection --%>
        <link href="styles.css" rel="stylesheet">        <%-- Link the Stylesheet --%>
    </head>
    <body>
        <div class="container center">      <%-- Bootstrap class for showing content in center --%>
            <div class="alert alert-danger">     <%-- Bootstrap class for showing errors --%>
                <strong>
                    <%
                        if(request.getParameter("applied").equals("true"))
                        {
                            out.print("Already applied for CSSS...");
                        }
                        else if(request.getParameter("marks").equals("null"))    //If marks is null then show no record found error
                        {
                            out.println("No record found against Roll Number "+request.getParameter("rollnum")+" and Certificate Number "+request.getParameter("certiNumber"));
                        }
                        else
                        {
                            out.print("Your are not satisfying minimum eligibity percentage criteria which is 80%...");
                        }
                    %>
                </strong>
            </div>
        </div>
    </body>
</html>
