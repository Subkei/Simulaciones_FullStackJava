package cl.awakelab.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallefacturaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="facturaid")
	private int facturaid;
	
	@Column(name="productoid")
	private int productoid;
	
	public DetallefacturaPK() {
		super();
	}

	public int getFacturaid() {
		return facturaid;
	}

	public void setFacturaid(int facturaid) {
		this.facturaid = facturaid;
	}

	public int getProductoid() {
		return productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facturaid;
		result = prime * result + productoid;
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
		DetallefacturaPK other = (DetallefacturaPK) obj;
		if (facturaid != other.facturaid)
			return false;
		if (productoid != other.productoid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaCantidad [facturaid=" + facturaid + ", productoid=" + productoid + "]";
	}

}
