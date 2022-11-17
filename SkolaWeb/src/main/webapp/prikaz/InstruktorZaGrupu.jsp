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
<title>PRIKAZ INSTRUKTORA GRUPE</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">
<div id="outPopUp">
<form action="/Skola/instruktori/getGrupeInstruktora" method="get">
<center>
<select name="idInstruktora">
	
	<c:forEach items="instruktoriG" var = "ig">
		<option value="${ig.idInstruktora }">${ig.ime } ${ig.prezime }</option>
	</c:forEach>

</select><br>
<input type="submit" value="Prikazi">
</center>
</form>
<br>
</div>

</body>
</html>