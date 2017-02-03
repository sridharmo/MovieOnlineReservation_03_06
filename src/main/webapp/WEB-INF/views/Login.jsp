<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
 
    
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>Home Page</title>


<body>
<div class="container">
  <form:form method="POST" action="Login" commandName="newUser">

			<%
				if (session.getAttribute("PasswordIncorrect") == "true") {
			%>
			<tr>
				<label class="control-label col-lg-2 col-lg-2" for="password">
					<spring:message code="NewUser.Password.IsIncorrect" />
				</label>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="button"
					name="action" value="retrievePassWord" /></td>
			</tr>
			<%
				}
			%>
			
			<%
				if (session.getAttribute("RetryOrRegister") == "true") {
			%>
			<tr>
				<label class="control-label col-lg-2 col-lg-2" for="password">
					<spring:message code="Retry.Or.Register" />
				</label>
			</tr>
			
			<%
			
				}
			%>
			
			<%
				if (session.getAttribute("PasswordRetrieved") == "true") {
			%>
			<tr>
				<label class="control-label col-lg-2 col-lg-2" for="password">
					<spring:message code="Password.Retrieved" />
				</label>
			</tr>
			
			<%
			
				}
			%>
			
			
			
			<tr>
			
			
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="passWord">Password</form:label></td>
        <td><form:input path="passWord" /></td>
    </tr>
    <tr>
    <td colspan="2">
            <input type="submit" name="action" value="Submit"/>
        </td>
        </tr>
	<br>
			<form:radiobutton path="register" value="register" />
             			Register	<br />

			

			</table>  
</form:form>
 
</div>
 </body>
</head>
</html>
