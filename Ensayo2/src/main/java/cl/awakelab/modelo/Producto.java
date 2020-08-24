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
public class Producto {

	@Id
	private int productoid;
	private String nombre;
	private int valor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoriaid")
	private Categoria categoria;
	
    @JsonIgnore
	//Para solicitud no inicializada entre Producto y Factura OneToMany en el uso JSON
	@OneToMany(mappedBy="producto", fetch = FetchType.EAGER)
	private List<Detallefactura> detfactura;

	public Producto() {
		super();
	}

	public Producto(int productoid, String nombre, int valor, Categoria categoria) {
		super();
		this.productoid = productoid;
		this.nombre = nombre;
		this.valor = valor;
		this.categoria = categoria;
	}

	public Producto(int productoid, String nombre, int valor, Categoria categoria,
			List<Detallefactura> detfactura) {
		super();
		this.productoid = productoid;
		this.nombre = nombre;
		this.valor = valor;
		this.categoria = categoria;
		this.detfactura = detfactura;
	}

	public int getProductoid() {
		return productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Detallefactura> getDetallefactura() {
		return detfactura;
	}

	public void setDetallefactura(List<Detallefactura> detfactura) {
		this.detfactura = detfactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((detfactura == null) ? 0 : detfactura.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + productoid;
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (detfactura == null) {
			if (other.detfactura != null)
				return false;
		} else if (!detfactura.equals(other.detfactura))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (productoid != other.productoid)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [productoid=" + productoid + ", nombre=" + nombre + ", valor=" + valor
				+ ", categoria=" + categoria + ", detfactura=" + detfactura + "]";
	}

}
