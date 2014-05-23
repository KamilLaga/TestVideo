<%-- 
    Document   : bevestigen
    Created on : 20-mei-2014, 8:58:16
    Author     : kamil.laga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Video - Bevestiging</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" /> 
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Bevestigen</h1>
        <c:url value="/rapport" var="bevestigenURL" />
            
                    
       
        <form method="Post" action="${bevestigenURL}">
        <c:forEach var="klant" items="${klanten}" >
        <div> ${mandje.getSize()} film(s) voor ${klant.voornaam} ${klant.familienaam}</div>
        <input type="submit" value="bevestigen" />
        </c:forEach>
        </form>
        <br>
        <br>
        
        <table class="Tabel">
            <tr>
                <th colspan="2">Overzicht Films:</th>
            </tr>
                <c:forEach var="film" items="${mandje.getFilms()}">

                        <tr>
                            <td>${film.titel}</td>
                            <td>${film.prijs}&euro;</td>
                        </tr>

                </c:forEach>
        </table>
        <br>
    <div>Totaal: ${mandje.getTotaal()}&euro;</div>
    </body>
</html>
