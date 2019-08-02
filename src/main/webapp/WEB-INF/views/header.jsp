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
    Witaj, ${userprofile.firstname}!
    <br>
    <br>
    <br>
    </div>
</sec:authorize>
<center>
    <img src="https://i.ibb.co/mBdg1X5/cooltext331901052392998.png"/><br>
</center>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
        <span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li class="dropdown-header">Dropdown header 1</li>
        <li><a href="#">HTML</a></li>
        <li><a href="#">CSS</a></li>
        <li><a href="#">JavaScript</a></li>
        <li class="divider"></li>
        <li class="dropdown-header">Dropdown header 2</li>
        <li><a href="#">About Us</a></li>
    </ul>
</div>