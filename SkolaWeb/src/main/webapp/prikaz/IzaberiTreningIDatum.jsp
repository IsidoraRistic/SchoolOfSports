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
<title>Insert title here</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">

<div id="outPopUp">

<form action="/Skola/prisustva/prikaziZaTrening" method="get">
<center>
<c:if test="${!empty tren}">
	<select name="idTreninga">
	<c:forEach items="${tren }" var = "t">
		
		
		
			<option value="${t.idTreninga}">${t.datumOdrzavanja}, ${t.grupa.nazivGrupe}</option>
		
		
	
	</c:forEach>
	</select>

</c:if>
<br>
<br>
<input type="submit" value="Prikazi prisustva">
</center>
</form>
<br>
<!--  
<c:if test="${!empty prisustvaTrenings }">
	<table border="1">
	<th>Ucenik</th>
	<th>Napomene</th>
	
	<c:forEach items="${prisustvaTrenings }" var="pt">
	
		<tr>
			
			<td>${pt.ucenik.ime } ${pt.ucenik.prezime }</td>
			<td>${pt.napomene }</td>
		
		</tr>
	
	
	</c:forEach>
	
	
	
	

</table>
</c:if>
-->

<center>
<c:choose>

	<c:when test="${!empty prisustvaTrenings }">
		<table border="1">
	<th>Ucenik</th>
	<th>Napomene</th>
	<c:forEach items="${prisustvaTrenings }" var="pt">
	
		<tr>
			
			<td>${pt.ucenik.ime } ${pt.ucenik.prezime }</td>
			<td>${pt.napomene }</td>
		
		</tr>
	
	
	</c:forEach>
	
	
	
	

</table>
	</c:when>
	<c:otherwise>
		<c:if test="${!empty poruka1 }">
		<center><b>Za izabrani trening jos uvek nisu uneta prisustva/nema prisustva.</b></center>
	</c:if>
	</c:otherwise>

</c:choose></center>
<center>
<br><br><button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button>
</center>
</div>
</body>
</html>