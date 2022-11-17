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
<title>Azurirajte teren</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo6.jpg');">

<div id="outPopUp">

<form action="/Skola/ulogainstruktora/izabranTeren" method="post">
<center>
<table border="1">

	<tr>
		<td>Datum odrzavanja: </td>
		<td>${treningaz.datumOdrzavanja }</td>
	</tr>
	<tr>
		<td>Grupa</td>
		<td>${treningaz.grupa.nazivGrupe}</td>
	</tr>
	<tr>
		<td>Instruktor</td>
		<td>${treningaz.instruktor.ime} ${treningaz.instruktor.prezime}</td>
	</tr>
	 <tr>
		<td>Sportska disciplina </td>
		<td>${treningaz.sportskadisciplina.naziv}</td>
	</tr>
	<tr>
		<td>Teren: </td>
		<c:choose>
    		<c:when test="${!empty treningaz.teren}">
			<td>${treningaz.teren.adresa}</td>
			</c:when>
			<c:otherwise>
			<td>Nije izabran</td>
			</c:otherwise>
			</c:choose>
	</tr>
	
</table>
<br>
<c:if test="${!empty tereniaz}">

Izaberite novi teren:
<select name="idTerena">
	<c:forEach items="${tereniaz }" var="tz">
		<option value="${tz.idTerena}">${tz.adresa}</option>
	</c:forEach>

</select>
</c:if>

<input type="submit" value="Izmeni"><br>
<br>

<br>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button>
</center>
</form>
</div>
</body>
</html>