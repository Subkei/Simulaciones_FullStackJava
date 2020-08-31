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
import cl.awakelab.modelo.Postulantes;
import cl.awakelab.servicio.OfertasServicio;
import cl.awakelab.servicio.PostulantesServicio;

@Controller
public class PostulantesControlador {

	static Logger log = Logger.getLogger(PostulantesControlador.class.getName());
	
	@Autowired
	PostulantesServicio ps;
	@Autowired
	OfertasServicio os;
    
	//Listado de Ofertas
    @RequestMapping("/verOfertas")    
    public String getAllOfertasJson(Model m){    
    		
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
	    
        log.info("Listado de Ofertas");
        return "verOfertas";
    } 
    
    //Formulario registro Postulantes
    @RequestMapping("/regPostulantes")
    public String addPostulantes(Model m) {
    	m.addAttribute("postulantes", new Postulantes());
    	log.info("Ingreso a formulario de registro de postulantes");
    	return "regPostulantes";
    }
    
    //Guardar formulario Postulantes
    @PostMapping("/regPostulantesSave")    
    public String addPostulantesSave(@ModelAttribute("postulantes") @Validated Postulantes postulantes, BindingResult result, Model m){    
        
    	if(result.hasErrors()) {
    		return "regPostulantes";
    	}
    	else {
    		ps.addPostulantes(postulantes);
    		String mensaje = "El postulante "+ postulantes.getNombre() + " " + postulantes.getApellido() + " ha sido ingresado con exito." ;
    		m.addAttribute("msgpostulante", mensaje);
    	}
        log.info("Postulante con ID: " + postulantes.getIdPostulante() + " ha sido creado.");
        return "regPostulantes";
    }
}
