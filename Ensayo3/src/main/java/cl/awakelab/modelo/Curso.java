package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso {

	@Id
	private int idcurso;
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	private List<Alumno> alumno;

	public Curso() {
		super();
	}

	public Curso(int idcurso, String nombre, List<Alumno> alumno) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.alumno = alumno;
	}

	public int getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + idcurso + ", nombre=" + nombre + ", alumno=" + alumno + "]";
	}
	
}
