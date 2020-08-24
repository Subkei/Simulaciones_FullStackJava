package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.Categoria;
import cl.awakelab.modelo.CategoriaRepositorio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio{

	@Autowired
	CategoriaRepositorio cr;
	
	@Override
	public List<Categoria> getAllCategoria() {
		return (List<Categoria>) cr.findAll();
	}

	@Override
	public Categoria getCategoriaById(int categoriaid) {
		return cr.findOne(categoriaid);
	}

}
