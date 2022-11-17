<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/Skola/ulogainstruktora/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/ulogainstruktora/prikaziTreninge">Prikaz zakazanih treninga</a>
<a href="/Skola/ulogainstruktora/prikaziOpremu">Prikaz dostupne opreme</a>
<a href="/Skola/ulogainstruktora/sviUcenici2">Prikaz svih ucenika 2 </a>
<a href="/Skola/ulogainstruktora/sviInstruktori2">Pregled grupa (po intruktoru)</a>

<!-- UNOS MORAS OMOGUCITI ZA ADMINA                                       -->
<a href="/Skola/unos/dodavanjeInstruktora.jsp">Unos instruktora</a>
<a href="/Skola/ulogaadmina/sviInstruktori">Prikaz instruktora</a>
<a href="/Skola/ulogaadmina/unosUcenika">Unos ucenika</a>
<a href="/Skola/ulogaadmina/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/ulogaadmina/sviInstruktori2">Pregled grupa (po intruktoru)</a>
<a href="/Skola/ulogaadmina/zakaziTrening">Zakazi trening</a>


<a href="/Skola/ulogaadmina/sviUcenici">Prikaz svih ucenika</a>


<a href="/Skola/ulogaadmina/getSviUceniciReport.pdf">Svi ucenici po grupama - izvestaj</a>
<a href="/Skola/unos/TreninziPeriod.jsp">Treninzi za uneseni period - izvestaj</a>
<a href="/Skola/ulogaadmina/prisustvaZaTreningIDatum">Pregled prisustava</a>




</body>
</html>