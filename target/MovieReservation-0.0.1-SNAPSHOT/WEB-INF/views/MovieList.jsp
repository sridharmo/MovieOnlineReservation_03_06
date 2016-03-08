<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>MovieList</title>
</head>
<body>
	<section>
		<div style="float: left">
			<a href="AddMovie?AddMovie ">AddMovie</a>
		</div>
		<div style="float: right">
			<a href="movie?purchase ">Purchase</a>
		</div>
		<div style="float: middle">
			<a href="NewUser1?NewUser1 ">NewUser</a>
		</div>
		<div class="jumbotron">
			<div class="container">
				<h1>MovieList</h1>
				<p>Selected Movie DAte</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${MovieList}" var="movieList">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<div class="col-md-5">
								<img
									src="<c:url value="/resource/images/${movieList.movieName}.jpg">
						</c:url>"
									alt="image" style="width: 100%" />
							</div>
							<h3>${movieList.movieDate}</h3>
							</br>
							<h4>${movieList.movieName }</h4>
							</br>
							<h4>${movieList.movieDuration }</h4>
							</br>
							<div class="caption">
								<div class="col-md-5">
									<c:forEach items="${movieList.timeInfo}" var="movieTimeInfo">
										<h4>${movieTimeInfo}</h4>
										</br>
								</div>
							</div>
			</c:forEach>
		</div>
		</div>
		</div>
		</c:forEach>
		</div>
	</section>
</body>
</html>