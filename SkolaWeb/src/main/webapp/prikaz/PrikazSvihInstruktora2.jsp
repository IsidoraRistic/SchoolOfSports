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
<title>PRIKAZ SVIH INSTRUKTORAA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">
<div id="outPopUp">
<center><b>SVI INSTRUKTORI:</b></center><br><br>
<center>
<table border="1">

	<c:if test="${!empty instruktori}">
	
<th>Ime</th>
<th>Prezime</th>

<th>Adresa</th>
<th>Datum zaposlenja</th>
<th>Dodatni podaci</th>

		<c:forEach items="${instruktori}" var = "i">
			<tr>
				<td>${i.ime}</td>
				<td>${i.prezime}</td>
				<td>${i.adresa}</td>
				<td>${i.datumZaposlenja}</td>
				<td><a href="/Skola/instruktori/PrikazJednog?idInstruktora=${i.idInstruktora}">Pregledaj</a></td>
			<tr>
		</c:forEach>
	
	</c:if>
</table>
</center>
</div>
</body>
</html>