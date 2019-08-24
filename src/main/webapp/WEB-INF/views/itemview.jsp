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
    <center>
        <h3>${itemToShow.name}</h3>
        <div>
            <img style="width: 40%; height: 40%;" src="/items/${itemToShow.name}/image"/>
        </div>
        <div>
            <h4>Cena:</h4>
            ${itemToShow.price}
            <h4>Ilość dostępnych sztuk:</h4>
            ${itemToShow.avaiability}
            <form method="post">
                <button name="${itemToShow.name}">Dodaj do koszyka</button>
            </form>
        </div>
    </center>
</div>
</body>
</html>
