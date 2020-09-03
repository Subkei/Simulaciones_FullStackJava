package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Alumno;
import cl.awakelab.modelo.AlumnoRepositorio;

@Service
public class AlumnoServicioImpl implements AlumnoServicio {

	@Autowired
	AlumnoRepositorio arep;
	
	@Override
	public List<Alumno> getAllAlumnos() {
		return (List<Alumno>) arep.findAll();
	}

	@Override
	public Alumno getAlumnoById(int idalumno) {
		return arep.findOne(idalumno);
	}

}
