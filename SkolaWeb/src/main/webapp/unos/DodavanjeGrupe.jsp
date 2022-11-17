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
<title>DODAVANJE GRUPA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">

<div id="outPopUp">

<center>
Odaberite disciplinu za koju zelite da kreirate grupu:<br><br><br></center>
<br><br><br>
<form action="/Skola/ulogaadmina/getInstruktoreZaDisciplinu" method="get">
<center>
<select name="idSportskaDisciplina">
<c:forEach items="${disc }" var="d">


		
		<option value="${d.idSportskaDisciplina}">${d.naziv}</option>
		
	
</c:forEach>
</select>

<br>
<br>
<br>
<input type="submit" value="Prikazi instruktore za disciplinu">
</center>
</form>
<br>

<c:if test="${!empty ins }">
<form action="/Skola/ulogaadmina/saveGrupa" method="post">
	<center>
	<table>
	<tr>
	<td>Instruktor:</td>
	<td>
	<select name="idInstruktora">
	<c:forEach items="${ins }" var="i">
	
		
		
			<option value="${i.instruktor.idInstruktora}">${i.instruktor.ime } ${i.instruktor.prezime }</option>
		
	
	</c:forEach>
	</select>
	</td>
	</tr>
	
	<tr>
		<td>Naziv grupe: </td>
		<td><input type="text"  name="nazivGrupe"></td>
	</tr>
	<tr>
		
		<td>Kapacitet: </td>
		<td><input type="text" name="kapacitet"></td>	
	</tr>
	
	
	</table>
	<br>
	<input type="submit" value="Kreiraj grupu">
	</center>
</form>
</c:if>
<br>
<c:if test="${!empty novag}"><center>
Grupa ${novag.nazivGrupe } je uspesno kreirana.
<br>

</c:if>
<button><a href="/Skola/auth/pocetna">Nazad na pocetnu</a></button></center>
</div>
</body>
</html>