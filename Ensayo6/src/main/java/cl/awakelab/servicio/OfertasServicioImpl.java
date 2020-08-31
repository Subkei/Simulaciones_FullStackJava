package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Ofertas;
import cl.awakelab.modelo.OfertasRepositorio;

@Service
public class OfertasServicioImpl implements OfertasServicio{

	@Autowired
	OfertasRepositorio or;
	
	@Override
	public List<Ofertas> getAllOfertas() {
		return (List<Ofertas>) or.findAll();
	}

	@Override
	public void addOfertas(Ofertas ofertas) {
		or.save(ofertas);
	}

}
