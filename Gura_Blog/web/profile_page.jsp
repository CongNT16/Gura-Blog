<%-- 
    Document   : profile_page
    Created on : Oct 20, 2022, 12:14:55 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="assets/css/profile_page.css">
        <link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    </head>
    <body>

        <jsp:include page="layout/header.jsp" />

        <main class="container-main">
            <c:if test="${thread eq 1}">
                <c:if test="${sessionScope.user_infor_id != null}">
                    <div class="container-profile">


                        <div class="info-user">
                            <div class="avatar-user">
                                <img src="assets/images/${user_infor_avatar}" alt="avatar">
                                <div class="about_user" style="text-align: center; padding-top: 20px;font-style: italic;">
                                    <p>${user_infor_about}</p>
                                </div>
                            </div> 
                            <div class="main-info">
                                <h1>Profile 
                                    <c:if test="${user_infor_id eq user_login_id}">
                                        <div class="text-edit"><a href="ProfileUserController?thread=2&userid=${user_infor_id}">Edit <i class='bx bxs-edit'></a></i></div>
                                    </c:if>
                                </h1>
                                <div class="info-content">
                                    <table style="border-spacing:30px 0;">

                                        <tr>
                                        <div class="useraccount">
                                            <td>
                                                <div class="label" for="">Account</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_account}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <tr>
                                        <div class="username">
                                            <td>
                                                <div class="label" for="">Name</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_firstname}&nbsp;${user_infor_lastname}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <tr>
                                        <div class="usergender">
                                            <td>
                                                <div class="label" for="">Gender</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_gender}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <tr>
                                        <div class="userdob">
                                            <td>
                                                <div class="label" for="">Birthday</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_dob}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <tr>
                                        <div class="useremail">
                                            <td>
                                                <div class="label" for="">Email</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_email}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <c:if test="${user_infor_id eq user_login_id}">
                                        <tr>
                                        <div class="userphone">
                                            <td>
                                                <div class="label" for="">Phonenumber</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_phone}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        <tr>
                                        <div class="useraddress">
                                            <td>
                                                <div class="label" for="">Address</div> 
                                            </td>
                                            <td>
                                                <div class="info">${user_infor_address}</div>
                                            </td>

                                        </div>
                                        </tr>
                                        </c:if>
                                    </table>
                                    <input type="text" hidden class="id-user">
                                </div>

                            </div>            
                        </div>


                    </div>
                </c:if>
            </c:if>
            <c:if test="${user_infor_id eq user_login_id}">
                <c:if test="${thread eq 2}">
                    <c:if test="${sessionScope.user_infor_id != null}">
                        <div class="container-profile">

                            <div class="info-user">
                                <div class="avatar-user">
                                    <input name="userid" value="${user_infor_id}" hidden>
                                    <input name="user_edit_avatar" value="" hidden>
                                    <img src="assets/images/${user_edit_avatar}" alt="avatar">
                                    <div class="about_user" style="text-align: center; padding-top: 20px;font-style: italic;">
                                        <p>${user_edit_about}</p>
                                    </div>

                                </div> 
                                <div class="main-info">
                                    <h1>Profile 
                                        <div class="text-edit"><a href="ProfileUserController?thread=4&userid=${user_infor_id}">Change password <i class='bx bxs-edit'></a></i></div></h1>
                                    <div class="info-content">
                                        <form action="ProfileUserController" method="get">
                                            <input type="text" name="thread" value="3" hidden>
                                            <input type="text" name="userid" value="${userid}" hidden>
                                            <table style="border-spacing:30px 0;">

                                                <tr>
                                                <div class="useraccount">
                                                    <td>
                                                        <div class="label" for="">Account</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_account" value="${user_edit_account}" required minlength="2" maxlength="40">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${erraccount}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="userfirstname">
                                                    <td>
                                                        <div class="label" for="">First Name</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_firstname" value="${user_edit_firstname}">

                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errfirstname}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="userlastname">
                                                    <td>
                                                        <div class="label" for="">Last Name</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_lastname" value="${user_edit_lastname}">

                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errlastname}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="usergender">
                                                    <td>
                                                        <div class="label" for="">Gender</div> 
                                                    </td>
                                                    <td>
                                                        <input type="radio" name="user_edit_gender" value="1" checked>Male 
                                                        <input type="radio" name="user_edit_gender" value="0">Female
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errgender}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="userdob">
                                                    <td>
                                                        <div class="label" for="">Birthday</div> 
                                                    </td>
                                                    <td>
                                                        <input type="date" name="user_edit_dob" value="${user_edit_dob}">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errdob}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="useremail">
                                                    <td>
                                                        <div class="label" for="">Email</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_email" value="${user_edit_email}" required minlength="2" maxlength="200">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${erremail}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="userphone">
                                                    <td>
                                                        <div class="label" for="">Phonenumber</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_phone" value="${user_edit_phone}">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errphone}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="useraddress">
                                                    <td>
                                                        <div class="label" for="">Address</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_address" value="${user_edit_address}">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${erraddress}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <div class="userabout">
                                                    <td>
                                                        <div class="label" for="">About</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_about" value="${user_edit_about}" maxlength="200">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errabout}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <div class="useravatar">
                                                    <td>
                                                        <div class="label" for="">Avatar</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="user_edit_avatar" value="${user_edit_avatar}" required minlength="2" maxlength="50">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${erravartar}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                            </table>
                                            <button type="submit" style="margin-left: 300px;margin-top: 20px;">Save</button>

                                        </form>

                                    </div>
                                </div>            
                            </div>

                        </div>
                    </c:if>

                </c:if>  

                <c:if test="${thread eq 3}">
                    <c:if test="${sessionScope.user_infor_id != null}">
                        <div class="container-profile">


                            <div class="info-user">
                                <div class="avatar-user">
                                    <img src="assets/images/${user_infor_avatar}" alt="avatar">
                                    <div class="about_user" style="text-align: center; padding-top: 20px;font-style: italic;">
                                        <p>${user_infor_about}</p>
                                    </div>
                                </div> 
                                <div class="main-info">
                                    <h1>Change Password 
                                        <div class="text-edit"><a href="ProfileUserController?thread=1&userid=${user_infor_id}">Profile <i class='bx bxs-edit'></a></i></div></h1>
                                    <div class="info-content">
                                        <form action="ProfileUserController" method="get">
                                            <input type="text" name="thread" value="5" hidden>
                                            <input type="text" name="userid" value="${userid}" hidden>
                                            <table style="border-spacing:30px 0;">

                                                <tr>
                                                <div class="oldpassword">
                                                    <td>
                                                        <div class="label" for="">Old Password</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="oldpass" value="${oldpass}" required minlength="2" maxlength="40">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${erroldpass}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="oldpassword">
                                                    <td>
                                                        <div class="label" for="">New Password</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="newpass1" value="${newpass1}" required minlength="2" maxlength="40">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errnewpass1}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                                <tr>
                                                <div class="oldpassword">
                                                    <td>
                                                        <div class="label" for="">Confirm Password</div> 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="newpass2" value="${newpass2}" required minlength="2" maxlength="40">
                                                    </td>
                                                    <td>
                                                        <p style="font-size: 8pt;color: red;">${errnewpass2}</p>
                                                    </td>

                                                </div>
                                                </tr>
                                            </table>
                                            <button type="submit" style="margin-left: 300px;margin-top: 20px;">Save</button>
                                        </form>
                                    </div>

                                </div>            
                            </div>


                        </div>
                    </c:if>
                </c:if>
            </c:if>
        </main>

        <jsp:include page="layout/footer.jsp" />

    </body>

    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
</html>
