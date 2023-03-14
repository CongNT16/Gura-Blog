<%-- 
    Document   : manage_headerv2
    Created on : Oct 23, 2022, 11:21:00 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Header</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-md">
            <div class="container-fluid mx-2">
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggle-navbar" aria-controls="toggle-navbar" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="uil-bars text-white"></i>
                    </button>
                    <a class="navbar-brand" href="ManageHomeController">Dev<span class="main-color">Blog</span></a>
                </div>
                <div class="collapse navbar-collapse" id="toggle-navbar">
                    <ul class="navbar-nav ms-auto">
<!--                        <li class="nav-item ">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Settings
                            </a>
                        </li>-->
                        <li class="nav-item">
                            <a class="nav-link" href="HomeController"><i class="uil uil-estate"></i></i> Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="LogoutController"><i class="uil uil-sign-out-alt"></i> Logout</a>
                        </li>
                        
<!--                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-show="show-side-navigation1" class="uil-bars show-side-btn"></i>
                            </a>
                        </li>-->
                    </ul>
                </div>
            </div>
        </nav>

    </body>
</html>
