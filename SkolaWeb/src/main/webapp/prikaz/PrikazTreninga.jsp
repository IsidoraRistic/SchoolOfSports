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
<title>Prikaz treninga</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">

<div id="outPopUp">



 
	 
<c:if test="${!empty discipline}">
<center>
<table border="1">
	<th>Sportska Disciplina</th>
	<th>Zakazani treninzi</th>
	<c:forEach items="${discipline }" var="d">
		<tr>
			<td>${d.naziv }</td>
			<td><a href="/Skola/treninzi/nadjiTreninge?idSportskaDisciplina=${d.idSportskaDisciplina }">Prikazi</a></td>
		
		</tr>
	
	</c:forEach></table></center>
</c:if>

<br>
<br>
<!--  
<c:if test="${!empty treninzi }">
<table border="1">
	<th>Datum odrzavanja</th>
	<th>Teren</th>
	<th>Grupa</th>
	<th>Izbor terena/Promeni teren</th>
	<c:forEach items="${treninzi}" var="trening">
		<tr>
			<td>${trening.datumOdrzavanja}</td>
			<c:choose>
    		<c:when test="${!empty trening.teren}">
			<td>${trening.teren.adresa}</td>
			</c:when>
			<c:otherwise>
			<td>Nije izabran</td>
			</c:otherwise>
			</c:choose>
			<td>${trening.grupa.nazivGrupe}</td>
			<td><a href="/Skola/ulogainstruktora/azurirajTrening?idTreninga=${trening.idTreninga }">Prikazi</a></td>
		</tr>
	
	</c:forEach>	
</table>
</c:if>		-->
<center>
<c:choose>

	<c:when test="${!empty treninzi }">
	<table border="1">
	<th>Datum odrzavanja</th>
	<th>Teren</th>
	<th>Grupa</th>
	<th>Izbor terena/Promeni teren</th>
	<c:forEach items="${treninzi}" var="trening">
		<tr>
			<td>${trening.datumOdrzavanja}</td>
			<c:choose>
    		<c:when test="${!empty trening.teren}">
			<td>${trening.teren.adresa}</td>
			</c:when>
			<c:otherwise>
			<td>Nije izabran</td>
			</c:otherwise>
			</c:choose>
			<td>${trening.grupa.nazivGrupe}</td>
			<td><a href="/Skola/ulogainstruktora/azurirajTrening?idTreninga=${trening.idTreninga }">Prikazi</a></td>
		</tr>
	
	</c:forEach>	
</table>
	
	
	</c:when>
	<c:otherwise>
	
		<c:if test="${!empty poruka }">
			
			<center><b>Za ovu sportsku disciplinu jos nema odrzanih treninga.</b></center>
		
		</c:if>
	
	</c:otherwise>

</c:choose>
	</center>
	<br>
	<br><center>
	<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
	</div>
</body>
</html>