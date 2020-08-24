package cl.awakelab.controlador;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.awakelab.modelo.Detallefactura;
import cl.awakelab.modelo.Factura;
import cl.awakelab.servicio.CategoriaServicio;
import cl.awakelab.servicio.FacturaServicio;

@Controller
public class MainControlador {
	
	static Logger log = Logger.getLogger(MainControlador.class.getName());
	
	@Autowired
	FacturaServicio fs;
	CategoriaServicio cs;
	
	//Inicio
      @RequestMapping("/")    
      public String getInicio(Model m){    
          log.info("Página principal");
          return "verFacturas";
      }	
	
    //busqueda por ID de factura
    @RequestMapping(value="/facturas")
    public String Factura(@RequestParam("txtfacturaid") int facturaid, Model m) {
    	Factura fact = fs.getFacturaById(facturaid);
    	List<Detallefactura> detfact = fact.getDetfactura();
    	m.addAttribute("datosFactura",fact);
    	m.addAttribute("detalleFactura", detfact);
        log.info("Buscar Facturas por ID");
    	return "verFacturas";
    }
	
}
