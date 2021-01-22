    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>Add task!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>
        <form action="${pageContext.request.contextPath}/taskAPI/add" method="POST">
        <label for="taskText">Text of the task: </label>
        <input type="text" name="taskText" id="taskText" placeholder="Enter here your task..." required>
        <input type="submit" value="Add!">
        </form>
        <jsp:include page="footer.jsp"/>
        </body>

        </html>