package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Postulantes {

	@Id
	@Column(name="idpostulante")
	private int idPostulante;
	private String nombre;
	private String apellido;
	private String rut;
	private String email;
	private String resumen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "postulantes", fetch = FetchType.EAGER)
	private List<Postulaciones> postulaciones;

	public Postulantes() {
		super();
	}

	public Postulantes(int idPostulante, String nombre, String apellido, String rut, String email, String resumen,
			List<Postulaciones> postulaciones) {
		super();
		this.idPostulante = idPostulante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.email = email;
		this.resumen = resumen;
		this.postulaciones = postulaciones;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public List<Postulaciones> getPostulaciones() {
		return postulaciones;
	}

	public void setPostulaciones(List<Postulaciones> postulaciones) {
		this.postulaciones = postulaciones;
	}

	@Override
	public String toString() {
		return "Postulantes [idPostulante=" + idPostulante + ", nombre=" + nombre + ", apellido=" + apellido + ", rut="
				+ rut + ", email=" + email + ", resumen=" + resumen + ", postulaciones=" + postulaciones + "]";
	}
	
}
