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
<title>REZULTATI</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">
<div id="outPopUp">
<form action="/Skola/testiranja/prikazSvihZaTrening" method="get">
<center>
<c:if test="${!empty trainings }">

	<select name="idTreninga">
	
		<c:forEach items="${trainings }" var="t">
			<option value="${t.idTreninga }">${t.datumOdrzavanja}, ${t.teren.adresa}</option>
		
		</c:forEach>
	
	</select>
	
</c:if>
<input type="submit" value="Prikazi">
</center>
</form>
<br>
<!--  
<c:if test="${!empty odrzavanjas }">
<table border="1">
	<th>Ucenik</th>
	<th>Disciplina</th>
	<th>Broj broj bodova</th>
	<th>Napomene</th>
	<c:forEach items="${odrzavanjas }" var="o">
		<tr>
			<td>
				${o.ucenik.ime } ${o.ucenik.prezime }
			</td>
			<td>
				
				${o.trening.sportskadisciplina.naziv }
			</td>
			<td>
				${o.brojBodova}
			
			</td>
			<td>
				${o.napomene }
			
			</td>
		
		</tr>
	
	
	</c:forEach>

</table>
	

</c:if>-->
<center>
<c:choose>
    <c:when test="${!empty odrzavanjas }">
        <table border="1">
	<th>Ucenik</th>
	<th>Disciplina</th>
	<th>Broj broj bodova</th>
	<th>Napomene</th>
	<c:forEach items="${odrzavanjas }" var="o">
		<tr>
			<td>
				${o.ucenik.ime } ${o.ucenik.prezime }
			</td>
			<td>
				
				${o.trening.sportskadisciplina.naziv }
			</td>
			<td>
				${o.brojBodova}
			
			</td>
			<td>
				${o.napomene }
			
			</td>
		
		</tr>
	
	
	</c:forEach>

</table>
    </c:when>    
    <c:otherwise>
    	<c:if test="${!empty porukaPrikazSvih}">
       <b> Za odabrani trening nema rezultata ili trenutno nisu uneseni.</b> 
        </c:if>
        <br />
    </c:otherwise>
</c:choose></center>
<br><center>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</div>
</body>
</html>