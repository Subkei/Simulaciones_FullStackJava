package cl.awakelab.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import cl.awakelab.modelo.Ofertas;
import cl.awakelab.modelo.Postulaciones;
import cl.awakelab.modelo.Reclutadores;
import cl.awakelab.servicio.OfertasServicio;
import cl.awakelab.servicio.PostulacionesServicio;
import cl.awakelab.servicio.ReclutadoresServicio;

@Controller
public class ReclutadoresControlador {

	static Logger log = Logger.getLogger(ReclutadoresControlador.class.getName());
	
	@Autowired
	PostulacionesServicio ps;
	@Autowired
	OfertasServicio os;
	@Autowired
	ReclutadoresServicio rs;
	
	//Inicio
    @RequestMapping("/inicio")    
    public String getInicio(Model m){
        log.info("Página principal");
        return "index";
    }

	//Listado de Postulaciones
    @RequestMapping("/verPostulaciones")    
    public String getAllPostulacionesJson(Model m){    
    		
    //Consumir Oferta Json
    final String uriO = "http://localhost:8181/ensayo6/ofertasJson";    
    RestTemplate restTemplateO = new RestTemplate();

    ResponseEntity<List<Ofertas>> postResponseO =
            restTemplateO.exchange(uriO,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Ofertas>>() {
                });
    List<Ofertas> listofertas = postResponseO.getBody();
	    m.addAttribute("ofertas", listofertas);
	    System.out.println("Ofertas: " + listofertas.size());
    	
//    	List<Ofertas> listofertas = os.getAllOfertas();
//    	m.addAttribute("ofertas", listofertas);
	    
    // Consumir Postulaciones Json
    final String uriP = "http://localhost:8181/ensayo6/postulacionesJson";    
    RestTemplate restTemplateP = new RestTemplate();
    
    ResponseEntity<List<Postulaciones>> postResponseP =
            restTemplateP.exchange(uriP,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Postulaciones>>() {
                });
    List<Postulaciones> postulaciones = postResponseP.getBody();
	    m.addAttribute("postulaciones", postulaciones);
	    System.out.println("Cantidad: " + postulaciones.size());
	    
        log.info("Listado de postulaciones");
        return "verPostulaciones";
    }
    
    //Formulario registro Reclutadores
    @RequestMapping("/regReclutadores")
    public String addReclutadores(Model m) {
    	m.addAttribute("reclutadores", new Reclutadores());
    	log.info("Ingreso a formulario de registro de reclutadores");
    	return "regReclutadores";
    }
    
    //Guardar formulario Reclutadores
    @PostMapping("/regReclutadoresSave")    
    public String addReclutadoresSave(@ModelAttribute("reclutadores") @Validated Reclutadores reclutadores, BindingResult result, Model m){    
        
    	if(result.hasErrors()) {
    		return "regReclutadores";
    	}
    	else {
    		rs.addReclutadores(reclutadores);
    		String mensaje = "El reclutador "+ reclutadores.getNombreFantasia() +" ha sido ingresado con exito." ;
    		m.addAttribute("msgreclutador", mensaje);
    	}
        log.info("Reclutador con ID: " + reclutadores.getIdReclutador() + " ha sido creado.");
        return "regReclutadores";
    }
    
    //Formulario registro Ofertas
    @RequestMapping("/regOfertas")
    public String addOfertas(Model m) {
    	List<Reclutadores> listreclutadores = rs.getAllReclutadores();
    	m.addAttribute("listareclutadores", listreclutadores);
    	m.addAttribute("ofertas", new Ofertas());
    	log.info("Ingreso a formulario de registro de ofertas");
    	return "regOfertas";
    }
    
    //Guardar formulario Ofertas
    @PostMapping("/regOfertasSave")    
    public String addOfertasSave(@ModelAttribute("ofertas") @Validated Ofertas ofertas, BindingResult result, Model m){    
        
    	if(result.hasErrors()) {
    		return "regOfertas";
    	}
    	else {
    		os.addOfertas(ofertas);
    		String mensaje = "Oferta de "+ ofertas.getTitulo() +" ha sido ingresada con exito." ;
    		m.addAttribute("msgoferta", mensaje);
    	}
        log.info("Oferta con ID: " + ofertas.getIdOferta() + " ha sido creada.");
        return "regOfertas";
    }    
}
