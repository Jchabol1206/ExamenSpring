package org.iesvdm.service;

import java.util.Optional;


import org.iesvdm.dao.CategoriaDAO;
import org.iesvdm.model.Categoria;
import org.iesvdm.model.CategoriaDTO;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	private CategoriaDAO categoriaDAO;

	public CategoriaService(CategoriaDAO categoriaDAO) {
		super();
		this.categoriaDAO = categoriaDAO;
	}

	public Categoria one (Integer id) {
		Optional optCli = categoriaDAO.find(id);
		if(optCli.isPresent()) {
			return (Categoria) optCli.get();
		}
		else {
			return null;
		}
	}
	public CategoriaDTO oneDTO (Integer id) {
		Optional optCli = categoriaDAO.findDTO(id);
		if(optCli.isPresent()) {
			return (CategoriaDTO) optCli.get();
		}
		else {
			return null;
		}
	}
	
}
