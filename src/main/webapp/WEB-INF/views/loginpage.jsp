<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
