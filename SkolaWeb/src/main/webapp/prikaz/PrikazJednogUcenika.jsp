<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<title>PODACI UCENIKA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">
<div id="outPopUp">
<center>
<b><i>Prikaz podataka za ucenika ${u.ime } ${u.prezime }</i></b> :
<br>
<br>

	<table border="1">

	<tr>
		<td>Ime: </td>
		<td>${u.ime }</td>
	</tr>
	<tr>
		<td>Prezme: </td>
		<td>${u.prezime }</td>
	</tr>
	<tr>
		<td>Datum rodjenja: </td>
		<td>${u.datumRodjenja }</td>
	</tr>
	<tr>
		<td>Adresa: </td>
		<td>${u.adresa }</td>
	</tr>
	<tr>
		<td>Grupa: </td>
		<td>${u.grupa.nazivGrupe }</td>
	</tr>
	<tr>
		<td>Datum prijave: </td>
		<td>${u.datumPrijave }</td>
	</tr>	
	
	

</table>
</center>
<center>
<security:authorize access="hasRole('ROLE_INSTRUKTOR')">
<a href="/Skola/prisustva/dobaviPrisustva?idUcenika=${u.idUcenika}">Unesite prisustvo</a><br><br>
<a href="/Skola/testiranja/getDatumeTestiranjaUcenika?idUcenika=${u.idUcenika}">Unesite rezultate testiranja</a><br><br>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">   
<a href="/Skola/prisustva/prisustvaUcenika?idUcenika=${u.idUcenika}">Prikazi prisustva ucenika</a><br><br>
<a href="/Skola/ucenici/azurirajPodatke?idUcenika=${u.idUcenika}">Azuriraj podatke ucenika</a><br><br>
</security:authorize>



<a href="/Skola/testiranja/getRezTestiranja?idUcenika=${u.idUcenika}">Pogledajte rezultate proslih testiranja</a><br><br>
</center>
</div>
</body>
</html>