package org.iesvdm.controller;

import java.util.List;

import org.iesvdm.model.Pelicula;
import org.iesvdm.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class PeliculaController {
	
	
	private PeliculaService peliculaService;
	
	
	public PeliculaController(PeliculaService peliculaService) {
		super();
		this.peliculaService = peliculaService;
	}
	@GetMapping("/pelicula") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Pelicula> listaPelicula =  peliculaService.listAll();
		model.addAttribute("listaPelicula", listaPelicula);
				
		return "pelicula";
		
	}
	@GetMapping("/pelicula/crear")
	public String crear(Model model) {
		
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		return "crear-pelicula";
	}
	
	
	@PostMapping("/pelicula/crear")
	public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResulted, Model model) {
		
		if(bindingResulted.hasErrors()) {
			model.addAttribute("pelicula", pelicula);
			return "crear-pelicula";
		}
		
		
		peliculaService.newPelicula(pelicula);
		System.out.println(pelicula.toString());
		//return new RedirectView("/clientes");
		return "redirect:/pelicula";
	}
	
}
