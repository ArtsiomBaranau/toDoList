    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>New password!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>

        <form action="${pageContext.request.contextPath}/userAPI/update" method="POST">
        <label for="password">New password: </label>
        <input type="password" name="newPassword" id="newPassword" placeholder="Enter here your new password..." required>
        <input type="submit" value="Change!">
        </form>
        <jsp:include page="footer.jsp"/>
        </body>

        </html>
        <%-- Comments--%>