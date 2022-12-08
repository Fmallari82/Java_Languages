<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
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
		<h1 class="text-center">Save Travels</h1>

		<form action="/languages/search">
			<input type="text" name="search" /> <input type="submit"
				value="Search" />
		</form>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allLanguage}" var="language">
					<tr>
						<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
						<td><c:out value="${language.creator}" /></a></td>
						<td><c:out value="${language.version}" /></a></td>
						<td>
							<div class="d-flex">
								<form action="/languages/edit/${language.id}" method="get">
									    <input type="hidden" name="_method" value="edit">
									    <input type="submit" value="Edit">
								</form>
								<form action="/languages/${language.id}" method="post">
									    <input type="hidden" name="_method" value="delete">
									    <input type="submit" value="Delete">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Add a Language</h2>
		<form:form action="/languages/all" method="post" modelAttribute="language">
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
				<form:input path="version" />
			</div>
		
			<input type="submit" value="Submit" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>