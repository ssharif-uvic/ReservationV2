<html>
<body>
<h2>Choose what you want to do please</h2>

	<form action="/reservation/controller" method="post">
	    <input type="hidden" name="requestType" value="newReservation">
		<input type="submit" value="New Reservation"  >
	</form>
	
	<form action="/reservation/controller" method="post">
		<input type="hidden" name="requestType" value="listReservations">
		<input type="submit" value="List Reservations"  >
	</form>
	
</body>
</html>
