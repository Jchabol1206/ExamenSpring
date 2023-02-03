package org.iesvdm.dao;

import java.util.Optional;

import org.iesvdm.model.Categoria;
import org.iesvdm.model.CategoriaDTO;



public interface CategoriaDAO {

	public Optional<Categoria>  find(int id);
	public Optional<CategoriaDTO> findDTO(int id);
}
