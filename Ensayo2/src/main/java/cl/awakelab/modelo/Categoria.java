package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {

	@Id
	private int categoriaid;
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	private List<Producto> listproductos;

	public Categoria() {
		super();
	}

	public Categoria(int categoriaid, String nombre, List<Producto> listproductos) {
		super();
		this.categoriaid = categoriaid;
		this.nombre = nombre;
		this.listproductos = listproductos;
	}

	public int getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(int categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getListproductos() {
		return listproductos;
	}

	public void setListproductos(List<Producto> listproductos) {
		this.listproductos = listproductos;
	}

	@Override
	public String toString() {
		return "Categoria [categoriaid=" + categoriaid + ", nombre=" + nombre + ", listproductos=" + listproductos
				+ "]";
	}

}
