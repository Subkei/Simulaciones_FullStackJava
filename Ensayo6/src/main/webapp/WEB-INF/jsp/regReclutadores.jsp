<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Reclutadores</title>
	<!-- CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/sketchy/bootstrap.min.css">	
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Registro de Reclutadores</h1>

	<!-- Nav -->
	<ul class="nav nav-pills">
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link active" href="${pageContext.request.contextPath}/regReclutadores">Registro</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/regOfertas">Ofertar</a>
	  </li>	
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/verPostulaciones">Postulantes</a>
	  </li>	 	    
	</ul>
	<!-- Mensaje de guardado exitoso -->
	<c:if test="${not empty msgreclutador}">
		<div class="alert alert-success my-4">${msgreclutador}</div>
	</c:if>
	<!-- Form registro de Reclutadores -->
	<form:form method="post" modelAttribute="reclutadores" action="regReclutadoresSave">
		<div class="container">
		
		    <div class="row w-50 pt-3">
		        <form:label path="idReclutador">ID Reclutador:</form:label>
		        <form:input type="number" class="form-control" path="idReclutador"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="nombreFantasia">Nombre de Fantasía:</form:label>
		        <form:input type="text" class="form-control" path="nombreFantasia"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="razonSocial">Razon Social:</form:label>
		        <form:input type="text" class="form-control" path="razonSocial"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="rut">Rut:</form:label>
		        <form:input type="text" class="form-control" path="rut"/>
			</div>
			<br>
		    <div class="row w-50">
		        <form:label path="email">Email:</form:label>
		        <form:input type="email" class="form-control" path="email"/>
			</div>
			<br>		        
			<div class="row">
				<input type="reset" class="btn btn-primary mx-5" value="Limpiar">				
				<input type="submit" class="btn btn-primary mx-5" value="Ingresar"/>
			</div>
		</div>
	</form:form>
	
	
</body>
</html>