package cl.awakelab.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Detallefactura {

	@EmbeddedId
	private DetallefacturaPK id;
	
	@JsonIgnore
    @ManyToOne
	@MapsId("productoid")
    @JoinColumn(name="productoid")
	private Producto producto;
	
	@JsonIgnore
    @ManyToOne
	@MapsId("facturaid")
    @JoinColumn(name="facturaid")
	private Factura factura;

	private int cantidad;
	
	public Detallefactura() {
		super();
	}

	public Detallefactura(DetallefacturaPK id, Producto producto, Factura factura, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.factura = factura;
		this.cantidad = cantidad;
	}

	public DetallefacturaPK getId() {
		return id;
	}

	public void setId(DetallefacturaPK id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		Detallefactura other = (Detallefactura) obj;
		if (cantidad != other.cantidad)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Detallefactura [id=" + id + ", cantidad=" + cantidad + "]";
	}
	
}
