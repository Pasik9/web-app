<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>findFilmsForYear</title>
</head>
<body>
<h1>HomeLibrary</h1>
<c:import url="/jspf/menu.jspf"></c:import>
<form action="findActors" method="post">
    <p>Введите имя актера:</p>
    <input type="text"><br>
</form>
<c:forEach items="${actorList}" var="item" >
    ${item} <br/>
</c:forEach>
</body>
</html>