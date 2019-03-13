<%--
        Document   : Login Page
        Created on : Feb 3, 2019, 7:37:36 PM
        Author     : Pushkar and Shivani

        This is the first page loaded when our application is loaded.
        It is a login page which let students to fill Login form using Roll Number and Certificate Number
--%>

<html>
    <head>
        <title>Sign in</title>      <%-- Page Title --%>
        <link rel="shortcut icon" href="cbseLogo.gif">      <%-- Favicon image that appears on the left side of the page title --%>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">  <%-- Set the document font as Raleway from google fonts collection --%>
        <link href="styles.css" rel="stylesheet">       <%-- Link the Stylesheet --%>
        
        <%-- 
            Link the Jquery javascript that are available on google api for jquery
            we used these libraries to prevent back button
        --%>
        <script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>   
        <script src = "http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>  
        
        <%--
            Link the google's recaptcha javascript to our document
        --%>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    
    <body>
        <%-- Code to create the header of our HTML page --%>
        <center>
            <table bgcolor="#0099CC" width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td valign="top" align="center"><br>
                        <p align="center"><font face="Tahoma" color="#FFaFFFF" size="4"><img border="0" src="cbselogoh.jpg" width="276" height="27"><br>
                        CENTRAL BOARD OF SECONDARY EDUCATION</font></p><br>
                    </td>
                </tr>
            </table>
        </center>
        <table cellSpacing="0" cellPadding="0" width="100%" border="0">
            <tr>
		<td vAlign="middle" align="center" colSpan="2">&nbsp;</td>
            </tr>
            <tr>
                <td vAlign="middle" align="center" colSpan="2">
                    <font color="#000080">
                        GOVERNMENT OF INDIA<br />MINISTRY OF HUMAN RESOURCE DEVELOPMENT<br />DEPARTMENT OF HIGHER EDUCATION
                        <br /><br />CENTRAL SECTOR SCHEME OF SCHOLARSHIP FOR COLLEGE AND UNIVERSITY STUDENTS
                    </font>
                </td>
            </tr>
        </table>
        
        <%-- 
            Login form which is used to take input from user.
            This form is submitted if and only if validateForm() returns true using POST method of HTTP protocol to processLogin.jsp.
            validateForm() returns true if all input fields are validated correctly
        --%> 
        
        <form id="loginForm" action="processLogin.jsp" method="POST" onsubmit="return validateForm()">  
            <div class="tab"><h4>LOGIN DETAILS</h4>
                <p>Roll Number<input id="rollnum" type="number" placeholder="Examination Roll Number of Class 12..." oninput="this.className = ''" name="rollnum"></p> 
                <p>Certificate Number<input id="cnumber" type="number" placeholder="Certificate Number of Class 12..." oninput="this.className=''" name="cnumber"/></p>
                <p>Passing Year<input id="curryear" type="number" placeholder="Year of Passing..." oninput="this.className=''" name='yop'/></p>
                <p>Percentage Marks<input id="marks" type='number' name='marks' oninput="this.className=''" placeholder="Percentage of Marks in Class 12..."/></p>
            <div style="overflow:auto;">
            <div style="float:right;">
                <%-- 
                    A division that is defined in google's recaptcha library and it is used to 
                    display the google recaptcha using a private key generated at google side for a particular site
                --%>
                <div class="g-recaptcha" data-sitekey="6Lfcb5IUAAAAAJrrmiHsSf7fP7omNYxvReskxlci" id="recaptcha"></div>
                    <input type="submit" id="submitbtn" value="LOGIN TO CONTINUE" style="background-color: #4CAF50;
                    color: #ffffff;
                    border: none;
                    padding: 10px 20px;
                    font-size: 17px;
                    font-family: Raleway;
                    cursor: pointer;"/>
                </div>
            </div>
        </form>
        <script>
            
            //A variable used to show the current tab 
            var currentTab = 0; // Current tab is set to be the first tab (0)
            showTab(currentTab);
            
            // Jquery Code to prevent disable browser back button
            $(document).ready(function()        //Exceute the following function when document is loaded
            {
                function disablePrev() 
                { 
                    window.history.forward();  //Move the page to forward in history
                }
                window.onload = disablePrev();  
                window.onpageshow = function(evt) { if (evt.persisted) disableBack(); };
            });
            
            function showTab(n) // This function will display the specified tab of the form...
            {
                var x = document.getElementsByClassName("tab");     //get the tab object from HTML form
                x[n].style.display = "block";                       //Display it in block style
            }

            function validateForm()         // This function deals with validation of the form fields
            {
                var x, y, i, valid = true;
                x = document.getElementsByClassName("tab");
                y = x[currentTab].getElementsByTagName("input");
                // A loop that checks every input field in the current tab:
                for (i = 0; i < y.length; i++) 
                {
                    if (y[i].value === "") // If a field is empty...
                    {
                        y[i].className += " invalid";   // add an "invalid" class to the field:
                        valid = false;                  // And set the valid status to false which is later returned
                    }
                } 
                
                // Check if the entered year is not greater than current year  
                var today=new Date();
                var year=document.getElementById("curryear");
                if(year.value>today.getFullYear())
                {
                    year.className +=" invalid";        // add an "invalid" class to the field:
                    alert("Please enter a valid year..");   //Alert the user with necessary message
                    valid=false;                        // And set the valid status to false which is later returned
                }
                
                // Check that input roll number is of 7 digit
                var pattern=/^[0-9]{7}$/;
                x=document.getElementById("rollnum");
                if(pattern.test(x.value)===false)
                {
                    alert("Roll number must be 7 digit number..");      //Alert the user with necessary message
                    valid=false;            // And set the valid status to false which is later returned
                }
                
                // Check that input certificate number is of 10 digit
                pattern=/^[0-9]{10}$/;
                x=document.getElementById("cnumber");
                if(pattern.test(x.value)===false)
                {
                    alert("Certificate number must be 10 digit number..");      //Alert the user with necessary message
                    valid=false;                                                // And set the valid status to false which is later returned
                }
                
                // Check that input marks is of greater than 80%
                pattern=/^[89][0-9]|[1][0][0]$/;
                x=document.getElementById("marks");
                if(pattern.test(x.value)===false)
                {
                    alert("Marks should be greater than 80%");          //Alert the user with necessary message
                    valid=false;                                        // And set the valid status to false which is later returned
                } 
                return valid;
            }
        </script>
    </body>
</html>
