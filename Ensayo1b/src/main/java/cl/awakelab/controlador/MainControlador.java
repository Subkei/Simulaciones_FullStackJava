package cl.awakelab.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import cl.awakelab.modelo.Ayudas;
import cl.awakelab.modelo.Beneficiarios;
import cl.awakelab.servicio.AyudasServicio;
import cl.awakelab.servicio.BeneficiariosServicio;

@Controller
public class MainControlador {

	@Autowired
	AyudasServicio sa;
	@Autowired
	BeneficiariosServicio sb;
	
	//formulario y add + json
    @RequestMapping({"/", "verAyudas"})    
    public String addAyudas(Model m){    
    //List<Ayudas> listayu= sa.getAllAyudas();
    	
    // Consumir Ayudas Json
    final String uriA = "http://localhost:8181/Ensayo1b/ayudasJson";    
    RestTemplate restTemplateA = new RestTemplate();

    ResponseEntity<List<Ayudas>> postResponseA =
            restTemplateA.exchange(uriA,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Ayudas>>() {
                });
    List<Ayudas> ayudas = postResponseA.getBody();
	    m.addAttribute("listaayudasj", ayudas);
	    System.out.println("Nombres: " + ayudas.size());
    	
    // Consumir Beneficiarios Json	    
    final String uriB = "http://localhost:8181/Ensayo1b/beneficiariosJson";    
    RestTemplate restTemplateB = new RestTemplate();

    ResponseEntity<List<Beneficiarios>> postResponseB =
            restTemplateB.exchange(uriB,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Beneficiarios>>() {
                });
    List<Beneficiarios> beneficiaro = postResponseB.getBody();
	    m.addAttribute("listabjson", beneficiaro);
	    System.out.println("Nombres: " + beneficiaro.size());
    
    //List<Beneficiarios> lbene = sb.getAllBeneficiarios();
    	//m.addAttribute("listabeneficiarios", lbene);
        m.addAttribute("ayudas", new Ayudas());
        //m.addAttribute("listaayudas",listayu);
        
        return "verAyudas";
    } 
    
    //Guardar formulario
    @PostMapping("/addAyudaSave")    
    public String addAyudasSave(@ModelAttribute("ayudas") Ayudas ayudas, Model m){
	    sa.addAyudas(ayudas);
	    return "redirect:/verAyudas";
    }
    
}