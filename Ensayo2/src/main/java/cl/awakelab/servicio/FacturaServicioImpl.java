package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Factura;
import cl.awakelab.modelo.FacturaRepositorio;

@Service
public class FacturaServicioImpl implements FacturaServicio {

	@Autowired
	FacturaRepositorio factrep;
	
	@Override
	public List<Factura> getAllFacturas() {
		return (List<Factura>) factrep.findAll();
	}

	@Override
	public Factura getFacturaById(int facturaid) {
		return factrep.findOne(facturaid);
	}

}
