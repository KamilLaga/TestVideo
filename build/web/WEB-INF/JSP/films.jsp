<%-- 
    Document   : films
    Created on : 14-mei-2014, 10:51:04
    Author     : kamil.laga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Video - Films</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" />
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <c:if test="${not empty films}">  
        <h1>Films voor u gekozen Genre </h1>
        
        <c:forEach var="film" items="${films}">
            <c:url value="/Films/Detail" var="detailURL" >
                <c:param name="filmNummer" value="${film.filmNr}" />
            </c:url>
            <a href="${detailURL}" >
            <img src="${contextPath}/images/${film.filmNr}.jpg" alt="MISLUkkKT" title="${film.titel} /// ${film.gereserveerd < film.voorraad ? "reservatie mogelijk" : "reservatie niet mogelijk" }" />
            </a>
        </c:forEach>
        </c:if>
        <c:if test="${not empty filmsOpTitel}">
            <c:forEach var="filmOpTitel" items="${filmsOpTitel}">
                <c:url value="/Films/Detail" var="detailURL" >
                <c:param name="filmNummer" value="${film.filmNr}" />
            </c:url>
            <a href="${detailURL}" >
            <img src="${contextPath}/images/${film.filmNr}.jpg" alt="MISLUkkKT" title="${film.titel} /// ${film.gereserveerd < film.voorraad ? "reservatie mogelijk" : "reservatie niet mogelijk" }" />
            </a>
            </c:forEach>
        </c:if>
        </div>
    </body>
</html>
