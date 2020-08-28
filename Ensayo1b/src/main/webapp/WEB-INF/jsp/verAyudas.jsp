<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ensayo Nº1</title>
	<!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/r-2.2.5/datatables.min.css"/>
    <!-- jQuery, datatable -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/r-2.2.5/datatables.min.js"></script>
    <spring:url value="/resources/js/jquery.dataTables.es.js" var="datatablesEsJS"/><script src="${datatablesEsJS}"></script>	
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Listado de Ciudades y Ayudas</h1>
	
	<!-- Tabla con campos de las Ayudas -->
	<table id="tabla" class="table table-responsive-md table-striped table-warning">
		<thead>		
			<tr>
				<th>Ciudad</th>
				<th>Tipos de Ayuda</th>
				<th>Monto</th>
			</tr>
		</thead>
		<tbody>
			<!-- ForEach Ayudas -->
			<c:forEach items="${listaayudasj}" var="ayus">
				<tr>
					<td><c:out value="${ayus.getBeneficiarios().getCiudades().getNombreciudad()}"/></td>
					<td><c:out value="${ayus.getMotivo()}"/></td>
					<td><c:out value="$${ayus.getMonto()}"/></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Form registro de Ayudas -->
	<form:form method="post" modelAttribute="ayudas" action="addAyudaSave">
		<div class="container">
			<div class="row w-50">
	           <form:label path="beneficiarios.beneficiarioid">Beneficiario</form:label>
	           <form:select path="beneficiarios.beneficiarioid" cssClass="form-control" required="required">
	               <form:option value="${listabjson}" label="---Seleccionar---"/>
	               <form:options items="${listabjson}" itemLabel="nombre" itemValue="beneficiarioid"/>
	           </form:select>
			</div>
		    <br>
		    <div class="row w-50">
		        <form:label path="monto">Monto:</form:label>
		        <form:input type="number" class="form-control" path="monto"/>
		    </div>
		    <br>
		    <div class="row w-50">
		        <form:label path="motivo">Motivo:</form:label>
		        <form:input type="text" class="form-control" path="motivo"/>
			</div>
			<br>
			<div class="row"><input type="submit" class="btn btn-primary" value="Ingresar"/></div>	
		</div>
	</form:form>
	<!-- Enlaces JSON -->
	<br>
	<a href="${pageContext.request.contextPath}/ayudasJson">(Extra)Ver Listado Ayudas JSON</a><br>
</body>
</html>