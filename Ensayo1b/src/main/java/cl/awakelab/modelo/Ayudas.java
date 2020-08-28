package cl.awakelab.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ayudas {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AYU_SEQ")
    @SequenceGenerator(sequenceName = "ayudas_seq", allocationSize = 1, name = "AYU_SEQ")
	private int ayudaid;
	private int monto;
	private String motivo;

	@ManyToOne
	@JoinColumn(name="beneficiarioid")
	private Beneficiarios beneficiarios;

	public Ayudas() {
		super();
	}
	
	public Ayudas(int ayudaid, int monto, String motivo, Beneficiarios beneficiarios) {
		super();
		this.ayudaid = ayudaid;
		this.monto = monto;
		this.motivo = motivo;
		this.beneficiarios = beneficiarios;
	}

	public int getAyudaid() {
		return this.ayudaid;
	}

	public void setAyudaid(int ayudaid) {
		this.ayudaid = ayudaid;
	}

	public int getMonto() {
		return this.monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Beneficiarios getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Beneficiarios beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	@Override
	public String toString() {
		return "Ayudas [ayudaid=" + ayudaid + ", monto=" + monto + ", motivo=" + motivo + ", beneficiarios="
				+ beneficiarios + "]";
	}

}