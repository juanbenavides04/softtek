package com.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.INoticiaDao;
import com.demo.entity.Noticia;

import jakarta.transaction.Transactional;

@Service	
public class NoticiaServiceImp implements INoticiaService {
	
	@Autowired
	private INoticiaDao iNoticiaDao;

	@Override
	public List<Noticia> findAll() {
		// TODO Auto-generated method stub
		return iNoticiaDao.findAll();
	}
	
	@Override
	public ResponseEntity<?> findById(Long id) {
	
		Optional<Noticia> cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = iNoticiaDao.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			response.put("mensaje", "La noticia ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional>(cliente, HttpStatus.OK);

		
	}


	@Override
	public Noticia save(Noticia actividad) {
		// TODO Auto-generated method stub
		return iNoticiaDao.save(actividad);
	}

	@Override
	@Transactional
	public ResponseEntity<?> delete(Long id) {
		
		Map<String, Object> response=new HashMap<>();
		try {
			
			Optional<Noticia> actividad=iNoticiaDao.findById(id);
			 if(actividad.isPresent()) {
				 iNoticiaDao.deleteById(id);
				 response.put("mensaje","La noticia ha sido eliminado con éxito!");
			 }else {
				 response.put("mensaje", "Error esta noticia no existe en la base de datos.");
			 }
		
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la noticia en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}



	@Override
	public List<Noticia> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return iNoticiaDao.buscarPorTitulo(titulo);
	}

	@Override
	public List<Noticia> mostraFavoritos() {
		// TODO Auto-generated method stub
		return iNoticiaDao.mostraFavoritos();
	}

	@Override
	public List<Noticia> buscarPorTituloFavoritos(String titulo) {
		// TODO Auto-generated method stub
		return iNoticiaDao.buscarPorTituloFavoritos(titulo);
	}

	@Transactional
	@Override
	public void moificarFavoritos(Long id, boolean favorito) {
		// TODO Auto-generated method stub
		 iNoticiaDao.moificarFavoritos(id);
	}



}
