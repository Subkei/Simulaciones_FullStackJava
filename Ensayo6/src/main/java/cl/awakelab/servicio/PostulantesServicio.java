package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Postulantes;

public interface PostulantesServicio {

	List<Postulantes> getAllPostulantes();
	void addPostulantes(Postulantes postulantes);
}
