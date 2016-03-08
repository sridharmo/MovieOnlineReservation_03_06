<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 --%>
 <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>

</head>

<body>
	<section class="container">
		<form1:form modelAttribute="existingUser" method="POST" class="form-horizontal">

			<fieldset>
				<legend>Enter Date to get Movies</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Email</label>
					<div class="col-lg-10">
						<form1:input id="email" path="email" type="text"
							class="form:input-large" />
							<form1:errors path="email" cssClass="text-danger"/>
						<br />
					</div>
					<label class="control-label col-lg-2 col-lg-2" for="passWord">passWord</label>
					<div class="col-lg-10">
						<form1:input id="password" path="password" type="text"
							class="form:input-large" />
						<br />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Signin" />
					</div>
				</div>
			</fieldset>
		</form1:form>
	</section>

</body>
</html>