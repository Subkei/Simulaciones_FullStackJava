package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.CiudadesRepositorio;
import cl.awakelab.modelo.Ciudades;

@Service
public class CiudadesServicioImpl implements CiudadesServicio{

	@Autowired
	CiudadesRepositorio dapCiu;
	
	@Override
	public List<Ciudades> getAllCiudades() {
		return (List<Ciudades>) dapCiu.findAll();
	}

	@Override
	public Ciudades getCiudadesById(int ciudadid) {
		return dapCiu.findOne(ciudadid);
	}

}
