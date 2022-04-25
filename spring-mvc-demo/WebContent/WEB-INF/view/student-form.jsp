<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
	Student First Name : <form:input path = "firstName" /><br><br>
	Student Last Name : <form:input path = "lastName" /><br><br>
	Country : <form:select path="country">
				<form:options items="${student.countryOptions}" />
			 </form:select>
			 <br><br>
	Favourite Language : 
	Java<form:radiobutton path="language" value="Java"/>
	C#<form:radiobutton path="language" value="C#"/>
	PHP<form:radiobutton path="language" value="PHP"/>
	Ruby<form:radiobutton path="language" value="Ruby"/>
			 <br><br>
	Operating systems:
	Windows<form:checkbox path="operatingSystems" value="Windows"/>
	Linux<form:checkbox path="operatingSystems" value="Linux"/>
	Mac<form:checkbox path="operatingSystems" value="Mac"/>		 
			 <br><br>
	<input type="submit" value="Submit">
	
	</form:form>
</body>
</html>