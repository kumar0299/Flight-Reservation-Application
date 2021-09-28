<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h2>Flight Details</h2>
	Flight Number: ${flight.flightNumber}
	</br> operating Airlines: ${flight.operatingAirlines}
	</br> Departure City: ${flight.departureCity}
	</br> Arrival City: ${flight.arrivalCity}
	</br> Date Of Departure: ${flight.dateOfDeparture}
	</br> Estimated Departure Time: ${flight.estimatedDepartureTime}
	</br>
	<h2>Enter Passenger Details</h2>
	<form action="" method="post">
		<pre>
			First Name<input type="text" name="firstName" />
			Last Name<input type="text" name="lastName" />
			Middle Name<input type="text" name="middleName" />
			Email Id<input type="text" name="email" />
			Phone<input type="text" name="phone" />
			<input type="hidden" name="flightId" value = "${flight.id}"/>
			<input type="submit" value="complete Reservation" />
		</pre>
	</form>
</body>
</html>