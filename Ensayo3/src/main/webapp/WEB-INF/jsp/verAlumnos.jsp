<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ensayo nº3</title>
	<!-- CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/united/bootstrap.css">
	
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">${msg}</h1>

<!-- Tabla Alumnos -->
<table id="tabla" class="table table-responsive-md table-striped">
	<thead>		
	<tr>
		<th>ID Alumno</th>
		<th>Nombre Alumno</th>
		<th>Curso</th>
	</tr>
	</thead>
	<tbody>
		<!-- ForEach listado de Alumnos -->
		<c:forEach items="${Datosalumnos}" var="alumno">
			<tr>
				<td>${alumno.idalumno}</td>
				<td>${alumno.nombre}</td>
				<td>${alumno.curso.nombre}</td>			
			</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
	<a class="btn btn-primary mb-1" href="${pageContext.request.contextPath}/verCursos/${alumno.getIdcurso()}">Volver</a>

</body>
</html>