package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Reclutadores;
import cl.awakelab.modelo.ReclutadoresRepositorio;

@Service
public class ReclutadoresServicioImpl implements ReclutadoresServicio {

	@Autowired
	ReclutadoresRepositorio rr;
	
	@Override
	public List<Reclutadores> getAllReclutadores() {
		return (List<Reclutadores>) rr.findAll();
	}

	@Override
	public void addReclutadores(Reclutadores reclutadores) {
		rr.save(reclutadores);
	}

	
}
