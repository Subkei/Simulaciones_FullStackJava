package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Curso;

public interface CursoServicio {

	List<Curso> getAllCurso();
	Curso getCursoById(int idcurso);
}