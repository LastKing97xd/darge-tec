package com.dhakares.dargetec.app.services;

import com.dhakares.dargetec.app.documents.Proveedor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProveedorService {

	public Flux<Proveedor> findAll();
	
	public Mono<Proveedor> findById(String id);
	
	public Mono<Proveedor> save(Proveedor proveedor);
	
	public Mono<Void> delete(Proveedor proveedor);
	
}
