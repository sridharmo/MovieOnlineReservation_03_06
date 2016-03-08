<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movies to Database as Admin</title>
</head>
<body>
	<form1:form modelAttribute="movieList" method="POST" 
		class="form-horizontal" enctype="multipart/form-data">

		<fieldset>
			<legend>Add Movies to Database as Admin</legend>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="movieDate">MovieDate</label>
				<div class="col-lg-10">
					<form1:input id="movieDate" path="movieDate" type="text"
						class="form:input-large" />
					<br />
				</div>
				<label class="control-label col-lg-2 col-lg-2" for="movieName">MovieName</label>
				<div class="col-lg-10">
					<form1:input id="movieName" path="movieName" type="text"
						class="form:input-large" />
					<br />
				</div>
				<label class="control-label col-lg-2 col-lg-2" for="movieDuration">MovieDuration</label>
				<div class="col-lg-10">
					<form1:input id="movieDuration" path="movieDuration" type="text"
						class="form:input-large" />
					<br />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2" for="movieImage"> <spring:message
						code="addProdcut.form.productImage.label" /> </label>
				<div class="col-lg-10">
					<form1:input id="movieImage" path="movieImage"  name="movieImageFileName" type="file"
						class="form:input-large" />
						<br/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="addMovie" />
				</div>
			</div>
		</fieldset>
	</form1:form>
</body>
</html>