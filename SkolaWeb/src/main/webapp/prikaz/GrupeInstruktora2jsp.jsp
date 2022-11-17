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
<title>GRUPE INSTRUKTORA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo4.jpg');">
	<!-- <table border="1">
		<c:if test="${!empty grupe}">
			<th>Naziv grupe</th>
			<th>Kapacitet</th>
			<th>Datum kreiranja</th>
			<c:forEach items="${grupe}" var="g">
				<tr>
					<td>${g.nazivGrupe}</td>
					<td>${g.kapacitet }</td>
					<td>${g.datumKreiranja }</td>
				</tr>

			</c:forEach>

		</c:if>
	</table> -->
<div id="outPopUp"><center>
	<c:choose>
		
			<c:when test="${!empty grupe }">
			<table border="1">
				<th>Naziv grupe</th>
				<th>Kapacitet</th>
				<th>Datum kreiranja</th>
				<c:forEach items="${grupe}" var="g">
					<tr>
						<td>${g.nazivGrupe}</td>
						<td>${g.kapacitet }</td>
						<td>${g.datumKreiranja }</td>
					</tr>

				</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<c:if test="${!empty poruka }">
       <b>Odabrani instruktor trenutno nije zaduzen ni za jednu grupu.</b> 
        </c:if>
				<br />
			</c:otherwise>
			
	</c:choose></center>
</div>
</body>
</html>