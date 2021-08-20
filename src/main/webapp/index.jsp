<%@ page import="com.example.oopcoursework.Utils" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fucking JSP</title>
</head>
<body>

<a href="event_list">View event list</a>

<form action="add_event.jsp">
    <input type="submit" value="Add Event">
</form>

<br>

<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
                   url="<%=Utils.dbUrl%>"
                   user="<%=Utils.dbUser%>" password="<%=Utils.dbPass%>"/>
<sql:query dataSource="${snapshot}" var="events">SELECT * from events;</sql:query>

<form style="display: flex; flex-direction: row">
    <label>
        Event:
        <select name="name">
            <c:forEach var="event" items="${events.rows}">
                <option value="${event.name}"><c:out value="${event.name}"/></option>
            </c:forEach>
        </select>
    </label>
    <input type="submit" formaction="change_event" formmethod="get" value="Change event" style="margin-left: 10px;">
    <input type="submit" formaction="delete_event" formmethod="post" value="Delete event">
</form>

<br>

GoSearch:
<form action="search_results.jsp" style="margin-top: 5px">
    <label>Name: <input type="text" name="name"></label>
    <input type="submit" value="Search">
</form>

</body>
</html>
