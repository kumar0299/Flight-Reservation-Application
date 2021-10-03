<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h2>Reservation Details...</h2>
	Passenger name : ${reservation.getPassenger().getFirstName()}
	</br> Passenger Email : ${reservation.getPassenger().getEmail()}
	</br> Passenger phone : ${reservation.getPassenger().getPhone()}
	</br> Operating Airline : ${reservation.getFlight().getOperatingAirlines()}
	</br> Flight Number : ${reservation.getFlight().getFlightNumber()}
	</br> Departure City : ${reservation.getFlight().getDepartureCity()}
	</br> Arrival City : ${reservation.getFlight().getArrivalCity()}
	</br> Date Of Departure : ${reservation.getFlight().getDateOfDeparture()}
	</br>
	<h2>Update No. of bags and Status</h2>
	<form action="CheckInToconfirm" method="post">
		<pre>
		Reservation ID<input type="text" name="id" value="${reservation.getId()}" readonly />
		Number of bags<input type="text" name="numberOfBags" />
		<input type="submit" value="confirm" />
		</pre>
	</form>
</body>
</html>