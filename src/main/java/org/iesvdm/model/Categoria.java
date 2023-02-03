package org.iesvdm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Categoria {
	
	private int id_categoria;
	
	private String nombre;
	
	private Date ultima_actualizacion;

}
