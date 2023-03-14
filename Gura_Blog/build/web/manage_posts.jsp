<%-- 
    Document   : manage_listpost
    Created on : Oct 22, 2022, 9:26:19 PM
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
                    <c:if test="${thread == '1'}">
                        <div class="container">
                            <div class="manage-list-group">

                                <div >
                                    <h2 class="item-name-listh2" style="color: white;">List Post </h2>
                                    <div class="list-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <table class="table table-striped" >
                                            <thead>
                                                <tr>
                                                    <th scope="col"  style="width: 5%">#</th>
                                                    <th scope="col"  style="width: 5%">ID</th>    
                                                    <th scope="col"  style="width: 15%">Title</th>                                       
                                                    <th scope="col"  style="width: 5%">Category</th>
                                                    <th scope="col"  style="width: 5%">Topic</th>
                                                    <th scope="col"  style="width: 5%">Tag</th>
                                                    <th scope="col"  style="width: 5%">Author</th>
                                                    <th scope="col"  style="width: 5%">Create</th>                                            
                                                    <th scope="col"  style="width: 40%">Detail</th>                                                  
                                                    <th scope="col"  style="width: 5%">Image</th>
                                                    <th scope="col"  style="width: 5%">NofCom</th>
                                                    <th scope="col"  style="width: 5%">Nofview</th>
                                                    <th scope="col"  style="width: 5%">Del</th>
                                                    <th scope="col"  style="width: 5%">Edit</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <%--<c:forEach begin="1" end="${toltalpost}" var="i">--%>
                                                <%--<c:set var="i" value="1">--%>
                                                <c:forEach items="${listPagePost}" var="post" varStatus="count">
                                                    <tr>

                                                        <th scope="row" >${count.count}</th>
                                                            <%--<c:set value="i+1"></c:set>--%>
                                                        <td>${post.getPost_id()}</td>    
                                                        <td>${post.getPost_title()}</td>                                                                      
                                                        <td>${post.getTopic_name()}</td>
                                                        <td>${post.getCategory_name()}</td>
                                                        <td >
                                                            <ul style="list-style: none; ">

                                                                <c:forEach items="${listPostTag}" var="tag">
                                                                    <c:if test="${post.getPost_id().equals(tag.getPost_id())}">
                                                                        <li>${tag.getTag_name()}</li>
                                                                        </c:if>
                                                                    </c:forEach>


                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${listuser}" var="user">
                                                                <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                                    ${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}
                                                                </c:if>
                                                            </c:forEach>

                                                        </td>
                                                        <td>
                                                            <ul style="list-style: none; ">
                                                                <li>${post.getPost_create_date()}</li>
                                                                <li>${post.getPost_create_time()}</li>

                                                            </ul>
                                                        </td>

                                                        <td style="font-size: 9pt">${post.getPost_body()}</td>

                                                        <td>
                                                            <ul style="list-style: none; ">

                                                                <li><img src="./assets/images/${post.getImg_filename()}" alt="alt" width="100px" height="100px"/></li>

                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <c:forEach items="${numberComment}" var="comment">
                                                                <c:if test="${post.getPost_id() eq comment.getPost_id()}">
                                                                    ${comment.getNumber_comment()}
                                                                </c:if> 
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            
                                                            ${post.getNumber_view()}
                                                               
                                                        </td>
                                                        <td>
                                                            <c:if test="${user_login_id eq post.getPost_author_id() || user_login_roleid eq 1}">
                                                            <a  onclick="delWithPostId(${post.getPost_id()})"><i class="uil uil-trash-alt"></i></a>
                                                            </c:if>
                                                        </td>
                                                        <td><a onclick="editWithPostId(${post.getPost_id()})"><i class="uil uil-file-edit-alt"></i></a></td>
                                                    </tr>

                                                </c:forEach>
                                                <%--</c:set>--%>
                                                <%--</c:forEach>--%>


                                            </tbody>

                                        </table>

                                        <div class="tagpage" style="text-align: center; padding-bottom: 20px; font-size: 20pt">
                                            <c:forEach begin = "1" end="${endPage}" var="i">
                                                <a href="ManagePostsController?thread=1&index=${i}" style="margin: 2px;text-decoration: none" class="${tagPage == i?"active":""}">${i}</a>
                                            </c:forEach>
                                        </div>



                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '2'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Create Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form id="createpost" action="ManagePostsController" method="get">
                                            <input name="thread" value="6" hidden>
                                            <input name="post_author_id" value="${sessionScope.user_login_id}" hidden>
                                            <input name="getcategoryid" value="${getcategoryid}" hidden>


                                            <table class="table " >

                                                <tr>
                                                    <td>Post Topic</td>
                                                    <td>
                                                        <c:forEach items="${listtopic}" var="topic">
                                                            <input type="radio" name="post_topic" value="${topic.getTopic_id()}" checked> ${topic.getTopic_name()}
                                                        </c:forEach>
                                                    </td>
                                                </tr>  
                                                <tr>
                                                    <td >Post Title</td>
                                                    <td><input type="text" name="post_title" value="${post_title}" required minlength="2" maxlength="100" size="50"></td>
                                                    <td>${errtitle}</td>
                                                </tr>

                                                <tr>

                                                    <td>Post Tag</td>
                                                    <td>
                                                        <c:forEach items="${listtag}" var="tag">
                                                            <input type="checkbox" name="post_tag" value="${tag.getTag_id()}"> ${tag.getTag_name()}
                                                        </c:forEach>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Post Detail</td>
                                                    <td>
                                                        <input type="text" name="post_detail" value="${post_detail}" required minlength="200" maxlength="4000" size="50" style="height: 50px" >

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Post Image</td>
                                                    <td><input type="text" name="post_image" value="${post_image}" required minlength="2" maxlength="100"></td>
                                                </tr>
                                            </table>
                                            <input  name="submit" type="submit" value="Create" style="margin: 20px 100px 20px ">
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
                                    <h2 class="item-name-createh2" style="color: white;">Edit Post </h2>
                                    <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                        <form action="ManagePostsController" method="get">
                                            <input name="thread" value="7" hidden>
                                            <!--<input type="text" name="idpostedit" value="${idpostedit}" readonly>-->
                                            <input type="text" name="post_author_id" value="${user_login_id}" readonly hidden>


                                            <div style="margin: 20px 100px 10px">
                                                <label>Post ID</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="idpostedit" readonly value="${idpostedit}">
                                                <br><label>Post Topic</label>
                                                &emsp;&emsp;&emsp;<input type="text" name="postedittopic" readonly value="${post_topicname}">
                                                <br><label>Post Tag</label>
                                                &emsp;&emsp;&emsp;
                                                <c:forEach items="${posttag}" var="tag">
                                                    <c:if test="${tag.getPost_id() == idpostedit}">
                                                        ${tag.getTag_name()}&emsp;
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <br><br>



                                            <table class="table " >


                                                <c:forEach items="${listCategory}" var="category">
                                                    <c:forEach items="${numberTopic}" var="number">
                                                        <c:if test="${category.getCategory_id() eq number.getCategory_id()}">
                                                            <c:if test="${number.getNumber_topic() != 0}">
                                                                <tr>
                                                                    <td>
                                                                        ${category.getCategory_name()}
                                                                    </td>

                                                                    <td>
                                                                        <c:forEach items="${listtopic}" var="topic">
                                                                            <c:if test="${topic.getCategory_id() eq category.getCategory_id()}">
                                                                                <input type="radio" name="post_topic" value="${topic.getTopic_id()}" checked> ${topic.getTopic_name()}
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </td>
                                                                </tr> 
                                                            </c:if>
                                                        </c:if> 
                                                    </c:forEach>
                                                </c:forEach>

                                                <tr>
                                                    <td style="width: 10%">Post Title</td>
                                                    <td><input type="text" name="post_title" value="${post_title}" size="50" required min="2" maxlength="100"></td>
                                                    <td>${errtitle}</td>
                                                </tr>

                                                <tr>

                                                    <td>Post Tag</td>
                                                    <td>
                                                        <c:forEach items="${listtag}" var="tags">
                                                            <input type="checkbox" name="post_tag" value="${tags.getTag_id()}"> ${tags.getTag_name()}
                                                        </c:forEach>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Post Detail</td>
                                                    <td><input name="post_detail" value="${post_detail}" size="50" style="height: 50px" required min="100" maxlength="4000">
                                                </tr>
                                                <tr>
                                                    <td>Post Image</td>
                                                    <td><input type="text" name="post_image" value="${post_image}" required minlength="2" maxlength="100"></td>


                                            </table>
                                            <input  name="submit" type="submit" value="Save" style="margin: 20px 100px 20px ">
                                        </form>




                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </c:if>


                    <c:if test="${thread == '5'}">
                        <div class="container">
                            <div class="manage-create-group">

                                <div >
                                    <h2 class="item-name-createh2" style="color: white;">Create Post </h2>

                                    <c:if test="${posterfistname == null || posterlastname == null}">
                                        <h4 style="color: white; margin-top: 100px">You have to create enough firstname and lastname and come back here.</h4>
                                        <br><a href="ProfileUserController?thread=1&userid=${user_login_id}"><button style="width: 50px">Go</button></a>

                                    </c:if>
                                    <c:if test="${posterfistname != null && posterlastname != null}">

                                        <div class="create-card-group" style="margin: auto; background:  white; margin-top: 50px; overflow-y: auto;">

                                            <form action="ManagePostsController" method="get">
                                                <input name="thread" value="2" hidden>


                                                <table class="table " >


                                                    <tr>
                                                        <td>Post Category</td>
                                                        <td>
                                                            <select name="getcategoryid"">
                                                                <option hidden>Chọn Category</option>
                                                                <c:forEach items="${listcategory}" var="category">
                                                                    <c:forEach items="${numberTopic}" var="number">
                                                                        <c:if test="${category.getCategory_id() eq number.getCategory_id()}">
                                                                            <c:if test="${number.getNumber_topic() != 0}">
                                                                                <option value="${category.getCategory_id()}">${category.getCategory_name()}</option>
                                                                            </c:if>
                                                                        </c:if> 
                                                                    </c:forEach>
                                                                </c:forEach>
                                                            </select> 
                                                        </td>
                                                    </tr> 
                                                </table>
                                                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                                <button type="submit">Get Category</button>

                                            </form>

                                        </div>
                                    </c:if>

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
        <script  src="./assets/js/manage_posts.js"></script>



    </body>
</html>
