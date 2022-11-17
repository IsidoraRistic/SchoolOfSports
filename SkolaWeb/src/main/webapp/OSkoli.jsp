<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>O SKOLI</title>
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
}

.center2 {
	
	 margin: auto;
  width: 50%;
  border: 3px solid green;
  padding: 10px;
	
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
</head>
<body><div class="center2">
<p style="font-size:360%; font-family:fantasy;">SKOLA SPORTA </p>
<div id="outPopUp"><i>
Skola sporta <b>"M.Petrovic"</b> je osnovana 2021. godine. Nalazimo se na podrucju planine Tare, poznatoj po prelepim predelima i cistom vazduhu.
Nudimo vise od 15 razlicitih sportskih disciplina.<p> Ucenike <u>delimo u grupe, juniore i seniore</u>, za svaki sport. Ucenik dobija karticu clanstva nakon upisa, a za
slucaj da zeli da se upise na vise sportova, to moze uciniti, ali ce dobiti novi ID i karticu.</p>
<p>
<b>Prijavite se za neki od sportova vec danas</b> kako biste sto pre sa nama uzivali na svezem vazduhu, vodeci zdrav zivot!</p>
</i>
</div></div>
</body>
</html>