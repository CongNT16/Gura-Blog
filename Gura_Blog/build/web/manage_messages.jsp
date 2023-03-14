<%-- 
    Document   : manage_comments_listcomment
    Created on : Oct 22, 2022, 11:16:32 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Manage Message</title>
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

                    <c:if test="${thread == '1'}">
                        <div class="container">
                            <div class="manage-list-group">

                                <div >
                                    <h2 class="item-name-listh2" style="color: white;">List Message </h2>
                                    <div class="list-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <table class="table table-striped" >
                                            <thead>
                                                <tr>
                                                    <th scope="col"  style="width: 5%">#</th>
                                                    <th scope="col"  style="width: 15%">ID</th>
                                                    <th scope="col"  style="width: 15%">Name</th>
                                                    <th scope="col"  style="width: 15%">Email</th>
                                                    <th scope="col"  style="width: 15%">Create</th>                                            
                                                    <th scope="col"  style="width: 40%">Detail</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                </tr>
                                            </thead>

                                            <tbody>

                                                <c:forEach items="${listMessage}" var="message" varStatus="count">
                                                    <tr>

                                                        <th scope="row" >${count.count}</th>
                                                        <td>${message.getMessage_id()}</td>    
                                                        <td>${message.getUser_send_name()}</td>                                                                      
                                                        <td>${message.getUser_send_email()}</td>
                                                        <td>
                                                            <ul style="list-style: none; ">
                                                                <li>${message.getMessage_create_date()}</li>
                                                                <li>${message.getMessage_create_time()}</li>
                                                            </ul>
                                                        </td>
                                                        <td>${message.getMessage_detail()}</td>
                                                        <td><a onclick="delWithMessageId(${message.getMessage_id()})"><i class="uil uil-trash-alt"></i></a></td>
                                                    </tr>

                                                </c:forEach>



                                            </tbody>

                                        </table>



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
        <script  src="./assets/js/manage_messages.js"></script>


    </body>
</html>