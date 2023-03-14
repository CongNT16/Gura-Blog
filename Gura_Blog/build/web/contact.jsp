<%-- 
    Document   : contac
    Created on : Oct 18, 2022, 11:34:12 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact</title>
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="./assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="./assets/css/contact.css">
        <link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    </head>
    <body>
        
        <jsp:include page="layout/header.jsp" />
        
        <div class="container-contact">
            <div class="contact-box">
                <div class="left"></div>
                <div class="right">
                    <form action="ContactController" method="post">
                    <h2>Contact Laputa</h2>
                    <c:if test="${mess != null}">
                    <input type="text" class="field" placeholder="Mess" name="mess" value="${mess}" readonly>
                    </c:if>
                    <input type="text" class="field" placeholder="Your Name" name="name"  required minlength="2" maxlength="40">
                    <input type="text" class="field" placeholder="Your Email" name="email"  required minlength="2" maxlength="100">
                    
                    <textarea placeholder="Message" class="field" name="messdetail" required minlength="10" maxlength="500"></textarea>
                    <button class="btn" type="submit">Send</button>
                    </form>
                    <br>
                    <div class="social-media">
                        <ul>
                            <li><a href="https://www.facebook.com/nguyencong.1606/"><img src="assets/images/contact/facebook.png"></a></li>
                            <li><a href="https://www.linkedin.com/in/nguyencong1606/"><img src="assets/images/contact/linkedin.png"></a></li>
                            <li><a href="https://github.com/Laputa16"><img src="assets/images/contact/github.png"></a></li>
                            <li><a href="https://twitter.com/Laputa_1606"><img src="assets/images/contact/twitter.png"></a></li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="layout/footer.jsp" />
        
        
    </body>
    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
</html>