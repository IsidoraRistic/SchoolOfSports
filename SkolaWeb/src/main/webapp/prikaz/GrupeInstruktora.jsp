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

<!--  
<c:if test="${!empty grupe}">
	<c:forEach items="${grupe}"  var="g">
		${g.nazivGrupe}, kapaciteta ${g.kapacitet } ucenika, kreirana ${g.datumKreiranja}<br>
	
	</c:forEach>

</c:if>
-->
<div id="outPopUp"><center>
<c:choose>
    <c:when test="${!empty grupe }">
    <center>Izabrani insturktor je zaduzen za sledece grupe:<br><br><br><br>
       <c:forEach items="${grupe}"  var="g">
       
		<b><i>${g.nazivGrupe},</i></b> kapaciteta <b><i>${g.kapacitet }</i></b> ucenika, kreirana <b><i>${g.datumKreiranja}</i></b><br>
	</center>
	</c:forEach>
    </c:when>    
    <c:otherwise>
    	
        <b>Odabrani instruktor trenutno nije zaduzen ni za jednu grupu.</b> 
    
        
    </c:otherwise>
</c:choose>
</center>
</div>
</body>
</html>