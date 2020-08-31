package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Postulaciones;
import cl.awakelab.modelo.PostulacionesRepositorio;

@Service
public class PostulacionesServicioImpl implements PostulacionesServicio {

	@Autowired
	PostulacionesRepositorio pr;

	@Override
	public List<Postulaciones> getAllPostulaciones() {
		return (List<Postulaciones>) pr.findAll();
	}

	@Override
	public void addPostulaciones(Postulaciones postulaciones) {
		pr.save(postulaciones);
	}
}
