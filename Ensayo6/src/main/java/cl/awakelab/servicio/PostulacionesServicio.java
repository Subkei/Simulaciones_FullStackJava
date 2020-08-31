package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Postulaciones;

public interface PostulacionesServicio {

	List<Postulaciones> getAllPostulaciones();
	void addPostulaciones(Postulaciones postulaciones);
}
