<%-- 
    Document   : mandje
    Created on : 14-mei-2014, 13:29:50
    Author     : kamil.laga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Video - Mandje</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" />
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Mandje</h1>
        <c:url var="MandjeURL" value="/mandje/verwijderen" />
        <form method="Post" action="${MandjeURL}" >
        <table class="Tabel">
            <tr>
                <th colspan="3">Films in mandje</th>
            </tr>
            <tr>
                <th>Film</th>
                <th>Prijs</th>
                <th><input type="submit" value="verwijderen" /></th>
            </tr>
            <c:forEach var="film" items="${mandje.getFilms()}">
             <tr>
                    <td>${film.titel}</td>
                    <td>${film.prijs}&euro;</td>
                    <td><input type="checkbox" name="filmNr" value="${film.filmNr}" /></td>
             </tr>
            </c:forEach>
             <tr>
                    <td>TOTAAL:</td>
                    <td>${mandje.getTotaal()}&euro;</td>
             </tr>
        </table>
    </form>
    </div>
    </body>
</html>
