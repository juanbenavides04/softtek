package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Noticia;

@Repository
public interface INoticiaDao extends JpaRepository<Noticia, Long>{
	
	
	
	@Query("SELECT n FROM Noticia n WHERE n.titulo like %:titulo% ORDER BY n.fecha DESC")
	List<Noticia> buscarPorTitulo(@Param("titulo") String titulo);

	@Query("SELECT n FROM Noticia n WHERE n.favorito=true ORDER BY n.fecha DESC")
	List<Noticia> mostraFavoritos();
	
	@Query("SELECT n FROM Noticia n WHERE n.titulo like %:titulo% and n.favorito=true  ORDER BY n.fecha DESC")
	List<Noticia> buscarPorTituloFavoritos(@Param("titulo") String titulo);
	
	@Modifying
	@Query("UPDATE Noticia n SET n.favorito =true WHERE n.id=:id")
	void moificarFavoritos(@Param("id") Long id);
	
	
	 

}
