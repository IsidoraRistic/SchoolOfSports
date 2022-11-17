<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
overflow:hidden;
}

</style>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<title>Prijava</title>
</head>


<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">

<a href="/Skola/OSkoli.jsp">O skoli</a>

<security:authorize access="hasRole('ROLE_INSTRUKTOR')">
<a href="/Skola/ulogainstruktora/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/ulogainstruktora/prikaziTreninge">Prikaz zakazanih treninga</a>
<a href="/Skola/ulogainstruktora/prikaziOpremu">Prikaz dostupne opreme</a>
<a href="/Skola/ulogainstruktora/sviUcenici2">Prikaz svih ucenika 2 </a>
<a href="/Skola/ulogainstruktora/sviInstruktori2">Pregled grupa (po intruktoru)</a>
<a href="/Skola/auth/logout">Odjava</a>
</security:authorize>

<!-- UNOS MORAS OMOGUCITI ZA ADMINA  --> 
<security:authorize access="hasRole('ROLE_ADMIN')">                                    
<a href="/Skola/unos/dodavanjeInstruktora.jsp">Unos instruktora</a>
<a href="/Skola/ulogaadmina/sviInstruktori">Prikaz instruktora</a>
<a href="/Skola/ulogaadmina/unosUcenika">Unos ucenika</a>
<a href="/Skola/ulogaadmina/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/ulogaadmina/sviInstruktori2">Pregled grupa (po intruktoru)</a>
<a href="/Skola/ulogaadmina/zakaziTrening">Zakazi trening</a>

<a href="/Skola/ulogaadmina/getDiscipline">Kreiranje nove grupe</a>


<a href="/Skola/ulogaadmina/sviUcenici">Prikaz svih ucenika</a>


<a href="/Skola/ulogaadmina/getSviUceniciReport.pdf">Svi ucenici po grupama - izvestaj</a>
<a href="/Skola/unos/TreninziPeriod.jsp">Treninzi za uneseni period - izvestaj</a>
<a href="/Skola/ulogaadmina/prisustvaZaTreningIDatum">Pregled prisustava</a>
<a href="/Skola/auth/logout">Odjava</a>
</security:authorize>



<security:authorize access="hasRole('ROLE_CLAN')">      
<a href="/Skola/ulogaclana/izaberiTestiranje">Prikaz rezultata testiranja</a><br>
<a href="/Skola/ulogaclana/prijavaZaSport">Prijava za sport</a><br>

<a href="/Skola/ulogaclana/prisustvaZaTreningIDatum">Pregled prisustava</a>
<a href="/Skola/auth/logout">Odjava</a>
</security:authorize>

<div id="outPopUp">
	<c:url var="loginUrl" value="/login" />
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger">
			<p>Pogresni podaci.</p>
		</div>
	</c:if>
	<form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Korisnicko ime</td>
				<td><input type="text" name="username"
					placeholder="Unesite korisnicko ime" required></td>
			</tr>
			<tr>
				<td>Sifra</td>
				<td><input type="password" name="password"
					placeholder="Unesite sifru" required></td>
			</tr>
			 <tr>
                <td>Zapamti me:</td>
                <td><input type="checkbox" name="remember-me" /></td>
            </tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
				<td><input type="submit" value="Prijava"></td>
			</tr>
		</table><br/><br/>
		Nemate nalog? <a href="/Skola/auth/registerUser">Registrujte se</a>
	
	</div>
</body>
</html>