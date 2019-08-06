<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/media/style.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="mid">
    <jsp:include page="header.jsp"/>
    <c:forEach items="${itemsForList}" var="items">
        <img class="image-list" src="/items/${items.name}/image"/>
        <font size="6"><a href="/items/${items.name}">${items.name}</a></font><br>
        <p><h4>Cena:</h4> ${items.price}</p>
        <p><h4>Ilość dostępnych sztuk:</h4> ${items.avaiability}</p>
        <p><h4>Opis:</h4></p>
        <small>${items.description}</small><br>
        <hr>
    </c:forEach>
</div>
</body>
</html>
