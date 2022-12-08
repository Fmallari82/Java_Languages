<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container m3">
		<h1>Edit Language</h1>
		<form:form action="/languages/edit/process/${language.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
		<div class="form-group">
			<form:label path="name">Name: </form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>

		<div class="form-group">
			<form:label path="creator">Creator: </form:label>
			<form:errors path="creator" />
			<form:input path="creator" />
		</div>
		<div class="form-group">
			<form:label path="version">Version: </form:label>
			<form:errors path="version" />
			<form:input  path="version" />
		</div>

		<input type="submit" value="Submit" />
	</form:form>
	
<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>