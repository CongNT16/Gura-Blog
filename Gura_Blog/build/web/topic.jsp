<%-- 
    Document   : topic
    Created on : Oct 31, 2022, 12:03:49 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>

        <!--
          - favicon
        -->
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">

        <!--
          - custom css link
        -->
        <link rel="stylesheet" href="./assets/css/layout.css">
        <link rel="stylesheet" href="./assets/css/home.css">

        <!--
          - google font link
        -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
    </head>

    <body class="light-theme">

        <!--
          - #HEADER
        -->


        <jsp:include page="layout/header.jsp" /> 

        <main>

            <div class="main">

                <div class="container" style="display: block">


                    <!--- BLOG SECTION-->

                    <div class="blog">

                        <h2 class="h2">${topicName}</h2>

                        <div class="blog-card-group">


                            <c:forEach items="${listPost}" var="post" >
                                <c:if test="${post.getTopic_id() eq topicID}">
                                    <div class="blog-card">
                                        <input type="text" hidden name="postid" value="${post.getPost_id()}">



                                        <div class="blog-card-banner">


                                            <img src="./assets/images/${post.getImg_filename()}" alt="${post.getPost_title()}" width="250" class="blog-banner-img">


                                        </div>

                                        <div class="blog-content-wrapper">

                                            <c:forEach items="${listtopic}" var="topic">
                                                <c:if test="${post.getPost_id().equals(topic.getPost_id())}">
                                                    <a href="TopicController?gettopicid=${topic.getTopic_id()}"><button class="blog-topic text-tiny">${topic.getTopic_name()}</button></a>            
                                                    </c:if>
                                                </c:forEach>



                                            <h3>
                                                <a href="PostController?postid=${post.getPost_id()}" ass="h3">
                                                    ${post.getPost_title()}
                                                </a>
                                            </h3>

                                            <p class="blog-text">
                                                ${post.getPost_body()}
                                            </p>

                                            <div class="wrapper-flex">

                                                <div class="profile-wrapper">
                                                    <c:forEach items="${listuser}" var="user">
                                                        <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                            <img src="./assets/images/${user.getUser_avatar()}" alt="${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}" width="50">                                                               
                                                        </c:if>
                                                    </c:forEach>


                                                </div>

                                                <div class="wrapper">
                                                    <c:forEach items="${listuser}" var="user">
                                                        <c:if test="${post.getPost_author_id().equals(user.getUser_id())}">
                                                            <a href="ProfileUserController?thread=1&userid=${user.getUser_id()}" class="h4">${user.getUser_firstname()}&nbsp;${user.getUser_lastname()}</a>

                                                        </c:if>
                                                    </c:forEach>


                                                    <p class="text-sm">
                                                        <time datetime="${post.getPost_create_date()}">${post.getPost_create_date()}</time>
                                                        <span class="separator"></span>
                                                    <ion-icon name="time-outline"></ion-icon>
                                                    <!--<time datetime="PT3M">3 min</time>-->
                                                    </p>
                                                </div>

                                            </div>

                                        </div>

                                    </div>
                                </c:if>                   
                            </c:forEach>




                        </div>

                        <!--<button class="btn load-more">Load More</button>-->





                    </div>

                </div>

            </div>

        </main>



        <!--
          - #FOOTER
        -->

        <jsp:include page="layout/footer.jsp" />  

        <!--
          - custom js link
        -->
        <script src="./assets/js/datetime.js"></script>   
        <script src="./assets/js/layout.js"></script>

        <!--
          - ionicon link
        -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


    </body>

</html>

