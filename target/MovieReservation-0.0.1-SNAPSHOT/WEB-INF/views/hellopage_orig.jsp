<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<title>MovieList</title>
</head>
<body>
 	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>MovieList</h1>
				<p>Enter Date</p>
			</div>
		</div>
	</section>
	
	
	<%-- 	<form:form modelAttribute="movieBean" > --%> 
		<%-- <form method = "POST"  action="/movieList" modelAttribute="movieBean"> --%>
		<form commandName="movie" action="/movieList"   method = "post" modelAttribute="movieBean" >
		 		movieDate: <input type="text" path="movieDate"/>
  				<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Submit"  path="Submit"/>
			<!-- <fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Enter
						Movie Date</label>
					<div class="col-lg-10">
						<input id="movieDate" path="movieDate" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Submit" />
					</div>
				</div>
			</fieldset> -->
		</form> 
	
</body>
</html>