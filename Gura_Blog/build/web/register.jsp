<%-- 
    Document   : register
    Created on : Oct 28, 2022, 8:25:14 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
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
                <div class="form sign-in" style="margin-top: -40px;">
                    <form action="RegisterController" method="post">
                        <h2>Sign Up</h2>
                        <label >
                            <span>Account</span>
                            <input type="text" name="account" pattern="^[0-9a-zA-Z]+$" title="không nhập ký tự đậc biệt" required minlength="2" maxlength="30">
                        </label>
                        <c:if test="${erraccount != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${erraccount}</p></div>
                                </c:if>

                        <label>
                            <span>Email</span>
                            <input type="email" name="email" required minlength="2" maxlength="50">
                        </label>
                        <c:if test="${erremail != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${erremail}</p></div>
                                </c:if>
                        <label>
                            <span>Password</span>
                            <input type="password" name="password1" required minlength="2" maxlength="30">
                        </label>
                        <c:if test="${errpass != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${errpass}</p></div>
                                </c:if>
                        <label>
                            <span>Confirm Password</span>
                            <input type="password" name="password2" required minlength="2" maxlength="30">
                        </label>
                        <c:if test="${errall != null}">
                            <div style="color: red;font-size: 10px; text-align: center; margin-bottom: -20px;"><p>${errall}</p></div>
                                </c:if>


                        <button class="submit" type="submit">Sign Up Now</button>


                    </form>

                </div>

                <div class="sub-cont">
                    <div class="img">
                        <div class="img-text m-up">
                            <h2>One of us?</h2>
                            <p>If you already has an account, just sign in. We've missed you!</p>

                        </div>
                        <div>

                        </div>

                        <div class="img-btn">
                            <span class="m-up">Sign In</span>
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
