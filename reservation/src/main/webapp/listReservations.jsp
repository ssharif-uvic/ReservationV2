<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, model.Reservation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Please make a selection by using the radio a button.</h1>
	<form action="/reservation/controller" method="post">
		<input type="hidden" name="requestType" value="processReservation">
	<table border="2">
		<tr>
			<td> Selection	</td>
			<td> First name	</td>
			<td>Last name</td>
			<td>Country	</td>
			<td>City</td>
			<td>Airport</td>
			<td>User Type</td>
			<td>Reservation Status</td>
			<td>Reservation Date</td>
			<td>Travel Date</td>
		</tr>
		<c:forEach items="${sessionScope.reservations}" var="reservation">

		<tr>
			<td><input type="radio" name="selection" id="selection" value="${reservation.reservationId}"  />	</td>
			<td><c:out value="${reservation.person.firstName}"></c:out></td>
			<td><c:out value="${reservation.person.lastname}"></c:out></td>
			<td><c:out value="${reservation.destination.country}"></c:out></td>
			<td><c:out value="${reservation.destination.city}"></c:out></td>
			<td><c:out value="${reservation.destination.airport}"></c:out></td>
			<td><c:out value="${reservation.person.userType}"></c:out></td>
			<td><c:out value="${reservation.reservationStatus}"></c:out></td>
			<td><c:out value="${reservation.reservationDate}"></c:out></td>
			<td><c:out value="${reservation.travelDate}"></c:out></td>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="Make the reservation"  >
	</form>


</body>
</html>
