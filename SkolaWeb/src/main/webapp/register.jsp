<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<br>
<br>
<br>
<br>
<center>
<sf:form modelAttribute="user"  action="register"  method="post">
  <table>
  	<tr>
  	   <td>Ime:</td><td><sf:input  path="ime"/>
  	   </td>
  	</tr>
  	<tr>
  	   <td>Prezime:</td><td><sf:input  path="prezime"/>
  	   </td>
  	</tr>
  		<tr>
  	   <td>Korisnicko ime:</td><td><sf:input  path="korisnickoIme"/>
  	 </td>
  	</tr>
  	<tr>
  	   <td>Sifra:</td><td><sf:password  path="sifra"/></td>
  	</tr>
  	<tr>
  	  <td>
  	   Uloga
  	  </td>
  	  <td>
  	  <sf:select path="ulogas" items="${roles}" itemValue="idUloga" itemLabel="naziv"/>
	   </td>
	</tr>
  	<tr><td/><td><input type="submit" value="Sacuvaj"></tr>
  	</table>
</sf:form>
</center>
</body>
</html>