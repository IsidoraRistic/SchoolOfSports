<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<style>
.sidenav2{
            text-align:center;
           <!-- top: 0px;
            margin: auto;
  width: 100%;
  border: 3px solid #73AD21;
  padding: 10px;
	background-color:#23d5ab;
	text-align:center;-->
       }
       
       
       html {
	height: 100%;
	/* max-height: 600px; */
	width: 1000px;
	background-color: hsla(200,40%,30%,.4);
	background-image:		
		url('https://78.media.tumblr.com/cae86e76225a25b17332dfc9cf8b1121/tumblr_p7n8kqHMuD1uy4lhuo1_540.png'), 
		url('https://78.media.tumblr.com/66445d34fe560351d474af69ef3f2fb0/tumblr_p7n908E1Jb1uy4lhuo1_1280.png'),
		url('https://78.media.tumblr.com/8cd0a12b7d9d5ba2c7d26f42c25de99f/tumblr_p7n8kqHMuD1uy4lhuo2_1280.png'),
		url('https://78.media.tumblr.com/5ecb41b654f4e8878f59445b948ede50/tumblr_p7n8on19cV1uy4lhuo1_1280.png'),
		url('https://78.media.tumblr.com/28bd9a2522fbf8981d680317ccbf4282/tumblr_p7n8kqHMuD1uy4lhuo3_1280.png');
	background-repeat: repeat-x;
	background-position: 
		0 20%,
		0 100%,
		0 50%,
		0 100%,
		0 0;
	background-size: 
		2500px,
		800px,
		500px 200px,
		1000px,
		400px 260px;
	animation: 50s para infinite linear;
	}

@keyframes para {
	100% {
		background-position: 
			-5000px 20%,
			-800px 95%,
			500px 50%,
			1000px 100%,
			400px 0;
		}
	}
 </style>
<title>POCETNA STRANICA</title>

</head>
<body style="text-align:center;">
<center><div class="sidenav2">
<a href="/Skola/OSkoli.jsp">O skoli</a>
<security:authorize access="hasRole('ROLE_INSTRUKTOR')">
<a href="/Skola/ulogainstruktora/sveGrupeMesta">Prikaz svih grupa</a>

<a href="/Skola/ulogainstruktora/prikaziTreninge">Prikaz zakazanih treninga</a>
<a href="/Skola/ulogainstruktora/prikaziOpremu">Prikaz dostupne opreme</a>
<a href="/Skola/ulogainstruktora/sviUcenici2">Prikaz svih ucenika </a>
<a href="/Skola/ulogainstruktora/sviInstruktori2">Pregled grupa (po instruktoru)</a>
<a href="/Skola/auth/logout">Odjava</a>
</security:authorize>

<!-- UNOS MORAS OMOGUCITI ZA ADMINA  --> 
<security:authorize access="hasRole('ROLE_ADMIN')">                                    
<a href="/Skola/unos/dodavanjeInstruktora.jsp">Unos instruktora</a>
<a href="/Skola/ulogaadmina/sviInstruktori">Prikaz instruktora</a>
<a href="/Skola/ulogaadmina/unosUcenika">Unos ucenika</a>
<a href="/Skola/ulogaadmina/sveGrupeMesta">Prikaz grupa</a>
<a href="/Skola/ulogaadmina/sviInstruktori2">Pregled grupa (po instruktoru)</a>
<a href="/Skola/ulogaadmina/zakaziTrening">Zakazi trening</a>

<a href="/Skola/ulogaadmina/getDiscipline">Kreiranje nove grupe</a>
<a href="/Skola/ulogaadmina/sviUcenici">Prikaz svih ucenika</a>


<a href="/Skola/ulogaadmina/getSviUceniciReport.pdf">Svi ucenici po grupama - IZVESTAJ</a>
<a href="/Skola/unos/TreninziPeriod.jsp">Treninzi za uneseni period - IZVESTAJ</a>
<a href="/Skola/ulogaadmina/prisustvaZaTreningIDatum">Pregled prisustava</a>
<a href="/Skola/auth/logout">Odjava</a>
</security:authorize>



<security:authorize access="hasRole('ROLE_CLAN')">      
<a href="/Skola/ulogaclana/izaberiTestiranje"><i>Prikaz rezultata testiranja</i></a>
<a href="/Skola/ulogaclana/prijavaZaSport"><i>Prijava za sport</i></a>

<a href="/Skola/ulogaclana/prisustvaZaTreningIDatum"><i>Pregled prisustava</i></a>
<a href="/Skola/auth/logout"><i>Odjava</i></a>
</security:authorize></center></div>
<br>
	
<p style="font-size:360%; font-family:fantasy;">
<i>Welcome, 
<security:authorize access="isAuthenticated()">
     <security:authentication property="principal.username" /> 
</security:authorize>
</i> </p>
</body>
</html>