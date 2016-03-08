<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<script>
		 $(function() {
			//here datepicker-1 is fetched from id of input tag
			$( "#movieDate" ).datepicker({
				//code for formatting date while selecting
				//you can change it according to your requirement
				dateFormat:"yy-mm-dd"
			});
		 });
		</script>
</head>

<body>
	<section class="container">
		<form1:form modelAttribute="movieList" method="POST"
			class="form-horizontal">

			<fieldset>
				<legend>Enter Date to get Movies</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="movieDate">MovieList</label>
					<div class="col-lg-10">
						<%-- <fmt:parseDate pattern="yyyy-mm-dd" value="${bean.dateString}" var="movieDate" />
						<fmt:formatDate value="${movieDate}" pattern="yy-MM-dd" /> --%>
						<form1:input id="movieDate" path="movieDate" type="text"
							class="form:input-large" />
							
						<br />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Movie" />
					</div>
				</div>
			</fieldset>
		</form1:form>
	</section>

</body>
</html>