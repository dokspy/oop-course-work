<%@ page import="com.example.oopcoursework.Utils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Change gachi event</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
                   url="<%=Utils.dbUrl%>"
                   user="<%=Utils.dbUser%>" password="<%=Utils.dbPass%>"/>
<jsp:useBean id="event_name" scope="request" type="java.lang.String"/>
<sql:query dataSource="${snapshot}" var="event">SELECT * from events WHERE name = '${event_name}'</sql:query>

<form action="change_event" method="post">
    <div style="display: flex; flex-direction: column; width: 300px;">
        <input type="hidden" name="old_name" value="${event_name}">
        <label>Name: <input type="text" name="new_name" value="${event.rows[0].name}"></label>
        <label>Place: <input type="text" name="place" value="${event.rows[0].place}"></label>
        <label>Type: <input type="text" name="type" value="${event.rows[0].type}"></label>
        <input type="submit" value="Commit change" style="align-self: start">
    </div>
</form>
</body>
</html>
