package cl.awakelab.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.modelo.Ayudas;
import cl.awakelab.modelo.Beneficiarios;
import cl.awakelab.servicio.AyudasServicio;
import cl.awakelab.servicio.BeneficiariosServicio;

@RestController
public class RestControlador {

	@Autowired
	AyudasServicio sa;
	@Autowired
	BeneficiariosServicio bs;

	//Listar Ayudas Json
	@GetMapping(value = "/ayudasJson", headers = "Accept=application/json")
	public List<Ayudas> getAllAyudas() {
		return sa.getAllAyudas();
	}

	//Listar Beneficiarios Json
    @GetMapping(value= "/beneficiariosJson", headers = "Accept=application/json") 
    public List<Beneficiarios> getAllBeneficiarios(){
    	List<Beneficiarios> listbj = bs.getAllBeneficiarios();
    	return listbj;
    	
    } 

}
