<%-- 
    Document   : manage_categories_listcategory
    Created on : Oct 22, 2022, 11:19:52 PM
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
                                    <h2 class="item-name-listh2" style="color: white;">List Category </h2>
                                    <div class="list-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <table class="table table-striped" >
                                            <thead>
                                                <tr>
                                                    <th scope="col"  style="width: 5%">#</th>
                                                    <th scope="col"  style="width: 30%">Category Id</th>                                       
                                                    <th scope="col"  style="width: 30%">Category Name</th>
                                                    <th scope="col"  style="width: 20%">Number Topic</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                    <th scope="col"  style="width: 5%">Edit</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${listCategory}" var="category" varStatus="count">
                                                <tbody>
                                                    <tr>
                                                        <th scope="row">${count.count}</th>
                                                        <td>${category.getCategory_id()}</td>                                      
                                                        <td>${category.getCategory_name()}</td>
                                                        <td>
                                                            <c:forEach items="${numberTopic}" var="number">
                                                                <c:if test="${category.getCategory_id() eq number.getCategory_id()}">
                                                                    ${number.getNumber_topic()}
                                                                </c:if> 
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${numberTopic}" var="number">
                                                                <c:if test="${category.getCategory_id() eq number.getCategory_id()}">
                                                                    <c:if test="${number.getNumber_topic() == 0}"> 
                                                                        <a onclick="delWithCategoryId(${category.getCategory_id()})"><i class="uil uil-trash-alt"></i></a>
                                                                       </c:if>
                                                                    </c:if> 
                                                                </c:forEach> 

                                                        </td>
                                                        <td><a onclick="editWithCategoryId(${category.getCategory_id()})"><i class="uil uil-file-edit-alt"></i></a></td>

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
                                    <h2 class="item-name-createh2" style="color: white;">Create Category </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManageCategoriesController" method="get">
                                            <input name="thread" value="6" hidden>
                                            <table class="table " >
                                                <tr>
                                                    <td style="width: 20%">Category Name</td>
                                                    <td style="width: 50%"><input type="text" name="category_name" required minlength="2" maxlength="50" size="50" value="${category_name}"></td>
                                                    <td style="color: red; width: 30%">${errname}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 300px 20px ">
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
                                    <h2 class="item-name-createh2" style="color: white;">Edit Category</h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManageCategoriesController" method="get">
                                            <input name="thread" value="7" hidden>
                                            <div style="margin: 20px 100px 10px">
                                                <label>Category ID</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="idcategoryedit" readonly value="${idcategoryedit}">
                                            </div>
                                            <br><br><br>
                                            <table class="table " >
                                                <tr>
                                                    <td style="width: 20%">Category Name</td>
                                                    <td style="width: 50%"><input type="text" name="category_name" required minlength="2" maxlength="50" size="50" value="${category_name}"></td>
                                                    <td style="color: red; width: 30%">${errname}</td>
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
        <script  src="./assets/js/manage_categories.js"></script>


    </body>
</html>