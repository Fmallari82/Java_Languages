<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>
	</h1>
	<h3>
		Name: <c:out value="${oneLanguage.name}" />
		Creator:
		<c:out value="${oneLanguage.creator}" />
	</h3>
	<h3>
		Version:
		<c:out value="${oneLanguage.version}" />
	</h3>
	

	<form action="/languages/all" method="get">
		<input type="hidden" name="_method" value="home">     
		<input type="submit" value="Dashboard">
	</form>



	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>