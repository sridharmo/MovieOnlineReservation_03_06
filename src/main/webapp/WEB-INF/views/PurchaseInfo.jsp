<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <c:url var="saveUrl" value="/purchaseInfo" /> -->
	<form1:form modelAttribute="purchaseInfo" method="POST" class="form-horizontal"  >
	<%-- <h4>${purchaseInfo.TicketPrice}</h4></br> --%>
  <select name="NumberOfMovieTickets">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
  </select>
  <input type="submit" value="Buy Tickets">
</form1:form>
</body>
</html>