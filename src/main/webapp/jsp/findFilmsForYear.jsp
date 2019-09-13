<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>findFilmsForYear</title>
    </head>
    <body>
        <h1>HomeLibrary</h1>
        <p>
            <a href="findFilmsForYear">Find films for year</a><br>
            <a href="findActorForFilm">find actor for film</a><br>
            <a href="findAcror">findactor for N films</a><br>
            <a href="findActorAsDirector">find actor as Director</a><br>
            <a href="deleteFilm">delete Film</a><br>
        </p>
        <form action="findFilmsForYear" method="post">
            <p>Введите с какого года:</p>
            <input type="number" name="y1"><br>
            <p>по какой год</p>
            <input type="number" name="y2"><br>
            <input type="submit">
        </form>
    </body>
</html>
