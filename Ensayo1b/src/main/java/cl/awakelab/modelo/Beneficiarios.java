package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficiarios {

	@Id
	private int beneficiarioid;
	private int edad;
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="beneficiarios", fetch = FetchType.EAGER)
	private List<Ayudas> ayudas;
	
	@ManyToOne
	@JoinColumn(name="ciudadid")
	private Ciudades ciudades;

	public Beneficiarios() {
		super();
	}

	public Beneficiarios(int beneficiarioid, int edad, String nombre, List<Ayudas> ayudas, Ciudades ciudades) {
		super();
		this.beneficiarioid = beneficiarioid;
		this.edad = edad;
		this.nombre = nombre;
		this.ayudas = ayudas;
		this.ciudades = ciudades;
	}

	public int getBeneficiarioid() {
		return this.beneficiarioid;
	}

	public void setBeneficiarioid(int beneficiarioid) {
		this.beneficiarioid = beneficiarioid;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudades getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(Ciudades ciudades) {
		this.ciudades = ciudades;
	}

	public List<Ayudas> getAyudas() {
		return ayudas;
	}

	public void setAyudas(List<Ayudas> ayudas) {
		this.ayudas = ayudas;
	}

}