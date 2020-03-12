<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Home</title>
    <link href="<c:url value="/resources/css/style.css?v=@buildNumber" />" rel=stylesheet>
</head>
<body>
<div>
<h1>PMExpress</h1>
<h2> ver 1.0 </h2>

<form action="passData.jsp">
    <input type="submit" class="input-box"  value="Перейти до вводу даних" >
</form>
</div>
</body>
</html>
