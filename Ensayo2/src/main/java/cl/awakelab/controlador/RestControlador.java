package cl.awakelab.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.modelo.Categoria;
import cl.awakelab.modelo.Factura;
import cl.awakelab.modelo.Producto;
import cl.awakelab.servicio.CategoriaServicio;
import cl.awakelab.servicio.FacturaServicio;

@RestController
public class RestControlador {

	static Logger log = Logger.getLogger(RestControlador.class.getName());
	
	@Autowired
	FacturaServicio fs;
	@Autowired
	CategoriaServicio cs;
	
	//Listado de Productos por Categoria JSON
    @GetMapping(value= "/verProductosCategoriaJson/{id}", headers = "Accept=application/json")    
    public List<Producto> getProductosByCategoriaid(@PathVariable int id){
    	Categoria cat = cs.getCategoriaById(id);
    	log.info("Listado de Productos por Categoria a JSON");
        return cat.getListproductos();
    }
    
	//Listado de Facturas JSON
    @GetMapping(value = "/verFacturasJson", headers = "Accept=application/json")    
    public List<Factura> facturasJson(){
        log.info("Listado de Facturas por JSON");
        return fs.getAllFacturas();
    }  
}
