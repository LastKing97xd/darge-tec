package com.dhakares.dargetec.app.services;

import com.dhakares.dargetec.app.documents.Categoria;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoriaService {

	public Flux<Categoria> findAll();
	
	public Mono<Categoria> findById(String id);
	
	public Mono<Categoria> save(Categoria categoria);
	
	public Mono<Void> delete(Categoria categoria);
	
}
