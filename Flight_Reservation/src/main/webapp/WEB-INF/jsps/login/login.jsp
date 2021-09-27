<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
</head>
<body>
	<h1>Login here...</h1>
	<a href="showRegistration">Click me to create an account</a>
	<form action="verifylogin" method="post">
		<pre>
			Email Id<input type="text" name="email" />
			Password<input type="password" name="password" />
			<input type="submit" value="LogIn" />
		</pre>
	</form>
	${error}
</body>
</html>