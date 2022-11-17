<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>

#outPopUp {
  position: absolute;
  width: 500px;
  height: 250px;
  z-index: 15;
  top: 50%;
  left: 50%;
  margin: -100px 0 0 -150px;
background: honeydew;
border: 3px solid #73AD21;
overflow:auto;
}

</style>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="ISO-8859-1">
<title>PRIKAZ TESTIRANJA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">

<div id="outPopUp">
<center>
Prikaz rezultata testiranja za ucenika <b><i>${ucenikT.ime } ${ucenikT.prezime}</i></b> :</center>
<!--  
<c:if test="${!empty testiranja}">
<table border="1">
	<th>Datum odrzavanja </th>
	<th>Teren</th>
	<th>Broj osvojenih bodova</th>
	<th>Napomene</th>

	<c:forEach items="${testiranja}" var="t">
		<tr>
			<td>${t.datumTestiranja}</td>
			<td>${t.trening.teren.adresa }</td>
			<td>${t.brojBodova }</td>
			<td>${t.napomene }</td>
		</tr>
		
	</c:forEach>
	</table>
</c:if>
-->
<center>
<c:choose>
	<c:when test="${!empty testiranja}">
		<table border="1">
	<th>Datum odrzavanja </th>
	<th>Teren</th>
	<th>Broj osvojenih bodova</th>
	<th>Napomene</th>

	<c:forEach items="${testiranja}" var="t">
		<tr>
			<td>${t.datumTestiranja}</td>
			<td>${t.trening.teren.adresa }</td>
			<td>${t.brojBodova }</td>
			<td>${t.napomene }</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	</c:when>
	<c:otherwise>
	<b>Odabrani ucenik nije izlazio ni na jedno testiranje ili rezultati trenutno nisu uneseni.</b>
	
	</c:otherwise>
</c:choose></center>
</div>


</body>
</html>