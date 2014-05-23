<%-- 
    Document   : reservaties
    Created on : 14-mei-2014, 8:42:30
    Author     : kamil.laga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Video - reservaties</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" />
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
            <h1>Reservaties</h1>
            <div class="reservaties">
                <h2> Zoek op genre</h2>
            <ul class="genremenu">
            <c:forEach var="genre" items="${genres}">
                <li class="genremenu">
                    <c:url value="/Films" var="filmURL">
                         <c:param name="genrenummer" value="${genre.genreNr}"/>
                    </c:url>
                    <a class="genremenu" href="${filmURL}">${genre.naam}</a>
                </li>
            </c:forEach>
            </ul>
            </div>
        </div>
    </body>    
</html>
