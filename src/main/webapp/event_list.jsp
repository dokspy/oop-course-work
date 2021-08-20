<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Event list</title>
</head>
<body>
    <h3>Events</h3>

    <jsp:useBean id="events" scope="request" type="java.util.List"/>
    <c:forEach items="${events}" var="event">
        <p>${event}</p>
    </c:forEach>
</body>
</html>
