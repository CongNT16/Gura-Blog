<%-- 
    Document   : login_client
    Created on : Oct 13, 2022, 10:30:56 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
                <div class="form sign-in">
                    <form action="LoginController" method="get">
                        <h2>Sign In</h2>
                        <label>
                            <span>Account</span>
                            <input id="account" type="text" name="account" value="${account}" pattern="^[0-9a-zA-Z]+$" title="không nhập ký tự đậc biệt" required minlength="2" maxlength="40">

                        </label>
                        <label>
                            <span>Password</span>
                            <input  id="password" type="password" name="password" value="${password}" required minlength="2" maxlength="40">
                        </label>
                        <c:if test="${mess != null}">
                            <div id ="mess" style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${mess}</p></div>
                                </c:if>
                        <button  id="checkSubmit" class="submit" type="submit" name="login" value="login">Sign In</button>


                        <p class="forgot-pass"><a href="forgot_password.jsp">Forgot Password ?</a></p>
                        <br>


                    </form>

                </div>

                <div class="sub-cont">
                    <div class="img">
                        <div class="img-text m-up">
                            <h2>New here?</h2>
                            <p>Sign up and interact with us!</p>

                        </div>
                        <div class="img-btn">
                            <span class="m-up">Sign Up</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <jsp:include page="layout/footer.jsp" />


</body>
<script type="text/javascript" src="./assets/js/register.js"></script>
<script type="text/javascript" src="./assets/js/datetime.js"></script>   
<script type="text/javascript" src="./assets/js/layout.js"></script>
</html>