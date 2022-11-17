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
<title>SVI UCENICI</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">
<div id="outPopUp">
<center><b>SVI UCENICI</b></center><br><br>
<center>
<table border="1">

<c:if test="${!empty ucenici}" >
	<th>Ime</th>
	<th>Prezime</th>
	<th>Grupa</th>
	<th>Dodatni podaci</th>
	<th>Brisanje</th>
	<c:forEach items="${ucenici }" var="u">
		<tr>
			<td>${u.ime }</td>
			<td>${u.prezime }</td>
			<td>${u.grupa.nazivGrupe }</td>
			<td><a href="/Skola/ucenici/dodatniPodaci?idUcenika=${u.idUcenika}">Prikazi</a></td>
			<td><a href="/Skola/ucenici/brisanjeUcenika?idUcenika=${u.idUcenika}">Obrisi ucenika</a></td>
		</tr>
	</c:forEach>
	
</c:if>


</table>
</center>
</div>
</body>
</html>