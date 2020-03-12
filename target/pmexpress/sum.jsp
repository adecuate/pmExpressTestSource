<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <link href="<c:url value = "/resources/css/team_input.css?v=@buildNumber" />" rel=stylesheet>
    <title>sum</title>
</head>
<br>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Подія</th>
        <th>Коефіцієнт</th>
    </tr>
    <c:forEach items="${events}" var="allEvents">
        <tr>
            <td>${allEvents.id}</td>
            <td>${allEvents.nameEvent}</td>
            <td>${allEvents.kefEvent}</td>
        </tr>
    </c:forEach>
</table>
</br>
</br>
<div>
        <label1 for="lfname1" >Сума виграшу:</label1>
</div>
        </br>
        <label1 for="lfname2" >${sumWin}</label1>
</body>
</html>

