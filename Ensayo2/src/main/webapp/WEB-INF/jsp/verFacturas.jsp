<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ensayo Nº2</title>
	<!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/r-2.2.5/datatables.min.css"/>
    <!-- jQuery, datatable -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/r-2.2.5/datatables.min.js"></script>
    <spring:url value="/resources/js/jquery.dataTables.es.js" var="datatablesEsJS"/><script src="${datatablesEsJS}"></script>	
</head>
<body class="container" style="padding: 10px">

	<h2>Listado de Facturas</h2>
	<!-- Buscar Facturas -->
	<form action="${pageContext.request.contextPath}/facturas" method="post">
		<div class="card border-light mb-3" style="max-width: 20rem;">
			<div class="card-body">
			 	<h4 class="card-title">Factura ID: </h4>
				<input class="form-control" type="number" name="txtfacturaid" placeholder="Ingrese número de factura"/><br>
				<input type="submit" value="Obtener" class="btn btn-primary" />
			</div>
		</div>
	</form>
	<!-- Desplegar Nº Factura, Cliente y Fecha -->
	<ul>
		<li>Nº Factura: ${datosFactura.facturaid}</li>
		<li>Cliente: <c:out value="${datosFactura.getCliente()}"/></li>
		<li>Fecha: <c:out value="${datosFactura.getFecha()}"/></li>
	</ul>
	<!-- Tabla con campos de Factura -->
	<table id="tabla" class="table table-responsive-md table-striped table-warning">
		<thead>		
			<tr>
				<th>Producto</th>
				<th>Precio</th>
				<th>Cantidad</th>
			</tr>
		</thead>
		<tbody>
		<!-- ForEach detallefactura -->
		<c:forEach items="${detalleFactura}" var="detfactura">
			<tr>
				<td><c:out value="${detfactura.getProducto().getNombre()}"/></td>
				<td>$<c:out value="${detfactura.getProducto().getValor()}"/></td>
				<td><c:out value="${detfactura.cantidad}"/></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<!-- Factura Subtotal, Impuesto y Total -->
	<ul class="list-group w-50 p-3">
		<li class="list-group-item">Subtotal: <c:out default="$" value="$${datosFactura.getSubtotal()}"/></li>
		<li class="list-group-item">Impuesto: <c:out default="$" value="$${datosFactura.getImpuesto()}"/></li>
		<li class="list-group-item list-group-item-primary">Total: <c:out default="$" value="$${datosFactura.getTotal()}"/></li>
	</ul>
	<!-- Enlaces JSON -->
	<br>
	<a href="${pageContext.request.contextPath}/verFacturasJson">Ver Listado de Facturas JSON</a><br>
	<a href="${pageContext.request.contextPath}/verProductosCategoriaJson/1">1 Listado de Productos por Categoria JSON</a><br>
	<a href="${pageContext.request.contextPath}/verProductosCategoriaJson/2">2 Listado de Productos por Categoria JSON</a><br>
	<a href="${pageContext.request.contextPath}/verProductosCategoriaJson/3">3 Listado de Productos por Categoria JSON</a><br>
</body>
</html>