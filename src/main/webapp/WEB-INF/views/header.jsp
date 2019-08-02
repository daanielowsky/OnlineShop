<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="float: right; padding: 10px">
<sec:authorize access="!isAuthenticated()">
<a href="/login">Zaloguj się</a>
<a href="/register">Zarejestruj się</a>
    <br>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    Witaj, ${userprofile.firstname}!
    <br>
</sec:authorize>
</div>