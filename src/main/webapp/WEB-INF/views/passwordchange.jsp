<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/media/style.css" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="mid">
    <jsp:include page="header.jsp"/>
    <h3>Zmiana hasła</h3>
    <form:form modelAttribute="passwordChange" method="post">
        <h5>Stare hasło:</h5>
        <form:password path="oldPassword"/> <form:errors path="oldPassword"/>
        <h5>Hasło:</h5>
        <form:password path="password"/> <form:errors path="password"/>
        <h5>Powtórz hasło:</h5>
        <form:password path="confirmedPassword"/> <form:errors path="confirmedPassword"/>
        <form:button>Zapisz</form:button> <button type="reset">Reset</button>
    </form:form>
</div>
</body>
</html>
