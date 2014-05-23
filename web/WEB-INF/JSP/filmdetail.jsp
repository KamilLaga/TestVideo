<%-- 
    Document   : filmdetail
    Created on : 14-mei-2014, 11:59:50
    Author     : kamil.laga
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <title>Video - ${film.titel}</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" />
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>${filmDetail.titel}</h1>
        <img src="${contextPath}/images/${filmDetail.filmNr}.jpg" alt="Kan niet worden getoond" />
        <table>
            <tr>
            <td>Prijs:</td>
            <td class="rechts">${filmDetail.prijs}&euro;</td>
            </tr>
            <tr>
            <td>voorraad:</td>
            <td class="rechts">${filmDetail.voorraad}</td>
            </tr>
            <tr>
            <td>Gereserveerd:</td>
            <td class="rechts">${filmDetail.gereserveerd}</td>
            </tr>
            <tr>
            <td>Beschikbaar:</td>
            <td class="rechts">${filmDetail.beschikbaar}</td>
            </tr>
            
        </table>
            <c:if test="${filmDetail.beschikbaar > 0}" >
                <c:url value="/mandje" var="bestelURL">
                    <c:param name="filmNummer" value="${filmDetail.filmNr}" />
                </c:url>
                <form method="post" action="${bestelURL}">
                <input type="submit" value="In Mandje" />
                </form>
            </c:if>
        </div>
    </body>
</html>
