package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reclutadores {

	@Id
	@Column(name = "idreclutador")
	private int idReclutador;
	@Column(name = "nombrefantasia")
	private String nombreFantasia;
	@Column(name = "razonsocial")
	private String razonSocial;
	private String rut;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reclutadores", fetch = FetchType.EAGER)
	private List<Ofertas> ofertas;

	public Reclutadores() {
		super();
	}

	public Reclutadores(int idReclutador, String nombreFantasia, String razonSocial, String rut, String email,
			List<Ofertas> ofertas) {
		super();
		this.idReclutador = idReclutador;
		this.nombreFantasia = nombreFantasia;
		this.razonSocial = razonSocial;
		this.rut = rut;
		this.email = email;
		this.ofertas = ofertas;
	}

	public int getIdReclutador() {
		return idReclutador;
	}

	public void setIdReclutador(int idReclutador) {
		this.idReclutador = idReclutador;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}

	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public List<Ofertas> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Ofertas> ofertas) {
		this.ofertas = ofertas;
	}

}
