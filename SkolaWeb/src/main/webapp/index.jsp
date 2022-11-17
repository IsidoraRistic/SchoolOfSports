<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="ISO-8859-1">
<title>INDEX STRANICA</title>





</head>
<body style="background-image: url('${pageContext.request.contextPath}/img/sportsklogo3jpg.jpg');">
<!--  HelloAnne!-->
<br><!--  
<a href="/Skola/unos/dodavanjeInstruktora.jsp">Unos instruktora</a>
<a href="/Skola/instruktori/sviInstruktori">Prikaz instruktora</a>
<a href="/Skola/ucenici/unosUcenika">Unos ucenika</a>
<a href="/Skola/grupe/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/instruktori/sviInstruktori2">Pregled grupa (po intruktoru)</a>
<a href="/Skola/treninzi/zakaziTrening">Zakazi trening</a>
<a href="/Skola/treninzi/prikaziTreninge">Prikaz zakazanih treninga</a>
<a href="/Skola/treninzi/prikaziOpremu">Prikaz dostupne opreme</a>
<a href="/Skola/ucenici/sviUcenici">Prikaz svih ucenika</a>
<a href="/Skola/testiranja/izaberiTestiranje">Prikaz rezultata testiranja</a><br>
<a href="/Skola/ucenici/prijavaZaSport">Prijava za sport</a><br>
<a href="/Skola/ucenici/getSviUceniciReport.pdf">Svi ucenici po grupama - izvestaj</a>
<a href="/Skola/unos/TreninziPeriod.jsp">Treninzi za uneseni period - izvestaj</a>
<a href="/Skola/prisustva/prisustvaZaTreningIDatum">Pregled prisustava</a>-->
<!--  <a href="/Skola/InstruktorPocetna.jsp">Instruktor pocetna</a><br>
<a href="/Skola/AdminPocetna.jsp">Admin pocetna</a><br>
<a href="/Skola/ClanPocetna.jsp">Clan pocetna</a><br>
-->
<center>
<a href="/Skola/OSkoli.jsp">O skoli</a>
</center>



<!-- UNOS MORAS OMOGUCITI ZA ADMINA  --> 
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

<br><center>
<i>	Dobrodosli na portal Sportske Skole. <br/><br/>
	Kako biste nastavili sa radom, molimo prijavite se klikom na
<a href="/Skola/auth/loginPage">Link</a>
</i></center>

</body>
</html>