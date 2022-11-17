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
<title>SVE GRUPE</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo5.jpg');">

<div id="outPopUp">



	
	<center>
	
     <c:if test="${!empty gru }">
     	<table border = "1">
			<th>Naziv</th>
			<th>Kapacitet</th>
			<th>Upisani ucenici</th>
      		
			<c:forEach items="${gru }" var="g">
				
				<tr>
					
					<td>${g.nazivGrupe }</td>
					<td>${g.kapacitet}</td>
					<td><a href="/Skola/ulogainstruktora/zaGrupu?idGrupe=${g.idGrupe}">Prikazi</a></td>
				
				</tr>
			
			</c:forEach>
	</table>
	</c:if>
	</center>

</div>
</body>
</html>
