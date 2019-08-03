<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="float: right; padding: 10px">
<sec:authorize access="!isAuthenticated()">
<a href="/login">Zaloguj się</a>
<a href="/register">Zarejestruj się</a>
    <br>
    <br>
    <br>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    Witaj, ${userprofile.firstname}! <a href="/profile">Profil</a> <a href="/logout">Wyloguj</a>
    <br>
    <br>
    <br>
    </div>
</sec:authorize>
<center>
    <a href="/"><img src="https://i.ibb.co/mBdg1X5/cooltext331901052392998.png"/></a><br>
</center>