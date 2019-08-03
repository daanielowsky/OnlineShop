<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="media/style.css" type="text/css"/>
</head>
<body>
<div class="mid">
<jsp:include page="header.jsp"/> <br>
    <form:form modelAttribute="user" method="post">
        Imię: <form:input path="firstname"/> <form:errors path="firstname"/> <br>
        Nazwisko: <form:input path="surname"/> <form:errors path="surname"/> <br>
        Email: <form:input path="email"/> <form:errors path="email"/> <br>
        Nazwa użytkownika: <form:input path="username"/> <form:errors path="username"/><br>
        Hasło: <form:password path="password"/> <form:errors path="password"/> <br>
        Powtórz hasło: <form:password path="confirmedPassword"/> <form:errors path="confirmedPassword"/><br>
        <form:button>Zarejestruj się</form:button>
    </form:form>
</div>
</body>
</html>
