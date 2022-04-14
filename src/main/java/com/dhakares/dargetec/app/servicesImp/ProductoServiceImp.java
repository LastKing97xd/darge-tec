package com.dhakares.dargetec.app.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhakares.dargetec.app.dao.ProductoDao;
import com.dhakares.dargetec.app.documents.Producto;
import com.dhakares.dargetec.app.services.ProductoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	public Flux<Producto> findAll() {
		
		return productoDao.findAll();
	}

	@Override
	public Mono<Producto> findById(String id) {
		
		return productoDao.findById(id);
	}

	@Override
	public Mono<Producto> save(Producto producto) {
		
		return productoDao.save(producto);
	}

	@Override
	public Mono<Void> delete(Producto producto) {
		
		return productoDao.delete(producto);
	}

}
