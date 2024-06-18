<!DOCTYPE html>
<html>
<head>
    <title>Noties</title>
</head>
<body>


<#list notice as notice>
    <div>
        <p><b>${notice.title}</b> <a href="/notice/${notice.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Заметок нет</h3>
</#list>
<hr>
<h3>Создать заметку</h3>
<form action="/notice/create" method="post">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>