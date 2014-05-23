<%-- 
    Document   : klant
    Created on : 15-mei-2014, 10:34:20
    Author     : kamil.laga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Video - Klanten</title>
        <link rel="stylesheet" href="${contextPath}/styles/video.css" /> 
    </head>
    <body>
        <div class="wikkel">
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Klanten</h1>
        <c:url value="/klant" var="klantURL" />
        <form method="get" action="${klantURL}">
            <label>Familienaam bevat:
                <input name="Familienaam" value="${param.Familienaam}" />
                <span class="fout">${fouten.familienaam}</span></label>
                <input type="submit" value="Zoeken" />
        </form>

         <c:if test="${not empty klanten}">           
                <br>
                <br>
     <table class="Tabel">
        <tr>
            <th>Naam</th>
            <th>Straat - Huisnummer</th>
            <th>Postcode</th>
            <th>Gemeente</th>
        </tr>
        
            <c:forEach var="klant" items="${klanten}">
                <c:url value="/bevestigen" var="bevestigenURL">
                    <c:param name="Familienaam" value="${klant.familienaam}" />
                    <c:param name="Voornaam" value="${klant.voornaam}" />
                </c:url>
                <tr>
                    <td><a class="klantmenu" href="${bevestigenURL}">${klant.voornaam} ${klant.familienaam}</a></td>
                    <td>${klant.straatNummer}</td>
                    <td>${klant.postcode}</td>
                    <td>${klant.gemeente}</td>
                </tr>
            </c:forEach>
        </c:if>
     </table>
                <c:if test="${not empty fouten.nietgevonden}" >
                    <span class="fout">${fouten.nietgevonden}</span>
                </c:if>
        </div>            
    </body>
</html>
