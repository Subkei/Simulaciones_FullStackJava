package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Beneficiarios;

public interface BeneficiariosServicio {

	List<Beneficiarios> getAllBeneficiarios();
	Beneficiarios getBeneficiariosById(int beneficiarioid);
	void addBeneficiarios(Beneficiarios beneficiarios);

}
