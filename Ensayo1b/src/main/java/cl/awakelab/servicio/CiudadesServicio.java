package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Ciudades;

public interface CiudadesServicio {

	List<Ciudades> getAllCiudades();
	Ciudades getCiudadesById(int ciudadid);
}
