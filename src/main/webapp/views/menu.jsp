    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>Menu!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>

            <nav>
            <a href="${pageContext.request.contextPath}/taskAPI/show">Show all tasks!</a>
            <a href="${pageContext.request.contextPath}/taskAPI/add">Add task!</a>
            <a href="${pageContext.request.contextPath}/userAPI/update">Change your password!</a>
            <a href="${pageContext.request.contextPath}/userAPI/delete">Remove yourself from the App!</a>
            </nav>

        <jsp:include page="footer.jsp"/>
        </body>

        </html>