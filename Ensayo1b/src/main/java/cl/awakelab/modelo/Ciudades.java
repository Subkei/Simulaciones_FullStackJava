package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ciudades {

	@Id
	private int ciudadid;
	private String nombreciudad;
	
	@JsonIgnore
	@OneToMany(mappedBy="ciudades", fetch = FetchType.EAGER)
	private List<Beneficiarios> beneficiarios;
	
	public Ciudades() {
		super();
	}

	public Ciudades(int ciudadid, String nombreciudad, List<Beneficiarios> beneficiarios) {
		super();
		this.ciudadid = ciudadid;
		this.nombreciudad = nombreciudad;
		this.beneficiarios = beneficiarios;
	}

	public int getCiudadid() {
		return this.ciudadid;
	}

	public void setCiudadid(int ciudadid) {
		this.ciudadid = ciudadid;
	}

	public String getNombreciudad() {
		return this.nombreciudad;
	}

	public void setNombreciudad(String nombreciudad) {
		this.nombreciudad = nombreciudad;
	}

	public List<Beneficiarios> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiarios> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
}