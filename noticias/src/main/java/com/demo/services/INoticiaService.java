package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.demo.entity.Noticia;

public interface INoticiaService {
	
	public List<Noticia> findAll();
	
	public ResponseEntity<?> findById(Long id);
	
	public Noticia save(Noticia activiad);
	
	public ResponseEntity<?> delete(Long id);

	List<Noticia> buscarPorTitulo(String titulo);
	
	List<Noticia> mostraFavoritos();
	
	List<Noticia> buscarPorTituloFavoritos(String titulo);
	
	void moificarFavoritos(Long id,boolean favorito);


}
