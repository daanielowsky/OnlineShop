<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="media/style.css"/>
</head>
<body>
<div class="mid">
    <jsp:include page="header.jsp"/>
    Dodaj przedmiot:
    <form:form method="post" modelAttribute="item">
        <p>Nazwa: <form:input path="name"/></p>
        <p>Opis: <form:input path="description"/></p>
        <p>Dostępność: <form:input path="avaiability"/></p>
        <p>Cena: <form:input path="price"/></p>
        <p>Kategoria:<br> <c:forEach items="${categories}" var="category">
            ${category.name}<form:radiobutton path="categoryName" value="${category.name}"/><br>
        </c:forEach></p>
        <p>Zdjęcie:<br> <input type="file" name="image"/></p>
        <br>
        <form:button>Wyślij</form:button>
    </form:form>
</div>
</body>
</html>
