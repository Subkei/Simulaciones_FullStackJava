package cl.awakelab.servicio;

import java.util.List;

import cl.awakelab.modelo.Categoria;

public interface CategoriaServicio {

	List<Categoria> getAllCategoria();
	Categoria getCategoriaById(int categoriaid);
}
