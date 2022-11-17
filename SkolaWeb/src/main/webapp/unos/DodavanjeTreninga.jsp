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
<title>Dodavanje Treninga</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">

<div id="outPopUp">

<!--  
<sf:form action="/Skola/treninzi/saveTrening" method="post" modelAttribute="trening">


		<table>
			<tr>
				<td>Grupe:</td>
				<td><sf:select path="grupa" items="${grupe}"
						itemValue="idGrupe" itemLabel="nazivGrupe">

					</sf:select></td>
			</tr>
			
			<tr>
				<td>Teren:</td>
				<td><sf:select path="teren" items="${tereni}"
						itemValue="idTerena" itemLabel="adresa">

					</sf:select></td>
			</tr>

		
			<tr>
				<td>Datum odrzavanja: </td>
				<td><sf:input type="date" path="datumOdrzavanja" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Sacuvaj" /></td>
			</tr>

		</table>

	</sf:form>-->
	
	<center>
	<sf:form action="/Skola/treninzi/saveTrening" method="post" modelAttribute="trening">


		<table>
			<tr>
				<td>Grupe:</td>
				<td><sf:select path="grupa" items="${grupe}"
						itemValue="idGrupe" itemLabel="nazivGrupe">

					</sf:select></td>
			</tr>
			


		
			<tr>
				<td>Datum odrzavanja: </td>
				<td><sf:input type="date" path="datumOdrzavanja" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Sacuvaj" /></td>
			</tr>

		</table>

	</sf:form>
	</center>
	<center>
	<c:if test="${!empty treningSaved}">
Trening je uspesno zakazan, id je ${treningSaved.idTreninga}
</c:if></center>
<br><br><center>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>

</div>
</body>
</html>