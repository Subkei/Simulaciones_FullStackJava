<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ensayo nº3</title>
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/united/bootstrap.css">
</head>
<body class="container" style="padding: 10px;">
	<h1 class="display-4">Listado de Cursos</h1>

<!-- Tabla Cursos -->
<table id="tabla" class="table able-responsive-md table-striped">
	<thead>		
	<tr>
		<th>ID Curso</th>
		<th>Nombre curso</th>
		<th># Alumnos por Curso</th>
		<th>Acciones</th>
	</tr>
	</thead>
	<tbody>
		<!-- ForEach listado Cursos -->
		<c:forEach items="${listarcursos}" var="cursos">
			<tr>
				<td>${cursos.getIdcurso()}</td>
				<td>${cursos.getNombre()}</td>
				<td>Hay ${cursos.alumno.size()} alumnos</td>				
				<td>
					<a class="btn btn-info mb-1" href="${pageContext.request.contextPath}/verAlumnos/${cursos.getIdcurso()}">Ver Alumnos del Curso</a>&nbsp;
					<a class="btn btn-warning mb-1" href="${pageContext.request.contextPath}/verAlumnosCursoJson/${cursos.getIdcurso()}">Ver Alumnos del Curso Json</a>					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
	<a class="btn btn-primary mb-1" href="${pageContext.request.contextPath}/verAlumnos">Listar todos los Alumnos</a>
</body>
</html>