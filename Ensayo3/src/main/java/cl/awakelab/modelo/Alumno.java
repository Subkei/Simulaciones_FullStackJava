package cl.awakelab.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Alumno {

	@Id
	private int idalumno;
	private String nombre;

	@ManyToOne
	@JoinColumn(name="idcurso")
	private Curso curso;

	public Alumno() {
		super();
	}

	public Alumno(int idalumno, String nombre, Curso curso) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.curso = curso;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [idalumno=" + idalumno + ", nombre=" + nombre + ", curso=" + curso + "]";
	}
}
