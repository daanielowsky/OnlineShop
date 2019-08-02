<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="media/style.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<form:form method="post" modelAttribute="user">
    <p>Login: <form:input path="username"/></p>
    <p>Hasło: <form:password path="password"/></p>
    <p>Remember me <input type="checkbox" name="remember-me"></p>
    <p><form:button>Zaloguj się</form:button> <button type="reset">Reset</button></p>
</form:form>
</body>
</html>
