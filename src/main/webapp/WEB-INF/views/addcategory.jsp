<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form method="post" modelAttribute="category">
        <form:input path="name"/>
        <form:button>Zapisz</form:button>
    </form:form>
</div>
</body>
</html>
