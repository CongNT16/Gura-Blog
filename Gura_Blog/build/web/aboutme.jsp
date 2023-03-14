<%-- 
    Document   : about_laputa
    Created on : Oct 13, 2022, 10:30:38 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About me</title>
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="assets/css/aboutme.css">
    </head>
    <body class="light-theme">

        <jsp:include page="layout/header.jsp" />  

            <div class="about">
                <div class="inner-section">
                    <h1>About Laputa</h1>
                    <p class="text">
                        
                        Hello everyone, my name is Laputa. My real name is Nguyen Thanh Cong. 
                        I want to share my knowledge as well as my experiences about daily life problems that 
                        I encounter, so I made this page. Hope you support. Anything please contact me. :3
                        
                    </p>
                    <div class="skills">
                        <a href="ContactController"><button>Contact</button></a>
                    </div>
                </div>
            </div>

        <jsp:include page="layout/footer.jsp" />  
    </body>
    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
</html>