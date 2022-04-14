package com.dhakares.dargetec.app.controllers;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dhakares.dargetec.app.documents.Proveedor;
import com.dhakares.dargetec.app.services.ProveedorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping
	public Flux<Proveedor> mostrar(){
		Flux<Proveedor> flux=proveedorService.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Proveedor> save(@RequestBody Proveedor proveedor){
		proveedor.setCreacion(new Date());
		Mono<Proveedor> guardar=proveedorService.save(proveedor);
		return guardar;
	}
	
	@GetMapping("/{id}")
	public Mono<Proveedor> buscar(@PathVariable String id){
		Mono<Proveedor> buscarid=proveedorService.findById(id);
		return buscarid;
	}
	
	@DeleteMapping("/delete")
	public Mono<String> delete(@RequestBody Proveedor proveedor){
		return proveedorService.findById(proveedor.getId())
				.defaultIfEmpty(new Proveedor())
				.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe el proveedor")):
					proveedorService.delete(proveedor) )
				.then(Mono.just("Eliminado con exito"))
				.onErrorResume(ex -> Mono.just("Error al eliminar"));	
				
	}
}
