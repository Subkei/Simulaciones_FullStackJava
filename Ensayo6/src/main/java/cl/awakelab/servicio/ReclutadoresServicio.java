package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Reclutadores;

public interface ReclutadoresServicio {

	List<Reclutadores> getAllReclutadores();
	void addReclutadores(Reclutadores reclutadores);
}
