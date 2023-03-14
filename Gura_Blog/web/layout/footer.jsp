<%-- 
    Document   : header
    Created on : Oct 17, 2022, 8:45:58 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <!--<link rel="stylesheet" href="../assets/css/footer.css">-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
    </head>
    <body class="light-theme">

        <!--
          - #FOOTER
        -->

        <footer>

            <div class="container">

                <div class="wrapper">

                    <a href="HomeController" class="footer-logo">
                        <img src="./assets/images/logo-light.svg" alt="DevBlog's Logo" width="150" class="logo-light">
                        <img src="./assets/images/logo-dark.svg" alt="DevBlog's Logo" width="150" class="logo-dark">
                    </a>

                    <p class="footer-text">
                        This blog is where I share my knowledge and life experiences.
                    </p>

                </div>

                <div class="wrapper">

                    <p class="footer-title">Quick Links</p>

                    <ul>

                        <li>
                            <a href="HomeController" class="footer-link">Home</a>
                        </li>

                        <li>
                            <a href="AboutmeController" class="footer-link">About Me</a>
                        </li>

                        <li>
                            <a href="ContactController" class="footer-link">Contact</a>
                        </li>

                    </ul>

                </div>

                <div class="wrapper">

                    <p class="footer-title">Media Social</p>

                    <ul>

                        <li>
                            <a href="https://www.facebook.com/nguyencong.1606" class="footer-link">Facebook</a>
                        </li>

                        <li>
                            <a href="https://www.linkedin.com/in/nguyencong1606/" class="footer-link">Linkedin</a>
                        </li>

                        <li>
                            <a href="https://twitter.com/Laputa_1606" class="footer-link">Twitter</a>
                        </li>

                    </ul>

                </div>

            </div>

            <p class="copyright">
                &copy; Copyright 2022 <a href="https://www.facebook.com/nguyencong.1606">Nguyễn Thành Công</a>
            </p>

        </footer>







    </body>
    <!--<script src="../assets/js/datetime.js"></script>-->
    <!--<script src="../assets/js/script.js"></script>-->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</html>
