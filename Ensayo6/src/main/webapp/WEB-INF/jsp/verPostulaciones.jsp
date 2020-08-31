<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Postulantes</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://bootswatch.com/4/sketchy/bootstrap.min.css">
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Listado de Postulantes</h1>

	<!-- Nav -->
	<ul class="nav nav-pills">
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/regReclutadores">Registro</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/regOfertas">Ofertar</a>
	  </li>	
	  <li class="nav-item">
	    <a class="nav-link active" href="${pageContext.request.contextPath}/verPostulaciones">Postulantes</a>
	  </li>	 	    
	</ul>
	
	<!-- Card con listado de Ofertas -->

	<!-- ForEach Postulantes -->
	<c:forEach items="${ofertas}" var="oferta">
		<div class="card border-warning mb-3">
			<div class="card-header h3"><c:out value="${oferta.titulo}"/></div>
			<div class="card-body">
				<div class="card-title d-flex justify-content-around">
					Postulaciones: <c:out value="${oferta.postulaciones.size()}"/>&nbsp;&nbsp;&nbsp;
					Publicado el <c:out value="${oferta.fecha}"/>&nbsp;&nbsp;&nbsp;
					Remuneración Ofrecida: <c:out value="$${oferta.salario}"/></div>		
				<div class="card-text">
					<ol>
						<!-- ForEach Postulantes -->
						<c:forEach items="${oferta.postulaciones}" var="postulacion">
							 <li>
 								 <c:out value="${postulacion.postulantes.nombre}"/>
								 <c:out value="${postulacion.postulantes.apellido}"/>:
								 <p class="lead"><c:out value="${postulacion.postulantes.resumen}"/></p>
							 </li>
						</c:forEach>
					</ol>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>