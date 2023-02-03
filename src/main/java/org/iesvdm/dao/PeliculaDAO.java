package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.model.Pelicula;



public interface PeliculaDAO {

public void create(Pelicula pelicula);
	
public List<Pelicula> getAll();
	
	
	
}
