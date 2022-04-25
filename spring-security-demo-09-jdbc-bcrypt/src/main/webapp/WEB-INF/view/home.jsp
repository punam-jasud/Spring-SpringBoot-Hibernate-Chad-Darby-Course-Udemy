<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2>Welcome to Home Page!</h2></br>
	
	<hr>
	
	<!-- Display User Name and Roles -->
	User: <security:authentication property="principal.username"/>
	<br><br>
	Roles : <security:authentication property="principal.authorities"/>
	
	<br><hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders..this is for the managers -->	
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Manager Peeps)
		</p>
		<hr><br>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /systems..this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admins Meeting</a> (Only for Admin Peeps)
		</p>
		<hr><br>
	</security:authorize>
	
	<!-- Add Logout Button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>