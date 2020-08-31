package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Postulantes;
import cl.awakelab.modelo.PostulantesRepositorio;

@Service
public class PostulantesServicioImpl implements PostulantesServicio {

	@Autowired
	PostulantesRepositorio pr;

	@Override
	public List<Postulantes> getAllPostulantes() {
		return (List<Postulantes>) pr.findAll();
	}

	@Override
	public void addPostulantes(Postulantes postulantes) {
		pr.save(postulantes);
	}
}
