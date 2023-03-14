<%-- 
    Document   : Question
    Created on : Nov 10, 2022, 3:01:27 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div>
                <form action="QuestionController" method="post">
                    <table>
                        <c:forEach items="${listPageQuestion}" var="question">
                            <tr>
                                <td>Question ${question.getID()}</td>
                                <td>${question.getQuestion()}</td>
                            </tr>
                            <tr>
                                <td>A</td>
                                <td><input name="answ1" type="radio" value="${question.getAnsw1()}"> ${question.getAnsw1()}</td>
                            </tr>
                            <tr>
                                <td>B</td>
                                <td><input name="answ1" type="radio" value="${question.getAnsw2()}"> ${question.getAnsw2()}</td>
                            </tr>
                            <tr>
                                <td>C</td>
                                <td><input name="answ1" type="radio" value="${question.getAnsw3()}"> ${question.getAnsw3()}</td>
                            </tr>   
                            <tr>
                                <td>D</td>
                                <td><input name="answ1" type="radio" value="${question.getAnsw4()}"> ${question.getAnsw4()}</td>
                            </tr>
                            <br><!-- comment -->
                        </c:forEach>
                    </table>
                    <!--<input type="submit" value="Next">-->
                    <div class="pagechange">
                        <c:if test="${tagPage>1}">
                            <a href="QuestionController?index=${tagPage-1}">Truoc</a>
                        </c:if>
                        <c:forEach begin = "1" end="${endPage}" var="i">
                            <a href="QuestionController?index=${i}">${i}</a>
                        </c:forEach>
                        <c:if test="${tagPage < endPage}">
                            <a href="QuestionController?index=${tagPage+1}">Sau</a>
                        </c:if>
                        <c:if test="${tagPage == endPage}">
                            <br><input type="submit" value="Submit">
                        </c:if>
                    </div>
                </form>
            </div>

        </div>
    </body>
</html>
