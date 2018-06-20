<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#travelDate" ).datepicker({
      showOtherMonths: true,
      selectOtherMonths: true
    });
  } );
  </script>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="/reservation/controller" method="post">
    	<input type="hidden" name="requestType" value="addReservation">
        <table cellpadding="3pt">
            <tr>
                <td>First Name :</td>
                <td><input type="text" name="firstName" size="30" /></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lastName" size="30" /></td>
            </tr>
 
            <tr>
                <td>Country :</td>
                <td><input type="text" name="country" size="30" /></td>
            </tr>
            <tr>
                <td>City :</td>
                <td><input type="text" name="city" size="30" /></td>
            </tr>
            <tr>
                <td>Airport :</td>
                <td><input type="text" name="airport" size="30" /></td>
            </tr>
            <tr>
                <td>City :</td>
                <td><input type="text" name="city" size="30" /></td>
            </tr>
            <tr>
                <td>Travel Date :</td>
                <td><input type="text" name="travelDate" id="travelDate" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Add Reservation" />
    </form>
</body>
</html>