<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
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
    <form:form modelAttribute="editUser" method="post">
        <h5>Imię:</h5>
        <form:input path="firstname" placeholder="${userprofile.firstname}"/> <form:errors path="firstname"/>
        <h5>Nazwisko:</h5>
        <form:input path="surname" placeholder="${userprofile.surname}"/> <form:errors path="surname"/>
        <h5>Email:</h5>
        <form:input path="email" placeholder="${userprofile.email}"/> <form:errors path="email"/> <br>
        <form:button>Zapisz</form:button> <button type="reset">Reset</button>
    </form:form>
</div>
</body>
</html>
