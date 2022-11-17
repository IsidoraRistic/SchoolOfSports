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
<title>UNOS BODOVA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">

<div id="outPopUp">



<form action="/Skola/testiranja/saveTestiranje" method="post">
<center>
<table>

	<tr>
		<td>Treninzi:</td>
		<td>
			<select name="idTreninga">
				<c:forEach items="${treninzi }" var="t">
					<option value="${t.idTreninga}">${t.datumOdrzavanja}, ${t.teren.adresa }</option>
				</c:forEach>
			
			</select>
		
		</td>
	
	
	</tr>
	<tr>
		<td>Napomene</td>
		<td><input type="text" name="napomene"></td>
	</tr>
	
	<tr>
		<td>Bodovi:</td>
		<td><input type="text" name="brojBodova"></td>
	</tr>
	
	

</table>
<input type="submit" value="Unesi">
</center>
</form>
<br>
<br>
<c:if test="${!empty otSaved }">
<center>
Rezultati testiranja za ${otSaved.datumTestiranja} ucenika ${ucenikD.ime } ${ucenikD.prezime } su sacuvani.<br><br>
<button><a href="/Skola/auth/pocetna"><i>Nazad na pocetnu</i></a></button></center>
</center>
</c:if>
</div>
</body>
</html>