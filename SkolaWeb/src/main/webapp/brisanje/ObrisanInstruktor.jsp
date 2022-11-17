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
<title>BRISANJE INSTRUKTORA</title>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo6.jpg');">

<div id="outPopUp">
<center>
<p>
<b>${poruka }</b>
</p></center>
</div>
</body>
</html>