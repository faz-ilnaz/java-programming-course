<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
		</tr>
		<c:if test="${not empty lists}">
			<c:forEach var="student" items="${lists}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="<c:url value='/'/>">Add new contact</a></td>
			</tr>
		</c:if>
	</table>
</body>
</html>