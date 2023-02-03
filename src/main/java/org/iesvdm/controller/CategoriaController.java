package org.iesvdm.controller;

import java.util.HashMap;
import java.util.Map;

import org.iesvdm.model.Categoria;
import org.iesvdm.model.CategoriaDTO;
import org.iesvdm.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaController {

	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/categoria/{id}")
	public String detalle(Model model, @PathVariable Integer id) {

		CategoriaDTO cat = categoriaService.oneDTO(id);
		
		model.addAttribute("categoria", cat);
	
		return "detalle-categoria";
	}
	
}
