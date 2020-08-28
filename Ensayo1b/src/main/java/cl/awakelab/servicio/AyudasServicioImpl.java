package cl.awakelab.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.modelo.AyudasRepositorio;
import cl.awakelab.modelo.Ayudas;

@Service
public class AyudasServicioImpl implements AyudasServicio{

	@Autowired
	AyudasRepositorio daoAyu;
	
	@Override
	public List<Ayudas> getAllAyudas() {
		return (List<Ayudas>) daoAyu.findAll();
	}

	@Override
	public Ayudas getAyudasById(int ayudaid) {
		return daoAyu.findOne(ayudaid);
	}

	@Override
	public void addAyudas(Ayudas ayudas) {
		daoAyu.save(ayudas);
	}

}
