package cl.awakelab.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.modelo.Ofertas;
import cl.awakelab.modelo.Postulaciones;
import cl.awakelab.servicio.OfertasServicio;
import cl.awakelab.servicio.PostulacionesServicio;

@RestController
public class RestControlador {

	@Autowired
	OfertasServicio os;
	@Autowired
	PostulacionesServicio ps;
	
	//Listado de Postulaciones
	@GetMapping(value= "/postulacionesJson", headers = "Accept=application/json")
	public List<Postulaciones> getAllPostulaciones(){
		return ps.getAllPostulaciones();
	}
	
	//Listado de Ofertas
	@GetMapping(value= "/ofertasJson", headers = "Accept=application/json")
	public List<Ofertas> getAllOfertas(){
		return os.getAllOfertas();
	}
		
}
