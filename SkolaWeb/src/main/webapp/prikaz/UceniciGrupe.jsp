<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>UCENICI GRUPE</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">

<div id="outPopUp"><center>
<c:choose>

	<c:when test="${!empty ucenicigrupe}">
		Ucenici grupe <b><i>${grupaucenika.nazivGrupe}:</i></b><br><br><br>
		<table border="1">
			<th>Ime</th>
			<th>Prezime</th>
			<th>Datum rodjenja</th>
			<th>Adresa</th>
			<c:forEach items="${ucenicigrupe }" var="ug">
				
				<tr>
				
					<td>${ug.ime }</td>
					<td>${ug.prezime }</td>
					<td>${ug.datumRodjenja }</td>
					<td>${ug.adresa}</td>
					
				
				</tr>
			
			</c:forEach>
		
		
		
		</table>
	
	</c:when>
	<c:otherwise>
		<center>Grupa <b><i>${grupaucenika.nazivGrupe }</i></b> jos uvek nema upisanih ucenika za pregled.</center>
	</c:otherwise>

</c:choose></center>
<br>
<br>
<center><button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</div>
</body>
</html>