<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize access="!isAuthenticated()">
    <p style="float: right; padding: 10px;">
        <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:document.location.href='/login'">
            Zaloguj
        </button>
        <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:document.location.href='/register'">
            Zarejestruj się
        </button>
        <br>
        <br>
    </p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p style="float: right; padding: 10px;">
    Witaj, ${userprofile.firstname}!
    <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:document.location.href='/profile'">
        Profil
    </button>
    <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:document.location.href='/logout'">
        Wyloguj
    </button>
    </p>
</sec:authorize>
<hr>
<div>
    <center>
        <a href="/"><img src="https://i.ibb.co/mBdg1X5/cooltext331901052392998.png"/></a><br>
    </center>
</div>
<hr>
<center>
    <div class="dropdown">
        <button style="margin-left: 5%; margin-right: 5%; width: 85%"
                class="btn btn-primary dropdown-toggle btn-block btn-lg" type="button" data-toggle="dropdown">Kategorie
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <c:forEach items="${categoriesDropdown}" var="category">
                <li><a href="/category/${category.name}">${category.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</center>
<hr>