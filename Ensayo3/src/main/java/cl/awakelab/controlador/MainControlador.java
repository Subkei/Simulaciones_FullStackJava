package cl.awakelab.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.awakelab.modelo.Alumno;
import cl.awakelab.modelo.Curso;
import cl.awakelab.servicio.AlumnoServicio;
import cl.awakelab.servicio.CursoServicio;

@Controller
public class MainControlador {

	@Autowired
	AlumnoServicio as;
	@Autowired
	CursoServicio cs;

	static Logger log = Logger.getLogger(MainControlador.class.getName());
	
	//Listar Cursos
	@RequestMapping({"/", "/verCursos"})
	public String getCursosList(Model m) {
		List<Curso> listac = cs.getAllCurso();
		m.addAttribute("listarcursos",listac);
		log.info("Listado de Cursos");
		return "verCursos";
	}
	
	//Listado total Alumnos
	@RequestMapping("/verAlumnos")
	public String getAlumnosList(Model m) {
		List<Alumno> listaa = as.getAllAlumnos();
    	String msg = "Listado de todos los Alumnos";
    	m.addAttribute("msg", msg);		
		m.addAttribute("Datosalumnos",listaa);
		log.info("Listado de Alumnos");
		return "verAlumnos";
	}
	
    //Listar Alumnos por Curso
    @GetMapping(value="/verAlumnos/{idalumno}")
    public String ListAlumno(Model m, @PathVariable int idalumno) {
    	Curso cid = cs.getCursoById(idalumno);
    	String msg = "Listado de Alumnos por Curso";
    	m.addAttribute("msg", msg);
    	m.addAttribute("Datosalumnos",cid.getAlumno());
    	log.info("Listar Alumnos por ID de Curso");
    	return "verAlumnos";
    }

	//Listado de Alumnos por Curso
//    @RequestMapping(value = "/verAlumnos/{id}")    
//    public String getAllAlumnosJson(Model m, @PathVariable int id){  
//    	
//    //Consumir Listado Alumnos Json
//
//    final String uri = "http://localhost:8181/Ensayo3/verAlumnosCursoJson/{id}";    
//    RestTemplate restTemplate = new RestTemplate();
//
//    ResponseEntity<List<Alumno>> postResponse =
//            restTemplate.exchange(uri,
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Alumno>>() {
//                });
//    List<Alumno> listalumnos = postResponse.getBody();
//	    m.addAttribute("Datosalumnos", listalumnos);
//	    System.out.println("Alumnos: " + listalumnos.size());
//	    
//        log.info("Listado de Alumnos");
//        return "verAlumnos";
//    }     
}
