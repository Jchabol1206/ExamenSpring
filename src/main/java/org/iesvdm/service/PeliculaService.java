package org.iesvdm.service;

import java.util.List;

import org.iesvdm.dao.PeliculaDAO;
import org.iesvdm.model.Pelicula;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

		private PeliculaDAO peliculaDAO;

		public PeliculaService(PeliculaDAO peliculaDAO) {
			super();
			this.peliculaDAO = peliculaDAO;
		}
		
		public List<Pelicula> listAll(){
			return peliculaDAO.getAll();
		}
		
		public void newPelicula(Pelicula pelicula) {
			peliculaDAO.create(pelicula);
		}
}
