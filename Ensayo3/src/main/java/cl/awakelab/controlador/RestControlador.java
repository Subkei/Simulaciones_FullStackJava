package cl.awakelab.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.modelo.Alumno;
import cl.awakelab.modelo.Curso;
import cl.awakelab.servicio.CursoServicio;

@RestController
public class RestControlador {

	static Logger log = Logger.getLogger(RestControlador.class.getName());
	
	@Autowired
	CursoServicio cs;
	
	//Listado de Alumnos por Curso JSON
    @GetMapping(value= "/verAlumnosCursoJson/{id}", headers = "Accept=application/json")    
    public List<Alumno> getAlumnosByCursoid(@PathVariable int id){
        Curso curso = cs.getCursoById(id);
    	log.info("Listado de Alumnos por Curso a JSON");
    	return curso.getAlumno();
    }
}
