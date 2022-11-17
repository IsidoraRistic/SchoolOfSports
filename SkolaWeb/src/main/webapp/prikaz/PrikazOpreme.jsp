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
<title>DOSTUPNA OPREMA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">
<div id="outPopUp">
<center><b>DOSTUPNA OPREMA</b><br><br>
<table border="1">

	<c:if test="${!empty oprema}">
		<th>Naziv</th>
		<th>Kolicina</th>
		<c:forEach items="${oprema }" var="o">
			<tr>
				<td>${o.nazivTipa }</td>
				<td>${o.kolicinaTipa }</td>
			</tr>
		
		</c:forEach>
		
	</c:if>

</table>
</center>

</div>
</body>
</html>