package cl.awakelab.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantesRepositorio extends CrudRepository<Postulantes, Integer>{

}
