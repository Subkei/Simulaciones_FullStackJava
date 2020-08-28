package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Ayudas;

public interface AyudasServicio {

	List<Ayudas> getAllAyudas();
	Ayudas getAyudasById(int ayudaid);
	void addAyudas(Ayudas ayudas);
}
