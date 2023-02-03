package org.iesvdm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriaDTO {

	
	private int id_categoria;
	
	private String nombre;
	
	private Date ultima_actualizacion;
	
	private int totalPeliculas;
	

	public int getTotalPeliculas() {
		return totalPeliculas;
	}

	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas = totalPeliculas;
	}

	
	 
	
	
	
}
