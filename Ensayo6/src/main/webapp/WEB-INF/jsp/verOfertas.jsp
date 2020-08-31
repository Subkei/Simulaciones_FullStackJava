<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Ofertas</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://bootswatch.com/4/sketchy/bootstrap.min.css">
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Listado de Ofertas para Postulantes</h1>

	<!-- Nav -->
	<ul class="nav nav-pills">
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/regPostulantes">Registro</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link active" href="${pageContext.request.contextPath}/verOfertas">Postular</a>
	  </li>	  
	</ul>
	
	<!-- Card con listado de Ofertas -->

	<!-- ForEach Ofertas -->
	<c:forEach items="${ofertas}" var="oferta">
		<div class="card border-warning mb-3">
			<div class="card-header h3"><c:out value="${oferta.titulo}"/>
				<button type="button" class="btn btn-primary">Postular!</button>
			</div>
			<div class="card-body">
				<div class="card-title d-flex justify-content-around">
					<c:out value="${oferta.reclutadores.nombreFantasia}"/>&nbsp;&nbsp;&nbsp;
					Publicado el <c:out value="${oferta.fecha}"/>&nbsp;&nbsp;&nbsp;
					Remuneración Ofrecida: <c:out value="$${oferta.salario}"/></div>
				<p class="card-text lead"><c:out value="${oferta.descripcion}"/></p>
			</div>
		</div>
	</c:forEach>

</body>
</html>