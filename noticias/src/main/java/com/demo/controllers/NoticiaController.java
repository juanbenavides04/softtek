package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Noticia;
import com.demo.services.INoticiaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class NoticiaController {
	
	@Autowired
	private INoticiaService ActividadService;
	
	@PostMapping("/guardar")
	public Noticia guardar(@RequestBody Noticia actividad) {
		return ActividadService.save(actividad);
	}
	
	
	@PostMapping("/modificar")
	public Noticia modificar(@RequestBody Noticia actividad) {
		return ActividadService.save(actividad);
	}
	
	@GetMapping("/mostrar/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		return ActividadService.findById(id);
	}
	
	@GetMapping("/mostrarlista")
	public List<Noticia> mostrarlista() {
		return ActividadService.findAll();
	}
	
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		 return ActividadService.delete(id);
	}
	

	@GetMapping("/mostrarlistatitulo/{titulo}")
	public List<Noticia> mostrarlistatitulo(@PathVariable String titulo) {
		
		return ActividadService.buscarPorTitulo(titulo);
	}
	
	@GetMapping("/mostrafavoritos")
	public List<Noticia> mostraFavoritos() {
		
		return ActividadService.mostraFavoritos();
	}
	
	@GetMapping("/buscarportitulofavoritos/{titulo}")
	public List<Noticia> buscarPorTituloFavoritos(@PathVariable String titulo) {
		
		return ActividadService.buscarPorTituloFavoritos(titulo);
	}
	
	@PutMapping("/moificarfavoritos/{id}/{favorito}")
	public void moificarFavoritos(@PathVariable Long id, @PathVariable Boolean favorito) {
		System.out.println(id+" - "+favorito);
		 ActividadService.moificarFavoritos(id, favorito);
	}

}
