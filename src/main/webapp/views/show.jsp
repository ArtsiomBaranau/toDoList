    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        <title>Your tasks!</title>
        </head>

        <body>
        <jsp:include page="header.jsp"/>

        <form action="${pageContext.request.contextPath}/taskAPI/delete" method="POST">
        <c:forEach var="task" items="${taskList}">
            <input type="checkbox" name="taskID" value="${task.ID}"><c:out value="${task.task}"/><br>
        </c:forEach>
        <input type="submit" value="Go back to the menu!">
        </form>

        <jsp:include page="footer.jsp"/>
        </body>

        </html>
        <%-- Comments--%>
