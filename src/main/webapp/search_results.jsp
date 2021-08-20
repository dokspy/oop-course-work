<%@ page import="com.example.oopcoursework.Utils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search results</title>
</head>
<body>
Search results:


<br>

<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
                   url="<%=Utils.dbUrl%>"
                   user="<%=Utils.dbUser%>" password="<%=Utils.dbPass%>"/>
<sql:query dataSource="${snapshot}"
           var="results">SELECT * FROM events WHERE LOWER(name) LIKE '%<%=request.getParameter("name").toLowerCase()%>%';</sql:query>


<c:forEach var="event" items="${results.rows}">
    <p>${event.name} | ${event.place} | ${event.type}</p>
</c:forEach>

</body>
</html>
