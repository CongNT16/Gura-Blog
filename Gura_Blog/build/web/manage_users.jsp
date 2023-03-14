<%-- 
    Document   : manage_users_listuser
    Created on : Oct 22, 2022, 11:11:25 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Manage Home</title>
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://unicons.iconscout.com/release/v3.0.6/css/line.css'>
        <link href="./assets/css/manage_layout.css" rel="stylesheet">

    </head>
    <body>
        <!-- partial:index.partial.html -->

        <jsp:include page="layout/manage_aside.jsp" /> 

        <section id="wrapper">

            <jsp:include page="layout/manage_header.jsp" /> 

            <div style="padding: 50px 10px;">

                <div class="manage-posts-listpost">
                    <c:if test="${thread eq 1}">
                        <div class="container">
                            <div class="manage-list-group">

                                <div >
                                    <h2 class="item-name-listh2" style="color: white;">List User </h2>
                                    <div class="list-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <table class="table table-striped" >
                                            <thead>
                                                <tr>
                                                    <th scope="col"  style="width: 5%">#</th>
                                                    <th scope="col"  style="width: 20%">User Id</th>
                                                    <th scope="col"  style="width: 20%">User Account</th>
                                                    <th scope="col"  style="width: 20%">User Role</th>
                                                    <th scope="col"  style="width: 20%">Number Comment</th>
                                                    <th scope="col"  style="width: 20%">Number Post</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                    <th scope="col"  style="width: 5%">Edit</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${listUser}" var="user" varStatus="count">
                                                <tbody>
                                                    <tr>
                                                        <th scope="row">${count.count}</th>
                                                        <td>${user.getUser_id()}</td>                                      
                                                        <td>${user.getUser_account()}</td>
                                                        <td>
                                                            <c:forEach items="${listRole}" var="role">
                                                                <c:if test="${user.getRole_id().equals(role.getRole_id())}">
                                                                    ${role.getRole_name()}
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${numberComment}" var="comment">
                                                                <c:if test="${user.getUser_id() eq comment.getUser_id()}">
                                                                    ${comment.getNumber_count()}
                                                                </c:if> 
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${numberPost}" var="post">
                                                                <c:if test="${user.getUser_id() eq post.getUser_id()}">
                                                                    ${post.getNumber_count()}
                                                                </c:if> 
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <%--<c:forEach items="${numberPost}" var="post">
                                                                <c:if test="${user.getUser_id() eq post.getUser_id()}">
                                                                    <c:if test="${post.getNumber_count() == 0}">--%>
                                                                        <a onclick="delWithUsercId(${user.getUser_id()})"><i class="uil uil-trash-alt"></i></a>
                                                                <%--    </c:if>
                                                                </c:if> 
                                                            </c:forEach> --%>
                                                            
                                                        </td>
                                                        <td><a onclick="editWithUserId(${user.getUser_id()})"><i class="uil uil-file-edit-alt"></i></a></td>

                                                    </tr>

                                                </tbody>
                                            </c:forEach>
                                        </table>



                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '2'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Create User </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManageUsersController" method="get">
                                            <input name="thread" value="6" hidden>
                                            <table class="table " >
                                                <tr>
                                                    <td >Account</td>
                                                    <td><input type="text" name="user_account" value="${user_account}" required minlength="2" maxlength="30"></td>
                                                    <td>${erraccount}</td>
                                                </tr>
                                                <tr>
                                                    <td >Email</td>
                                                    <td><input type="text" name="user_email" value="${user_email}" required minlength="2" maxlength="50"></td>
                                                    <td>${erremail}</td>
                                                </tr>
                                                <tr>
                                                    <td >Password</td>
                                                    <td><input type="password" name="user_password1" required minlength="2" maxlength="30"></td>
                                                    <td>${errpassword}</td>
                                                </tr>
                                                <tr>
                                                    <td >Confirm Password</td>
                                                    <td><input type="password" name="user_password2" required minlength="2" maxlength="30"></td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td >Role</td>
                                                    <td>
                                                        <c:forEach items="${listRole}" var="role">
                                                            <input type="radio" name="role_id" value="${role.getRole_id()}" checked > ${role.getRole_name()}
                                                        </c:forEach>
                                                    </td>
                                                </tr>

                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 100px 20px ">
                                            ${mess}
                                        </form>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '4'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Edit User</h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManageUsersController" method="get">
                                            <input name="thread" value="7" hidden>
                                            <div style="margin: 20px 100px 10px">
                                                <label>User ID</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="iduseredit" readonly value="${iduseredit}">
                                                <br>
                                                <label>User Account</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="user_account" readonly value="${user_account}">
                                            </div>
                                            <br><br><br>
                                            <table class="table " >
                                                <tr>
                                                    <td >Role</td>
                                                    <td>
                                                        <c:forEach items="${listRole}" var="role">
                                                            <input type="radio" name="role_id" value="${role.getRole_id()}" checked> ${role.getRole_name()}
                                                        </c:forEach>
                                                    </td>
                                                </tr>
                                            </table>
                                            <input  name="submit" type="submit" value="Save" style="margin: 20px 100px 20px ">
                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>




                </div>





            </div>
        </section>


        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
        <script  src="./assets/js/manage_aside.js"></script>
        <script  src="./assets/js/manage_users.js"></script>


    </body>
</html>