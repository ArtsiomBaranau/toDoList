    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>Registration!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>

        <form action="${pageContext.request.contextPath}/userAPI/register" method="POST">
        <label for="firstName">First name: </label>
        <input type="text" name="firstName" id="firstName" placeholder="Enter here your first name..." required>
        <label for="lastName">Last name: </label>
        <input type="text" name="lastName" id="lastName" placeholder="Enter here your last name..." required>
        <label for="userName">User name: </label>
        <input type="text" name="userName" id="userName" placeholder="Enter here your user name..." required>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" placeholder="Enter here your password..." required>
        <input type="submit" name="register" value="Register!">
        </form>

        <jsp:include page="footer.jsp"/>
        </body>

        </html>