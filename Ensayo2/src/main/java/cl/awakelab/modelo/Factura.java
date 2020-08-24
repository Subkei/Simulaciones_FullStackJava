package cl.awakelab.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Factura {

	@Id
	private int facturaid;
	private String cliente;
	private String fecha;
	
	@JsonIgnore
	//Para solicitud no inicializada entre Factura y Producto OneToMany en el uso JSON
	@OneToMany(mappedBy = "factura", fetch = FetchType.EAGER)
	private List<Detallefactura> detfactura;

	public Factura() {
		super();
	}

	public Factura(int facturaid, String cliente, String fecha) {
		super();
		this.facturaid = facturaid;
		this.cliente = cliente;
		this.fecha = fecha;
	}

	public Factura(int facturaid, String cliente, String fecha, List<Detallefactura> detfactura) {
		super();
		this.facturaid = facturaid;
		this.cliente = cliente;
		this.fecha = fecha;
		this.detfactura = detfactura;
	}

	public int getFacturaid() {
		return facturaid;
	}

	public void setFacturaid(int facturaid) {
		this.facturaid = facturaid;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Detallefactura> getDetfactura() {
		return detfactura;
	}

	public void setDetfactura(List<Detallefactura> detfactura) {
		this.detfactura = detfactura;
	}
	//Metodos getter en calculo Subtotal, Impuesto y Total
	public int getSubtotal() {
		int subtotal = 0;

        for (Detallefactura d : detfactura) {
            subtotal += d.getCantidad() * d.getProducto().getValor();
        }

        return subtotal;
    }

	public int getImpuesto() {
        return (int) (getSubtotal() * 0.19);
    }

	public int getTotal() {
        return (int) (getSubtotal() + getImpuesto());
    }
	
	@Override
	public String toString() {
		return "Factura [facturaid=" + facturaid + ", cliente=" + cliente + ", fecha=" + fecha + ", detfactura="
				+ detfactura + "]";
	}
	
}
