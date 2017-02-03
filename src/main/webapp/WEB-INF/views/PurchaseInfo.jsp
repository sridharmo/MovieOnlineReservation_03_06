<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script>
	var timeout = ${clock};
	if (timeout == null)
		timeout = 50;
	function timer() {
		if (--timeout > 0) {
			document.getElementById("clockid").innerText = timeout;
			window.setTimeout("timer()", 1000);
		} else {
			alert("inside else part");
			alert("document form name :" + document.forma.name);
			document.forma.action = "/MovieReservation/movie";
			/* document.forma. = [[${purchaseInfo.movieID}]]; */
			document.forma.submit(); 
			///disable submit-button etc
		}
	}
</script>
</head>
<body onload="timer()">
	<form1:form modelAttribute="purchaseInfo" method="POST" name="forma" 
	action="/MovieReservation/purInfo" >
	Seconds remaining: <div id="clockid"></div>

		<h4>Ticket Price: ${purchaseInfo.ticketPrice}</h4>
		<br />
		<h2>Movie ID: ${purchaseInfo.movieID}</h2>
		<br />
		<h2>User ID: ${purchaseInfo.userID}</h2>
		<br />

		<form1:select path="NumberOfMovieTickets">
			<form1:option value="1">1</form1:option>
			<form1:option value="2">2</form1:option>
			<form1:option value="3">3</form1:option>
		</form1:select>

		<input type="submit" value="Buy Tickets">
	</form1:form>


</body>
</html>