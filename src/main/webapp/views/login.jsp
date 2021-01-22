    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>Login!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>
        <form action="${pageContext.request.contextPath}/userAPI/login" method="POST">
        <label for="userName">User name: </label>
        <input type="text" name="userName" id="userName" placeholder="Enter here your user name..." value="${userName}" required>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" placeholder="Enter here your password..." value="${password}" required>
        <input type="submit" name="login" value="Log In!">
        </form>
        <jsp:include page="footer.jsp"/>
        </body>

        </html>
        <%-- Comments--%>