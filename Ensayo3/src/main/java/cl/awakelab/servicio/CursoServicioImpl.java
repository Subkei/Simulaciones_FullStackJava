package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Curso;
import cl.awakelab.modelo.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {

	@Autowired
	CursoRepositorio crep;
	
	@Override
	public List<Curso> getAllCurso() {
		return (List<Curso>) crep.findAll() ;
	}

	@Override
	public Curso getCursoById(int idcurso) {
		return crep.findOne(idcurso);
	}

}
