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
<title>PODACI INSTRUKTORA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">
<div id="outPopUp">
<center>Prikaz podataka za instruktora <b><i>${instruktor.ime } ${instruktor.prezime }</i> </b>:<br><br>
<form action="/Skola/instruktori/getGrupeInstruktora" method="get"><center>
<table border="1">
<tr><td>Ime</td><td>${instruktor.ime }</td></tr>
<tr><td>Prezime</td><td>${instruktor.prezime }</td></tr>

<tr><td>Datum rodjenja</td><td>${instruktor.datumRodjenja}</td></tr>

<tr><td>Adresa</td><td>${instruktor.adresa}</td></tr>

<tr><td>Datum zaposlenja</td><td>${instruktor.datumZaposlenja}</td></tr>

<tr><td>E-mail</td><td>${instruktor.email}</td></tr>
<tr>
<td>Pregled grupa instruktora</td>
<td><a href="/Skola/instruktori/getGrupeInstruktora?idInstruktora=${instruktor.idInstruktora}">Prikazi</a></td> </tr>


</table>
</center>
</form>
<br>
<br>
<a href="/Skola/instruktori/azuriranjeInstruktora?idInstruktora=${instruktor.idInstruktora}">Azuriraj podatke instruktora</a>
</center>
<br>
</div>


</body>
</html>