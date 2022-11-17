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
<title>DODAVANJE INSTRUKTORA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">

<div id="outPopUp">

<form action="/Skola/instruktori/saveInstruktor" method="post">
	<center>
	<table>


	<tr>
		<td>Ime</td>
		<td><input type="text" name="ime"></td>
	</tr>
	<tr>
		<td>Prezime</td>
		<td><input type="text" name="prezime"></td>
	</tr>
	<tr>
		<td>Adresa</td>
		<td><input type="text" name="adresa"></td>
	</tr>
	<tr>
		<td>E-mail:</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>Datum rodjenja:</td>
		<td><input type="date" name="datumRodjenja"></td>
	</tr>
	<tr>
		<td>Datum zaposlenja:</td>
		<td><input type="date" name="datumZaposlenja"></td>
	</tr>
	<tr>
	
		
		<td><input type="submit" name="Unesi"></td>
	</tr>
	
</table>

</center>
</form>

<br>
<c:if test="${!empty poruka }">
${poruka }
</c:if>
<br><center>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>

</div>
</body>
</html>