<%--
        Document   : CSSS Form Page
        Created on : Feb 3, 2019, 7:37:36 PM
        Author     : Pushkar and Shivani

        It is the CSSS form page which let students to fill CSSS form with various details
--%>

<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">  <%-- Set the document font as Raleway from google fonts collection --%>
        <link href="styles.css" rel="stylesheet">       <%-- Link the Stylesheet --%>
        <link rel="shortcut icon" href="cbseLogo.gif">  <%-- Favicon image that appears on the left side of the page title --%>
        <title>CSSS Form</title>                        <%-- Page Title --%>
        <%-- 
            Link the Jquery javascript that are available on google api for jquery
            we used these libraries to prevent back button
        --%>
        <script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>   
        <script src = "http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
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
		<td vAlign="middle" align="center" colSpan="2"><font color="#000080">
                    GOVERNMENT OF INDIA<br />MINISTRY OF HUMAN RESOURCE DEVELOPMENT<br />DEPARTMENT OF HIGHER EDUCATION
                    <br /><br />CENTRAL SECTOR SCHEME OF SCHOLARSHIP FOR COLLEGE AND UNIVERSITY STUDENTS
                    </font>
                </td>
            </tr>
        </table>
        
        <%-- 
            CSSS Registration form which is used to take input from user for various necessary field.
            This form is submitted using the POST method of HTTP protocol to processForm.jsp.
            Form is displayed in four steps
        --%> 
        
        <form id="regForm" action="processForm.jsp" method="POST" >
            <div class="tab"><h4>PERSONAL DETAILS</h4>
                <%--
                    This divison is for personal details : Tab 1
                --%>
                <p>Roll Number of Class XII<b style="color: red; font-size: 20px">*</b><input id='rollnum' type='number' placeholder="Roll Number of Class XII..." name='rollnum' oninput="this.className=''"/></p>
                <p>First Name<b style="color: red; font-size: 20px">*</b><input placeholder="First name..." oninput="this.className = ''" name="firstname"></p>
                <p>Last Name<b style="color: red; font-size: 20px">*</b><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                <p>Mother's Name<b style="color: red; font-size: 20px">*</b><input placeholder="Mother's Name..." oninput="this.className = ''" name="mname"></p>
                <p>Father's Name<b style="color: red; font-size: 20px">*</b><input placeholder="Father's name..." oninput="this.className = ''" name="fname"></p>
                <p>Email Address<b style="color: red; font-size: 20px">*</b><input id="semail" placeholder="Email..." oninput="this.className = ''" name="semail" type="email"></p>
                <p>Phone Number<b style="color: red; font-size: 20px">*</b><input id="sphn" placeholder="Phone Number..." oninput="this.className = ''" name="sphn" onkeypress="isNumber(event)"></p>
                <p>Aadhaar Number<b style="color: red; font-size: 20px">*</b><input id="adhaar" placeholder="Adhaar Number..." oninput="this.className = ''" name="adhaar" onkeypress="isNumber(event)"></p>
                <p>Address<b style="color: red; font-size: 20px">*</b>
                    <textarea name="address" placeholder="Communication Address" required id="address"></textarea>
                </p>
                <p>Gender<b style="color: red; font-size: 20px">*</b>
                    <select name="gender" required id="gender">
                        <option value="g" selected>Gender</option>
                        <option value="m">Male</option>
                        <option value="f">Female</option>
                        <option value="others">Others</option>
                    </select>
                </p>
                <p>Date of Birth<b style="color: red; font-size: 20px">*</b><input type="date" name="DOB" oninput="this.className=''" id="dob"/></p>
            </div>
            <div class="tab"><h4>COLLEGE DETAILS</h4>
                <%--
                    This divison is for college details : Tab 2
                --%>
                <p>College ID<b style="color: red; font-size: 20px">*</b><input type='text' placeholder="College ID..." oninput="this.className=''" name='cid'/></p>
                <p>College Name<b style="color: red; font-size: 20px">*</b><input placeholder="College Name..." oninput="this.className = ''" name="cname"></p>
                <p>College Email<b style="color: red; font-size: 20px">*</b><input id="cemail" placeholder="College Email..." oninput="this.className = ''" name="cemail" type="email"></p>
                <p>College Phone Number<b style="color: red; font-size: 20px">*</b><input id="cphn" placeholder="College Phone Number..." oninput="this.className=''" name="cphn"/></p>
                <p>College Type<b style="color: red; font-size: 20px">*</b>
                    <select id="ctype" name="ctype" required>
                        <option value="toc" selected>Type of Institution</option>
                        <option value="govt">Goverment</option>
                        <option value="pvt">Non-Goverment</option>
                    </select>
                </p>
                <p>College Address<b style="color: red; font-size: 20px">*</b>
                    <textarea id="caddress" name="caddress" placeholder="College Address" required></textarea>
                </p>
            </div>
            <div class="tab"><h4>COURSE DETAILS</h4>
                <%--
                    This divison is for course details : Tab 3
                --%>
                <p>Course ID<b style="color: red; font-size: 20px">*</b><input type='text' placeholder="College ID..." oninput="this.className=''" name='coid'/></p>
                <p>Course Name<b style="color: red; font-size: 20px">*</b><input placeholder="Course Name..." oninput="this.className = ''" name="coname"></p>
                <p>Course Subject<b style="color: red; font-size: 20px">*</b><input placeholder="Course Subject..." oninput="this.className = ''" name="csubject"></p>
                <p>Course Type<b style="color: red; font-size: 20px">*</b>
                    <select id="cotype" name="cotype" required>
                        <option value="cot" selected>Type of Course</option>
                        <option value="ug">Undergraduation Course</option>
                        <option value="pg">Postgraduation Course</option>
                    </select>
                </p>
                <p>Course Approval<b style="color: red; font-size: 20px">*</b>
                    <select id="coapproval" name="coapproval" required>
                        <option value="coappro" selected>Course Approval</option>
                        <option value="ugc">UGC</option>
                        <option value="aicte">AICTE</option>
                    </select>
                </p>
                <p>Course Pattern<b style="color: red; font-size: 20px">*</b>
                    <select id="copattern" name="copattren" required>
                        <option value="copatt" selected>Pattern of Examination</option>
                        <option value="sem">Semester</option>
                        <option value="trisem">Trimester</option>
                        <option value="annual">Annual</option>
                    </select>
                </p>
                <p>Course Duration<b style="color: red; font-size: 20px">*</b>
                    <select id="codur" name="codur" required>
                        <option value="codur" selected>Course Duration</option>
                        <option value="2">Two Years</option>
                        <option value="3">Three Years</option>
                        <option value="4">Four Years</option>
                    </select>
                </p>
                <p>Percentage Marks in Course<b style="color: red; font-size: 20px">*</b><input id="comarks" type="number" name="marks" oninput="this.className=''" placeholder="Percentage Marks"/></p>  
            </div>
            <div class="tab"><h4>BANK DETAILS</h4>
                <%--
                    This divison is for bank details : Tab 4
                --%>
                <p>Bank Account Number<b style="color: red; font-size: 20px">*</b><input id="baccnum" placeholder="Bank Account Number..." oninput="this.className = ''" name="baccnum" type="number"></p>
                <p>Bank IFSC code<b style="color: red; font-size: 20px">*</b><input id="bifsc" placeholder="Bank IFSC code " oninput="this.className = ''" name="bifsc" pattern="[A-Z]{4}[0-9]{7}"></p>
                <p>Bank Name<b style="color: red; font-size: 20px">*</b><input placeholder="Bank Name " oninput="this.className = ''" name="bname"></p>
                <p>Aadhaar Status<b style="color: red; font-size: 20px">*</b>
                    <select id="aadharstatus" name="aadharstatus" required>
                        <option value="adhrstat" selected>Aadhaar status</option>
                        <option value="yes">Linked with Account</option>
                        <option value="no">Not Linked with Account</option>
                    </select>
                </p>
                <p>Bank Address<b style="color: red; font-size: 20px">*</b>
                    <textarea id="baddress" name="baddress" placeholder="Bank Address" required></textarea>
                </p>
            </div>
            <div style="overflow:auto;">
                <div style="float:right;">
                    <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                    <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                </div>
            </div>
            <%-- Circles which indicates the steps of the form: --%>
            <div style="text-align:center;margin-top:40px;">
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
            </div>
        </form>
        <script>
            // Display the crurrent tab
            var currentTab = 0; // Current tab is set to be the first tab (0)
            showTab(currentTab);
            function showTab(n) // This function will display the specified tab of the form...
            {
                var x = document.getElementsByClassName("tab");
                x[n].style.display = "block";
                //... and fix the Previous/Next buttons:
                if (n === 0) 
                {
                    document.getElementById("prevBtn").style.display = "none";
                } 
                else 
                {
                    document.getElementById("prevBtn").style.display = "inline";
                }
                if (n === (x.length - 1)) 
                {
                    document.getElementById("nextBtn").innerHTML = "Submit";        //If last tab is diplayed then next button text is changed to submit 
                } 
                else 
                {
                    document.getElementById("nextBtn").innerHTML = "Next";
                }
                //... and run a function that will display the correct step indicator:
                fixStepIndicator(n)
            }

            function nextPrev(n) // This function will figure out which tab to display
            {
                var x = document.getElementsByClassName("tab");
                
                if (n == 1 && !validateForm()) // Exit the function if any field in the current tab is invalid:
                    return false;
                // Hide the current tab:
                x[currentTab].style.display = "none";
                // Increase or decrease the current tab by 1:
                currentTab = currentTab + n;
                // if you have reached the end of the form, the form gets submitted:
                if (currentTab >= x.length) 
                {
                    document.getElementById("regForm").submit();
                    return false;
                }
                // Otherwise, display the correct tab:
                showTab(currentTab);
            }
            function isNumber(evt) //This function returns true if and only if input is numeric otherwise it alert the user and return false
            {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57)) //ASCII code for numerics are 48 to 57
                {
                    alert("Please enter only Numbers.");
                    return false;
                }
                return true;
            }
            function validateone()          //This function validates the fields in tab 1: Personal details
            {
                var valid=true;
                var pattern=/^[0-9]{7}$/;               //Check wheather the Roll number is 7 digit
                var x=document.getElementById("rollnum");
                if(pattern.test(x.value)===false)
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Roll number must be 7 digit number..");  //Alert the user with necessary message
                    valid=false;            // And set the valid status to false which later returned 
                }
                
                //Check the validity of email
                x=document.getElementById("semail").value;
                var atpos = x.indexOf("@");
                var dotpos = x.lastIndexOf(".");
                if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) 
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Not a valid e-mail address...");     //Alert the user with necessary message
                    valid= false;       // And set the valid status to false which later returned 
                }
                
                //Check that phone number entered is of 10 digit and it is valid mobile number that starts with 6/7/8/9
                pattern = /^[6789]{1}[0-9]{9}$/;
                x=document.getElementById("sphn");
                if (pattern.test(x.value) === false) 
                {
                    x.className +=" inavlid";   // add an "invalid" class to the field:
                    alert("Please enter valid mobile number...");       //Alert the user with necessary message
                    valid=false;            // And set the valid status to false which later returned 
                }
                
                //Check that aadhaar number entered is of 12 digit
                pattern=/^[0-9]{12}$/;
                x=document.getElementById("adhaar");
                if(pattern.test(x.value)===false)
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Please enter a valid aadhaar number...");        //Alert the user with necessary message
                    valid=false;            // And set the valid status to false which later returned 
                }
                
                //Check that address entered is not empty
                x=document.getElementById("address");
                if(x.value==="")
                {
                    alert("Address cannot be empty.."); //Alert the user with necessary message
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    valid=false;            // And set the valid status to false which later returned 
                }
                
                //Check that a valid gender is selected or not
                x=document.getElementById("gender");
                if(x.value==="g")
                {
                    alert("Please select a valid gender..");        //Alert the user with necessary message
                    x.className +=" invalid";                       // add an "invalid" class to the field:
                    valid=false;                // And set the valid status to false which later returned 
                }
                
                
                x=document.getElementById("dob").value;
                //Check the entered date of birth is not empty
                if(x==="")          
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Date of Birth cannot be empty..");       //Alert the user with necessary message
                    valid=false;            // And set the valid status to false which later returned 
                }
                else
                {
                    var date=new Date(x);
                    var year=date.getFullYear();
                    var month=date.getMonth();
                    var day=date.getDate();
                    
                    //check if the age of the student is 18 or not
                    if(new Date(year+18, month, day) > new Date())
                    {
                        x.className +=" inavlid";       // add an "invalid" class to the field:
                        alert("Age should be at least 18...");      //Alert the user with necessary message
                        valid=false;        // And set the valid status to false which later returned 
                    }
                }
                return valid;
            }
            
            function validatetwo()      //This function validates the fields in tab 2: College details
            {
                var valid=true;
                //Check the validity of email
                var x=document.getElementById("cemail").value;
                var atpos = x.indexOf("@");
                var dotpos = x.lastIndexOf(".");
                if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) 
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Not a valid e-mail address...");     //Alert the user with necessary message
                    valid= false;           // And set the valid status to false which later returned 
                }
                
                //Check that mobile number entered is of 10 digit and it is valid mobile number that starts with 6/7/8/9
                var pattern = /^[6789]{1}[0-9]{9}$/;
                x=document.getElementById("cphn");
                if (pattern.test(x.value) === false) 
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Please enter valid mobile number...");       //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned 
                } 
                
                //Checks that valid college type is selected or not
                x=document.getElementById("ctype");
                if(x.value==="toc")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Please select a valid college type...");     //Alert the user with necessary message
                    valid=false;         // And set the valid status to false which later returned 
                }
                
                //Check that address entered is not empty
                x=document.getElementById("caddress");
                if(x.value==="")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("College address cannot be empty...");    //Alert the user with necessary message
                    valid=false;    // And set the valid status to false which later returned 
                }
                return valid;
            }
            
            function validatethree()        //This function validates the fields in tab 3: Course details
            {
                var valid=true;
                
                //Checks that valid course type is selected or not
                var x=document.getElementById("cotype");
                if(x.value==="cot")
                {
                    x.className +=" invalid";   // add an "invalid" class to the field:
                    alert("Please select a valid course type...");     //Alert the user with necessary message
                    valid=false;    // And set the valid status to false which later returned
                }
                
                //Checks that valid course approval authority is selected or not
                x=document.getElementById("coapproval");
                if(x.value==="coappro")
                {
                    x.className +=" invalid";   // add an "invalid" class to the field:
                    alert("Please select a valid course approval authority...");    //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                
                //Checks that valid course examination pattern is selected or not
                x=document.getElementById("copattern");
                if(x.value==="copatt")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Please select a valid course examination pattern...");    //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                
                //Checks that valid course duration is selected or not
                x=document.getElementById("codur");
                if(x.value==="codur")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Please select a valid course duration...");    //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                
                // Check that input marks is of greater than 60%
                pattern=/^[6789][0-9]|[1][0][0]$/;
                x=document.getElementById("comarks");
                if(pattern.test(x.value)===false)
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Marks should be greater than 60%");      //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                return valid;
            }
            
            function validatefour()
            {
                var valid=true;
                // Check that input bank account number is of 13 digit
                var pattern = /^[0-9]{13}$/;
                var x=document.getElementById("baccnum");       
                if (pattern.test(x.value) === false) 
                {
                    x.className +=" inavlid";       // add an "invalid" class to the field:
                    alert("Please enter valid account number...");  //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                
                //Check the validity of email
                pattern = /^[A-Z]{4}[0-9]{7}/;
                x=document.getElementById("bifsc");
                if (pattern.test(x.value) === false) 
                {
                    alert("Please enter valid IFSC code...");   //Alert the user with necessary message
                    x.className +=" inavlid";    // add an "invalid" class to the field:
                    valid=false;        // And set the valid status to false which later returned
                }
                
                //Checks that valid aadhaar status is selected or not
                x=document.getElementById("aadharstatus");
                if(x.value==="adhrstat")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Please select aadhaar status either valid or invalid...");   //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                
                //Check that Bank address entered is not empty
                x=document.getElementById("baddress");
                if(x.value==="")
                {
                    x.className +=" invalid";       // add an "invalid" class to the field:
                    alert("Bank address cannot be empty...");    //Alert the user with necessary message
                    valid=false;        // And set the valid status to false which later returned
                }
                return valid;
            }
            function validateForm() // This function deals with validation of the form fields
            {
                var x, y, i, valid = true;
                x = document.getElementsByClassName("tab");
                y = x[currentTab].getElementsByTagName("input");
                // A loop that checks every input field in the current tab:
                for (i = 0; i < y.length; i++) 
                {
                    // Check a field is empty or not
                    if (y[i].value === "") 
                    {
                        y[i].className += " invalid";       // add an "invalid" class to the field:
                        valid = false;          // and set the current valid status to false
                    }
                }
                
                //A switch which calls the various validation function for various tabs as indicated by currenTab
                // and assign the validation status to valid variable which returned later
                switch(currentTab)
                {
                    case 0:valid=validateone();
                           break;
                    case 1:valid=validatetwo();
                           break;
                    case 2:valid=validatethree();
                           break;
                    case 3:valid=validatefour();
                           break;
                }
    
                // If the valid status is true, mark the step as finished and valid:
                if (valid) 
                {
                    document.getElementsByClassName("step")[currentTab].className += " finish";
                }
  
                return valid; // return the valid status
            }

            function fixStepIndicator(n) // This function removes the "active" class of all steps...
            {
                var i, x = document.getElementsByClassName("step");
                for (i = 0; i < x.length; i++) 
                {
                    x[i].className = x[i].className.replace(" active", "");
                }
                //... and adds the "active" class on the current step:
                x[n].className += " active";
            }    
        </script>
    </body>
</html>