<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<p> Your Gold: </p>
			<p class="display-box">${golds}</p>
		</div>
		<div class="row">
			<form class="box" action="/submitGold">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" value="farm" name="place"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form class="box" action="/submitGold">
				<h3>Cave</h3>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" value="cave" name="place"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form class="box" action="/submitGold">
				<h3>House</h3>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" value="house" name="place"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form class="box" action="/submitGold">
				<h3>Quest</h3>
				<p>(earns/takes 0-50 gold)</p>
				<input type="hidden" value="quest" name="place"/>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
		<div>
			<p>Activities</p>
			<div class="display-box">
			${output}
			</div>
		</div>
	</div>
</body>
</html>