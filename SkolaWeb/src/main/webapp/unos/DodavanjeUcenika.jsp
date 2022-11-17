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
<title>Dodavanje ucenika</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">

<div id="outPopUp">
<center>
<sf:form action="/Skola/ucenici/saveUcenik" method="post" modelAttribute="ucenik">


		<table>
			<tr>
				<td>Grupe:</td>
				<td><sf:select path="grupa" items="${grupe}"
						itemValue="idGrupe" itemLabel="nazivGrupe">

					</sf:select></td>
			</tr>

			<tr>
				<td>Ime:</td>
				<td><sf:input type="text" path="ime" /></td>
			</tr>
			<tr>
				<td>Prezme:</td>
				<td><sf:input type="text" path="prezime" /></td>
			</tr>
			<tr>
				<td>Adresa:</td>
				<td><sf:input type="text" path="adresa" /></td>
			</tr>
			<tr>
				<td>Datum rodjenja</td>
				<td><sf:input type="date" path="datumRodjenja" /></td>
			</tr>
			<tr>
				<td>Datum prijave:</td>
				<td><sf:input type="date" path="datumPrijave" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sacuvaj" /></td>
			</tr>

		</table>

	</sf:form>
	</center>
	<br>
	<c:if test="${!empty ucenikSaved}">
	<center>
Ucenik je uspesno sacuvan, id je ${ucenikSaved.idUcenika}</center>
<br>
<br>
<br>

</c:if><center>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</div>
</body>
</html>