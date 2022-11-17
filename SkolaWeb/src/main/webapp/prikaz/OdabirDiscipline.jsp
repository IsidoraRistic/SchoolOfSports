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
<title>PRIJAVA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">

<div id="outPopUp">
<form action="/Skola/grupe/getGrupeSl" method="get">
<center>

<c:if test="${!empty disc }">
	<select name="idSportskaDisciplina">
		<c:forEach items="${disc }" var="d">
			<option value="${d.idSportskaDisciplina}">${d.naziv}</option>
		
		</c:forEach>
	
	
	</select>



</c:if>





<input type="submit" value="Pronadji grupe sa slobodnim mestima">
</center>
</form>
<br>
<center>
<c:choose>

<c:when test="${ !empty grupeSaMestima}">
<form action="/Skola/ucenici/saveUcenik2" method="post">






<table>
			<tr>
				<td>Grupe:</td>
				<td><select name="idGrupe" >
						<c:forEach items="${grupeSaMestima}" var ="gsm">
							<option value="${gsm.idGrupe }">${gsm.nazivGrupe}</option>
						
						</c:forEach>

					</select></td>
			</tr>

			<tr>
				<td>Ime:</td>
				<td><input type="text" name="ime" /></td>
			</tr>
			<tr>
				<td>Prezme:</td>
				<td><input type="text" name="prezime" /></td>
			</tr>
			<tr>
				<td>Adresa:</td>
				<td><input type="text" name="adresa" /></td>
			</tr>
			<tr>
				<td>Datum rodjenja</td>
				<td><input type="date" name="datumRodjenja" /></td>
			</tr>
		<!--  	<tr>
				<td>Datum prijave:</td>
				<td><input type="date" name="datumPrijave" /></td>
			</tr>-->
			<tr>
				<td><input type="submit" value="Prijavi" /></td>
			</tr>

		</table>

</form>
	<br>
	<c:if test="${!empty ucenikSaved2}">
<b>Prijava je uspesna,Vas id je ${ucenikSaved2.idUcenika}</b><br>
</c:if>

</c:when>
<c:otherwise>
<c:if test="${!empty porukaSU }">
<b>Trenutno nema grupe sa slobodnim mestima za izabranu sportsku disciplinu.</b><br></c:if>
</c:otherwise>

</c:choose>
</center>
<!-- 
<c:if test="${ !empty grupeSaMestima}">

<form action="/Skola/ucenici/saveUcenik2" method="post">






<table>
			<tr>
				<td>Grupe:</td>
				<td><select name="idGrupe" >
						<c:forEach items="${grupeSaMestima}" var ="gsm">
							<option value="${gsm.idGrupe }">${gsm.nazivGrupe}</option>
						
						</c:forEach>

					</select></td>
			</tr>

			<tr>
				<td>Ime:</td>
				<td><input type="text" name="ime" /></td>
			</tr>
			<tr>
				<td>Prezme:</td>
				<td><input type="text" name="prezime" /></td>
			</tr>
			<tr>
				<td>Adresa:</td>
				<td><input type="text" name="adresa" /></td>
			</tr>
			<tr>
				<td>Datum rodjenja</td>
				<td><input type="date" name="datumRodjenja" /></td>
			</tr>
		<!--  	<tr>
				<td>Datum prijave:</td>
				<td><input type="date" name="datumPrijave" /></td>
			</tr>--><!--  
			<tr>
				<td><input type="submit" value="Prijavi" /></td>
			</tr>

		</table>

</form>
	<br>
	<c:if test="${!empty ucenikSaved2}">
Prijava je uspesna,Vas id je ${ucenikSaved2.idUcenika}<br>
</c:if>
</c:if>--><center>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</div>
</body>
</html>