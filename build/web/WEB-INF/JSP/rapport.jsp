<%-- 
    Document   : rapport
    Created on : 20-mei-2014, 10:42:25
    Author     : kamil.laga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Video - Rapport</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" /> 
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Rapport</h1>
        <c:choose>
            <c:when test="${empty fouten}">
                <div>De reservatie is OK</div>
            </c:when>
            <c:otherwise>
                <div>
                    Volgende films zijn niet gereserveerd:
                    <ul>
                        <c:forEach var="film" items="${fouten}">
                        <li>${film.value}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:otherwise>   
        </c:choose>
        </div>   
    </body>
</html>
