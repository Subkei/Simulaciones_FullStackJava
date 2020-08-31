package cl.awakelab.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Ofertas {

	@Id
	@Column(name = "idoferta")
	private int idOferta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha;
	private String titulo;
	private String descripcion;
	private double salario;
	
	@OneToMany(mappedBy = "ofertas", fetch = FetchType.EAGER)
	private List<Postulaciones> postulaciones;
	
	@ManyToOne
	@JoinColumn(name = "idReclutador")
	private Reclutadores reclutadores;

	public Ofertas() {
		super();
	}

	public Ofertas(int idOferta, Date fecha, String titulo, String descripcion, double salario,
			List<Postulaciones> postulaciones, Reclutadores reclutadores) {
		super();
		this.idOferta = idOferta;
		this.fecha = fecha;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.salario = salario;
		this.postulaciones = postulaciones;
		this.reclutadores = reclutadores;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Postulaciones> getPostulaciones() {
		return postulaciones;
	}

	public void setPostulaciones(List<Postulaciones> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public Reclutadores getReclutadores() {
		return reclutadores;
	}

	public void setReclutadores(Reclutadores reclutadores) {
		this.reclutadores = reclutadores;
	}

	@Override
	public String toString() {
		return "Ofertas [idOferta=" + idOferta + ", fecha=" + fecha + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", salario=" + salario + ", postulaciones=" + postulaciones + ", reclutadores="
				+ reclutadores + "]";
	}
	
}
