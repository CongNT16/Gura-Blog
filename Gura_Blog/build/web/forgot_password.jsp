<%-- 
    Document   : forgot_password
    Created on : Oct 19, 2022, 7:53:40 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
    </head>
    <body>

        <jsp:include page="layout/header.jsp" />

        <div class="main_login">

            <div class="cont">
                <div class="form sign-in" style="margin-top:-30px;">
                    <form action="LoginController" method="post">
                        <h2 class="forgot_h2">Forgot Password</h2>
                        <label>
                            <span>Account</span>
                            <input type="text" name="account" value="${account}" required minlength="2" maxlength="30">
                        </label>
                        <c:if test="${errall != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${errall}</p></div>
                        </c:if>
                        <label>
                            <span>Email</span>
                            <input type="email" name="email" value="${email}" required minlength="2" maxlength="50">
                        </label>
                        
                        <label>
                            <span>New Password</span>
                            <input type="password" name="newpassword1" required minlength="2" maxlength="30">
                        </label>
                        <c:if test="${errpass != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${errpass}</p></div>
                        </c:if>
                        <label>
                            <span>Renew Password</span>
                            <input type="password" name="newpassword2" required minlength="2" maxlength="30">
                        </label>
                        
                        <button class="submit" type="submit" name="login" value="login">Update</button>
                        
                    </form>
                        <p>${mess}</p>
                </div>

                <div class="sub-cont">
                    <div class="img">
                        <div class="img-text m-up">
                            <h2>Continue to login.</h2>
                            <p>Update your password and login again!</p>
                        </div>    
                        <div class="img-btn">
                            <span class="m-up">Sign In</span>
                        </div>
                    </div>

                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="layout/footer.jsp" />


    </body>
    <script type="text/javascript" src="./assets/js/login.js"></script>
    <script type="text/javascript" src="./assets/js/datetime.js"></script>   
    <script type="text/javascript" src="./assets/js/layout.js"></script>
</html>
