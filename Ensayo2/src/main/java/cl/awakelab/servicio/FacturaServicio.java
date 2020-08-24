package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Factura;

public interface FacturaServicio {

	 List<Factura> getAllFacturas();

	 Factura getFacturaById(int facturaid);
	 
}
