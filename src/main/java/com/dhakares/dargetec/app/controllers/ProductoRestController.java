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
import com.dhakares.dargetec.app.documents.Producto;
import com.dhakares.dargetec.app.documents.Proveedor;
import com.dhakares.dargetec.app.services.CategoriaService;
import com.dhakares.dargetec.app.services.ProductoService;
import com.dhakares.dargetec.app.services.ProveedorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping
	public Flux<Producto> mostrar(){
		Flux<Producto> flux=productoService.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Producto> save(@RequestBody Producto producto){
		
		Mono<Categoria> mono=categoriaService.findById(producto.getCategoria().getId());
		
		Mono<Proveedor> mon=proveedorService.findById(producto.getProveedor().getId());
		
		return mono.flatMap(c->{
			producto.setCategoria(c);
			return mon.flatMap(d->{
				producto.setProveedor(d);
				return productoService.save(producto);
			});
			});
	}
	
	@GetMapping("/{id}")
	public Mono<Producto> buscar(@PathVariable String id){
		Mono<Producto> buscarid=productoService.findById(id);
		return buscarid;
	}
	
	@DeleteMapping("/delete")
	public Mono<String> delete(@RequestBody Producto producto){
		return productoService.findById(producto.getId())
				.defaultIfEmpty(new Producto())
				.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe el producto")):
					productoService.delete(producto) )
				.then(Mono.just("Eliminado con exito"))
				.onErrorResume(ex -> Mono.just("Error al eliminar"));
	}
	
}
