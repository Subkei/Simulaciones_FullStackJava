package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Ofertas;

public interface OfertasServicio {

	List<Ofertas> getAllOfertas();
	void addOfertas(Ofertas ofertas);
}
