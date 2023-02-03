package org.iesvdm.dao;

import java.util.Optional;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

import org.iesvdm.model.Categoria;
import org.iesvdm.model.CategoriaDTO;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO{

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public Optional<Categoria> find(int id) {
		
		Categoria cat =  jdbcTemplate
				.queryForObject("SELECT * FROM categoria WHERE id_categoria = ?"														
								, (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
            						 						rs.getString("nombre"),
            						 						rs.getDate("ultima_actualizacion")
            						 						), id);
		
		if (cat != null) { 
			return Optional.of(cat);}
		else { 
			log.info("Categoria no encontrado.");
			return Optional.empty(); }
        
	}

	@Override
	public Optional<CategoriaDTO> findDTO(int id) {
		CategoriaDTO cat =  jdbcTemplate
				.queryForObject("select categoria.*, count(pelicula_categoria.id_pelicula) from categoria  left join  pelicula_categoria on pelicula_categoria.id_categoria = categoria.id_categoria where categoria.id_categoria=? group by categoria.id_categoria"														
								, (rs, rowNum) -> new CategoriaDTO(rs.getInt("id_categoria"),
            						 						rs.getString("nombre"),
            						 						rs.getDate("ultima_actualizacion"),
            						 						rs.getInt("count(pelicula_categoria.id_pelicula)")
            						 						), id);
		
		
		if (cat != null) { 
			return Optional.of(cat);}
		else { 
			log.info("Categoria no encontrado.");
			return Optional.empty(); }
	}

}
