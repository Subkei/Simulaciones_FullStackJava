package cl.awakelab.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PostulacionesPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idpostulante")
	private int idPostulante;
	
	@Column(name = "idoferta")
	private int idOferta;

	public PostulacionesPK() {
		super();
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOferta;
		result = prime * result + idPostulante;
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
		PostulacionesPK other = (PostulacionesPK) obj;
		if (idOferta != other.idOferta)
			return false;
		if (idPostulante != other.idPostulante)
			return false;
		return true;
	}
	
}
