<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
</head>
<body>
	<h1>Find Flights</h1>
	<form action="findFlights" method="post">
		<pre>
			From City<input type="text" name="from" />
			To City<input type="text" name="to" />
			Departure Date<input type="text" name="Departuredate" />
			<input type="submit" value="Find" />
		</pre>
	</form>
</body>
</html>