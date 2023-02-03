package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.List;

import org.iesvdm.model.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO{

	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	@Override
	public void create(Pelicula pelicula) {
		String sqlInsert = """
				INSERT INTO pelicula ( titulo, descripcion, anyo_lanzamiento, id_idioma, id_idioma_original, duracion_alquiler, rental_rate, duracion, replacement_cost, clasificacion, caracteristicas_especiales) 
				VALUES  (     ?,         ?,         ?,       ?, ?, ?, ?, ?, ?, ?, ?)
			   """;

		KeyHolder keyHolder = new GeneratedKeyHolder();
	//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setString(idx++, pelicula.getTitulo());
			ps.setString(idx++, pelicula.getDescripcion());
			ps.setInt(idx++, pelicula.getAnyo_lanzamiento());
			ps.setInt(idx++, pelicula.getId_idioma());
			ps.setString(idx++, null);
			ps.setInt(idx++, pelicula.getDuracion_alquiler());
			ps.setFloat(idx++, pelicula.getRental_rate());
			ps.setInt(idx++, pelicula.getDuracion());
			ps.setFloat(idx++, pelicula.getReplacement_cost());
			ps.setString(idx++, pelicula.getClasificacion());
			ps.setString(idx++, pelicula.getCaracteristicas_especiales());
			
			return ps;
		},keyHolder);

		pelicula.setId_pelicula(keyHolder.getKey().intValue());


		log.info("Insertados {} registros.", rows);
		
	}

	@Override
	public List<Pelicula> getAll() {
		List<Pelicula> listPelicula = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"), 
                							  rs.getString("titulo"), 
                							  rs.getString("descripcion"),
                							  rs.getInt("anyo_lanzamiento"), 
                							  rs.getInt("id_idioma"),
                							  rs.getString("id_idioma_original"),
                							  rs.getInt("duracion_alquiler"),
                							  rs.getFloat("rental_rate"),
                							  rs.getInt("duracion"),
                							  rs.getFloat("replacement_cost"),
                							  rs.getString("clasificacion"),
                							  rs.getString("caracteristicas_especiales"),
                							  rs.getDate("ultima_actualizacion")
                							  )
                						 	
        );
		
		log.info("Devueltos {} registros.", listPelicula.size());
		
        return listPelicula;
	}
}
