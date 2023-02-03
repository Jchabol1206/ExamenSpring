package org.iesvdm.model;

import java.util.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula {
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}
	private int id_pelicula;
	
	@NotBlank(message="No dejar en blanco")
	@Size(min=2, message="Minimo de caracteres 3")
	private String titulo;
	@Size(max=301, message="Maximo de caracteres 300")
	private String descripcion;
	private int anyo_lanzamiento;
	private int id_idioma;
	private String id_idioma_original;
	private int duracion_alquiler;
	@Min(value=0, message="El valor no puede ser negativo")
	private float rental_rate;
	@Min(value=1, message="No puede durar menos de 1")
	private int duracion;
	@DecimalMin(value="19.99", inclusive=true, message="Valor minimo 19.99")
	private float replacement_cost;
	private String clasificacion;
	private String caracteristicas_especiales;
	private Date ultima_actualizacion;
}
