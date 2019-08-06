<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    Dodaj przedmiot:
    <form:form method="post" modelAttribute="item" enctype="multipart/form-data">
        <p>Nazwa: <form:input path="name"/> <form:errors path="name"/></p>
        <p>Opis: <form:input path="description"/> <form:errors path="description"/></p>
        <p>Dostępność: <form:input path="avaiability"/> <form:errors path="avaiability"/></p>
        <p>Cena: <form:input path="price"/> <form:errors path="price"/></p>
        <p>Kategoria:<br>
            <form:select path="categoryName">
            <c:forEach items="${categories}" var="category">
                <form:option value="${category.name}"/>
            </c:forEach>
            </form:select></p>
        <p>Zdjęcie:<br> <input type="file" name="file"/><form:errors path="image"/></p>
        <br>
        <form:button>Wyślij</form:button>
    </form:form>
</div>
</body>
</html>
