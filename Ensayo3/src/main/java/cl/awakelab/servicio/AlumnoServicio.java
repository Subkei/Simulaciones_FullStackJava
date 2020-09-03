package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Alumno;

public interface AlumnoServicio {

	List<Alumno> getAllAlumnos();
	Alumno getAlumnoById(int idalumno);
}
