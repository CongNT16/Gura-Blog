<%-- 
    Document   : manage_lefrbarv2
    Created on : Oct 23, 2022, 11:20:49 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Aside</title>
    </head>
    <body>

        <aside class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left" id="show-side-navigation1">
            <i class="uil-bars close-aside d-md-none d-lg-none" data-close="show-side-navigation1"></i>
            <div class="sidebar-header d-flex justify-content-center align-items-center px-3 py-4">
                <img
                    class="rounded-pill img-fluid"
                    width="65"
                    src="./assets/images/${user_login_avatar}"
                    alt="">
                <div class="ms-2">
                    <h5 class="fs-6 mb-0">
                        <a class="text-decoration-none" href="#">${user_login_account}</a>
                    </h5>
                    <p class="mt-1 mb-0">Trình quản lý tác vụ</p>
                </div>
            </div>
            <ul class="categories list-unstyled">
                
                <c:if test="${user_login_roleid eq 1 || user_login_roleid eq 2}">
                <li class="manage-asidetohome">
                    <i class="uil uil-tachometer-fast-alt"></i><a href="ManageHomeController"> Dashboard</a>

                </li>
                <li class="has-dropdown">
                    <i class="uil uil-file-alt"></i><a href="#"> Posts</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=1">List post</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=5">Create a new post</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=3">Delete a post</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManagePostsController?thread=4">Edit a post</a>
                        </li>-->
                    </ul>
                </li>
                </c:if>
                <c:if test="${user_login_roleid eq 1 }">
                <li class="has-dropdown">
                    <i class="uil uil-user"></i><a href="#"> Users</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=1">List user</a>
                        </li>
                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=2">Create a new user</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=3">Delete a user</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageUsersController?thread=4">Edit a user</a>-->
                        </li>
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-comment-alt-lines"></i><a href="#"> Comments</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCommentsController?thread=1">List comment</a>
                        </li>
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-books"></i><a href="#"> Categories</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=1">List category</a>
                        </li>
                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=2">Create a new category</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=3">Delete a category</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageCategoriesController?thread=4">Edit a category</a>
                        </li>-->
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-swatchbook"></i><a href="#"> Topics</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=1">List topic</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=2">Create a new topic</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=3">Delete a topic</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTopicsController?thread=4">Edit a topic</a>
                        </li>-->
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-tag"></i><a href="#"> Tags</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="users_seller">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=1">List tag</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=2">Create a new tag</a>
                        </li>

<!--                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=3">Delete a tag</a>
                        </li>

                        <li id="users_customer">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageTagsController?thread=4">Edit a tag</a>
                        </li>-->
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-envelope-edit"></i><a href="#"> Messages</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="ManageMessagesController?thread=1">List message</a>
                        </li>
                    </ul>
                </li>
                
                <li class="has-dropdown">
                    <i class="uil uil-comment-verify"></i><a href="#"> Subscribes</a>
                    <ul class="sidebar-dropdown list-unstyled">
                        <li id="products_product">
                            <a class="waves-effect" style="text-decoration: none;" href="SubscribesController?thread=1">List subscribe</a>
                        </li>
                    </ul>
                </li>
                </c:if>
                
                
                
            </ul>
        </aside>

    </body>
</html>
