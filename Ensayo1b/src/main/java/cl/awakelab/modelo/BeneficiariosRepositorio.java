package cl.awakelab.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiariosRepositorio extends CrudRepository<Beneficiarios, Integer>{

}
