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
    <p>Twoje Dane:</p>
    <p>Imię: ${userprofile.firstname}</p>
    <p>Nazwisko: ${userprofile.surname}</p>
    <p>Email: ${userprofile.email}</p>
    <p>Ilość zamówień: ${orders}</p>
    <button onclick="javascript:document.location.href='/profile/passwordchange'">Zmień hasło</button>
    <button onclick="javascript:document.location.href='/profile/edit'">Edytuj dane</button>
    <button onclick="javascript:document.location.href='/admin/addcategory'">Dodaj kategorię</button>
    <button onclick="javascript:document.location.href='/admin/additems'">Dodaj Przedmioty</button>

</div>
</body>
</html>
