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
}</style>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="ISO-8859-1">
<title>PRISUSTVA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">
<div id="outPopUp">


<!--<c:if test="${!empty prisustva }" >
	<table border="1">
	<th>Datum odrzavanja treninga</th>
	<th>Teren</th>
	<th>Napomene</th>

</c:if>
	<c:forEach items="${prisustva}" var = "p">
		<tr>
			<td>${p.trening.datumOdrzavanja }</td>
			<td>${p.trening.teren.adresa}</td>
			<td>${p.napomene }</td>
		</tr>
	
	</table>
	</c:forEach>  -->
	<center>
	<c:choose>
	
		<c:when test="${!empty prisustva }">
		<center><table border="1">
	<th>Datum odrzavanja treninga</th>
	<th>Teren</th>
	<th>Napomene</th>


	<c:forEach items="${prisustva}" var = "p">
		<tr>
			<td>${p.trening.datumOdrzavanja }</td>
			<td>${p.trening.teren.adresa}</td>
			<td>${p.napomene }</td>
		</tr>
	</c:forEach>
	</table></center>
		
		</c:when>
		<c:otherwise>
		<b>Nema prisustava za prikazivanje.</b>
		
		</c:otherwise>
	
	</c:choose></center>

</div>
</body>
</html>