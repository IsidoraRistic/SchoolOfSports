<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>AZURIRANJE INSTRUKTORA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo6.jpg');">

<div id="outPopUp">

<form action="/Skola/instruktori/azurirajInstruktora" method="post">
<center>
<table border="1">

	<tr>
		<td>Ime: </td>
		<td>${instruktorA.ime }</td>
		<td>Novo ime: </td>
		<td><input type="text" name="ime"></td>
	</tr>
	<tr>
		<td>Prezime: </td>
		<td>${instruktorA.prezime }</td>
		<td>Novo prezime: </td>
		<td><input type="text" name="prezime"></td>
	</tr>
	 <tr>
		<td>Datum rodjenja: </td>
		<td>${instruktorA.datumRodjenja }</td>
		<td>Novi datum rodjenja: </td>
		<td><input type="date" name="datumRodjenja"></td>
	</tr>
	<tr>
		<td>Adresa: </td>
		<td>${instruktorA.adresa }</td>
		<td>Nova adresa: </td>
		<td><input type="text" name="adresa"></td>
	</tr>
	<tr>
		<td>E-mail: </td>
		<td>${instruktorA.email }</td>
		<td>Novi e-mail: </td>
		<td><input type="text" name="email"></td>
	</tr>
	
	

</table>
<br>
<input type="submit" value="Izmeni"></center>


</form>
<br>

<br><br><center><button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</div>
</body>
</html>