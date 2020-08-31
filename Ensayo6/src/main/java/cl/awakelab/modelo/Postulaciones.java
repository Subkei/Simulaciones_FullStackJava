package cl.awakelab.modelo;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Postulaciones {

	@EmbeddedId
	private PostulacionesPK id;
	
	@ManyToOne
	@MapsId("idPostulante")
	@JoinColumn(name = "idPostulante")
	private Postulantes postulantes;
	
	@JsonBackReference
	@ManyToOne
	@MapsId("idOferta")
	@JoinColumn(name = "idOferta")
	private Ofertas ofertas;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha;

	public Postulaciones() {
		super();
	}

	public Postulaciones(PostulacionesPK id, Postulantes postulantes, Ofertas ofertas, Date fecha) {
		super();
		this.id = id;
		this.postulantes = postulantes;
		this.ofertas = ofertas;
		this.fecha = fecha;
	}

	public PostulacionesPK getId() {
		return id;
	}

	public void setId(PostulacionesPK id) {
		this.id = id;
	}

	public Postulantes getPostulantes() {
		return postulantes;
	}

	public void setPostulantes(Postulantes postulantes) {
		this.postulantes = postulantes;
	}

	public Ofertas getOfertas() {
		return ofertas;
	}

	public void setOfertas(Ofertas ofertas) {
		this.ofertas = ofertas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
