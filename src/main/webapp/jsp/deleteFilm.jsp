<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>findFilmsForYear</title>
</head>
<body>
<h1>HomeLibrary</h1>
<c:import url="/jspf/menu.jspf"></c:import>
<form action="deleteFilm" method="post">
    <p>Введите год:</p>
    <input type="number"><br>
</form>
<c:forEach items="${actorList}" var="item" >
    ${item} <br/>
</c:forEach>
</body>
</html>