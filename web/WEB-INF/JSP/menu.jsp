<%-- 
    Document   : menu
    Created on : 22-mei-2014, 8:21:01
    Author     : Kamil.Laga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class='menuheader'>
    <img src="${pageContext.servletContext.contextPath}/images/dvds.JPG"
      alt="logo"/>
    <nav>
        <ul id="menu">
            <c:url value="/welkom" var="rootURL"/>
            <li><a href="${rootURL}">Genres</a></li>
            <c:url value="/mandje" var="mandjeURL"/>
            <li><a href="${mandjeURL}">Mandje</a></li>
            <c:url value="/klant" var="klantURL"/>
            <li><a href="${klantURL}">Klant</a></li> 
        </ul>
    </nav>
</header>
      
