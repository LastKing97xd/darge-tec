package com.dhakares.dargetec.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dhakares.dargetec.app.documents.Categoria;
import com.dhakares.dargetec.app.services.CategoriaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public Flux<Categoria> mostrar(){
		Flux<Categoria> flux=categoriaService.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Categoria> save(@RequestBody Categoria categoria){
		Mono<Categoria> guardar=categoriaService.save(categoria);
		return guardar;
	}
	
	@GetMapping("/{id}")
	public Mono<Categoria> buscar(@PathVariable String id){
		Mono<Categoria> buscarid=categoriaService.findById(id);
		return buscarid;
	}
	
	@DeleteMapping("/delete")
	public Mono<String> delete(@RequestBody Categoria categoria){
		return categoriaService.findById(categoria.getId())
				.defaultIfEmpty(new Categoria())
				.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe la categoria")):
					categoriaService.delete(categoria) )
				.then(Mono.just("Eliminado con exito"))
				.onErrorResume(ex -> Mono.just("Error al eliminar")); 
	}
}
