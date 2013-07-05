<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new user</title>
</head>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/user/create.html">

		User email:
		<form:input path="user.email" />
		<br> User password:
		<form:password path="user.password" />
		<br>
		<input type="submit" value="Create" />
		

	</form>
</body>
</html>