<%-- 
    Document   : manage home
    Created on : Oct 21, 2022, 8:52:09 PM
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



            <div class="p-4">

                <div class="welcome">
                    <div class="content rounded-3 p-3">
                        <h1 class="fs-3">Welcome to Dashboard</h1>
                        <p class="mb-0">Hello ${user_login_account}, welcome to your awesome dashboard!</p>
                    </div>
                </div>

                <c:if test="${user_login_roleid eq 1 || user_login_roleid eq 2}">   
                    <div> 
                        <div style="margin-top: 50px">
                            <h2 style="color: white">Statistical tables</h2>
                            <div style="color: white;margin: auto; background:  white; margin-top: 50px; overflow-y: auto">

                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="row">Name</th>
                                            <th>Total</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${user_login_roleid eq 1 }">    
                                            <tr>
                                                <th scope="row">Total number of users</th>
                                                <td>${total_user}</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">Total number of admin</th>
                                                <td>${total_admin}</td>

                                            </tr>
                                            <tr>
                                                <th scope="row">Total number of poster</th>
                                                <td>${total_poster}</td>

                                            </tr>
                                        </c:if> 
                                        <tr>
                                            <th scope="row">Total Posts</th>
                                            <td>${total_post}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Total Categories</th>
                                            <td>${total_category}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Total Topics</th>
                                            <td>${total_topic}</td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Total Tags</th>
                                            <td>${total_tag}
                                        </tr>
                                        <c:if test="${user_login_roleid eq 1 }">     
                                            <tr>
                                                <th scope="row">Total Comments</th>
                                                <td>${total_comment}</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">Total Messages</th>
                                                <td>${total_message}</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">Total Subscribe</th>
                                                <td>${total_subscribe}</td>
                                            </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>                   
                <c:if test="${user_login_roleid eq 1 }">               
                    <div>
                        <div style="margin-top: 50px; margin-bottom: 100px">
                            <div>
                                <h2 style="color: white">Notification</h2>
                                <div style="display: flex;margin: 20px 0 0 100px;">
                                    <c:if test="${notifi != null}">
                                        <h5 style="color: white; ">${notifi}</h5>&emsp;&emsp;&emsp; 
                                        <form action="ManageHomeController" method="post">
                                            <button type="submit" name="click" value="del">Delete</button>
                                        </form>
                                    </c:if>
                                </div>

                                <div style="color: white;margin: auto; background:  white; margin-top: 50px; overflow-y: auto">

                                    <form action="ManageHomeController" method="post">
                                        <table class="table">

                                            <tbody>
                                                <tr>
                                                    <td>Edit Notification</td>
                                                    <td><input type="text" name="editNotifi" required maxlength="100" size="50"></td>

                                                    <td><button type="submit" name="click" value="edit">Save</button></td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
        </section>


        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
        <script  src="./assets/js/manage_aside.js"></script>


    </body>
</html>