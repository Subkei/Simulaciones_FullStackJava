<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Ofertas</title>
	<!-- CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/sketchy/bootstrap.min.css">	
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Registro de Ofertas</h1>

	<!-- Nav -->
	<ul class="nav nav-pills">
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/regReclutadores">Registro</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link active" href="${pageContext.request.contextPath}/regOfertas">Ofertar</a>
	  </li>	
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.request.contextPath}/verPostulaciones">Postulantes</a>
	  </li>	 	    
	</ul>
	<!-- Mensaje de guardado exitoso -->
	<c:if test="${not empty msgoferta}">
		<div class="alert alert-success my-4">${msgoferta}</div>
	</c:if>
	<!-- Form registro de Reclutadores -->
	<form:form method="post" modelAttribute="ofertas" action="regOfertasSave">
		<div class="container">
		    <div class="row w-50 pt-3">
		        <form:label path="idOferta">ID Oferta:</form:label>
		        <form:input type="number" class="form-control" path="idOferta"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="fecha">Fecha:</form:label>
		        <form:input type="date" class="form-control" path="fecha"/>
		    </div>
		    <br>				
		    <div class="row w-50">
		        <form:label path="titulo">Titulo:</form:label>
		        <form:input type="text" class="form-control" path="titulo"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="salario">Salario Ofertado:</form:label>
		        <form:input type="text" class="form-control" path="salario"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="descripcion">Descripción de la Oferta:</form:label>
		        <form:textarea type="text" class="form-control" path="descripcion"/>
			</div>
			<br>
			<div class="row w-50">
	           <form:label path="reclutadores.idReclutador">Reclutador</form:label>
	           <form:select path="reclutadores.idReclutador" cssClass="form-control" required="required">
	               <form:option value="${listareclutadores}" label="---Seleccionar---"/>
	               <form:options items="${listareclutadores}" itemLabel="nombreFantasia" itemValue="idReclutador"/>
	           </form:select>
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