<%-- 
    Document   : manage_subscribe
    Created on : Oct 31, 2022, 11:00:06 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Manage Subscribe</title>
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
                                                    <th scope="col"  style="width: 40%">Id</th>
                                                    <th scope="col"  style="width: 40%">Email</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                </tr>
                                            </thead>

                                            <tbody>

                                                <c:forEach items="${listSubscribe}" var="subscribe" varStatus="count">
                                                    <tr>

                                                        <th scope="row" >${count.count}</th>
                                                        <td>${subscribe.getId()}</td>
                                                        <td>${subscribe.getEmail()}</td>
                                                        <td><a onclick="delWithSubscribeId(${subscribe.getId()});"><i class="uil uil-trash-alt"></i></a></td>
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
        <!--<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>-->
        <script  src="./assets/js/manage_aside.js"></script>
        <script  src="./assets/js/manage_subscribes.js"></script>


    </body>
</html>
