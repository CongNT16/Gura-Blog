
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Users"%>
<%@page import="Models.Posts"%>
<%@page import="DataAccess.PostDAO"%>
<%@page import="DataAccess.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DevBlog - Laputa's Personal Blog</title>

        <!--
          - favicon
        -->
        <link rel="shortcut icon" href="./assets/images/favicon.ico" type="image/x-icon">

        <!--
          - custom css link
        -->
        <link rel="stylesheet" href="./assets/css/layout.css">
        <link rel="stylesheet" href="./assets/css/post.css">

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
        <!--<div class="underline-page"> <p style="border-top: 1px solid var(--action-primary);"></p>-->
    </div>


    <main style="background-color: var(--background-secondary)">
        <p style="padding-bottom: 100px "></p>
        <c:if test="${post_id != null}">
            <div class="container">
                <div class="category-name">
                    <a href="CategoryController?categoryid=${category_id}" ><h4>${category}</h4></a>
                    <h4><i class='bx bx-chevron-right'></i></h4>
                    <a href="TopicController?gettopicid=${topic_id}"><h4>${topic}</h4></a>
                    <h4><i class='bx bx-chevron-right'></i></h4>
                    <h4>${post_title}</h4>

                </div>
                <div class="listtag">

                    <!--<h4 >Tag</h4>&emsp;-->
                    <c:forEach items="${listPostTag}" var="tag">
                        <c:if test="${post_id.equals(tag.getPost_id())}">
                            <a href="TagController?gettagid=${tag.getTag_id()}"><span>#${tag.getTag_name()}&nbsp;</span></a>
                        </c:if>
                    </c:forEach>
                </div>

                <h4>Số lượt xem ${post_view}</h4>

            </div>

            <div class="container" style="padding-bottom: 100px">

                <div class="post-detail">
                    <div class="title-post">
                        <h1 >${post_title}</h1>
                    </div>
                    <div class="wrapper-flex" >

                        <div class="profile-wrapper">

                            <img src="./assets/images/${avatar_author}" alt="${name_author}" width="50">
                        </div>

                        <div class="wrapper">
                            <a href="ProfileUserController?thread=1&userid=${post_author_id}" class="h4">${name_author}</a>

                            <p class="text-sm">
                                <time datetime="${post_create_date}">${post_create_date}</time>
                                <span class="separator"></span>
                            <ion-icon name="time-outline"></ion-icon>
                            <!--<time datetime="PT3M">3 min</time>-->
                            </p>
                        </div>
                    </div>
                    <div class="content-post">
                        <div class="img1-post">
                            <img src="./assets/images/${imagename}" alt="title"class="image-post">
                        </div>
                        <div class="text-post">
                            <p>
                                ${post_body}
                            </p>
                        </div>
                        <!--                        <div class="timecreate-post">
                                                    <time datetime="2019-10-12">2019-10-12</time>
                                                </div>-->

                    </div>

                </div>
            </div>
        </c:if>

        <c:forEach items="${numberComment}" var="comment">
            <c:if test="${post_id.equals(comment.getPost_id())}">
                <c:if test="${comment.getNumber_comment() > 0}">

                    <div class="container">

                        <div class="title-listcomment">
                            <h2>Comment</h2>

                        </div>

                        <div style="padding-bottom: 100px;">
                            <div class="bar-comment">

                                <div class="list-comment">
                                    <c:forEach items="${listComment}" var="comment">
                                        <c:if test="${post_id eq comment.getPost_id()}">
                                            <c:if test="${comment.getComment_status() eq 1}">
                                                <div class="comment-box">

                                                    <div class="wrapper-comment">

                                                        <div class="profile-wrapper">
                                                            <c:forEach items="${listUser}" var="user">
                                                                <c:if test="${comment.getUser_id() eq user.getUser_id()}">
                                                                    <img src="./assets/images/${user.getUser_avatar()}" alt="" width="50">
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>

                                                        <div class="wrapper">
                                                            <c:forEach items="${listUser}" var="user">
                                                                <c:if test="${comment.getUser_id() eq user.getUser_id()}">
                                                                    <a href="ProfileUserController?thread=1&userid=${user.getUser_id()}" class="h4">${user.getUser_account()}</a>
                                                                </c:if>
                                                            </c:forEach>


                                                            <p class="text-sm">
                                                                <time datetime="dateup">${comment.getComment_create_date()}</time>
                                                                <span class="separator"></span>
                                                                <time time="timeup">${comment.getComment_create_time()}</time>
                                                            <ion-icon name="time-outline"></ion-icon>
                                                            <!--<time datetime="PT3M">3 min</time>-->
                                                            </p>
                                                        </div>

                                                        <c:if test="${comment.getUser_id() eq user_login_id}"> 
                                                            <div style="right: 0px">
                                                                <button onclick="delWithCommentPostId(${comment.getComment_id()}, ${comment.getPost_id()})"><ion-icon name="close-outline"></ion-icon></button>
                                                            </div>
                                                            <div style="right: 0px">
                                                                <button onclick="editWithCommentPostId(${comment.getComment_id()}, ${comment.getPost_id()})"><ion-icon name="create-outline"></ion-icon></button>
                                                            </div>
                                                        </c:if>  

                                                    </div>
                                                    <div class="user-commnet-text">
                                                        <p>
                                                            ${comment.getComment_detail()}
                                                        </p>
                                                    </div>

                                                </div>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>


                                </div>
                            </div>
                        </div>




                    </div>
                </c:if>
            </c:if> 
        </c:forEach>




        <c:if test="${user_login_id != null}">

            <div class="container">
                <div class="container-comment-par">
                    <div class="container-comment">
                        <h2 >Add Comment</h2>
                        <form action="PostController" method="post">
                            <input type="text" name="postid" value="${post_id}" hidden>
                            <input type="text" name="userid" value="${user_login_id}" hidden>
                            <textarea placeholder='Add Your Comment' class="comment-text" name="commentdetail" required minlength="2" maxlength="500"></textarea>
                            <div class="comment-button btn">
                                <input type="submit" value='Send'class="send-comment">
                                <!--<button id='clear' class="out-comment">Cancel</button>-->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>




        <!--<div class="underline-page"> <p style="border-top: 1px solid var(--action-primary);"></p></div>-->

    </main>






    <jsp:include page="layout/footer.jsp" />  





    <!--
      - custom js link
    -->
    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
    <script src="./assets/js/comment_post.js"></script>


    <!--
      - ionicon link
    -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


</body>

</html>
