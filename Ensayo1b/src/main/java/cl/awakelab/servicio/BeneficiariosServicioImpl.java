package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.BeneficiariosRepositorio;
import cl.awakelab.modelo.Beneficiarios;

@Service
public class BeneficiariosServicioImpl implements BeneficiariosServicio{

	@Autowired
	BeneficiariosRepositorio daoBen;
	
	@Override
	public List<Beneficiarios> getAllBeneficiarios() {
		return (List<Beneficiarios>) daoBen.findAll();
	}

	@Override
	public Beneficiarios getBeneficiariosById(int beneficiarioid) {
		return daoBen.findOne(beneficiarioid);
	}

	@Override
	public void addBeneficiarios(Beneficiarios beneficiarios) {
		daoBen.save(beneficiarios);
	}


}
