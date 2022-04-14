package com.dhakares.dargetec.app.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhakares.dargetec.app.dao.ProveedorDao;
import com.dhakares.dargetec.app.documents.Proveedor;
import com.dhakares.dargetec.app.services.ProveedorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServiceImp implements ProveedorService{

	@Autowired
	private ProveedorDao proveedorDao;
	
	@Override
	public Flux<Proveedor> findAll() {
		
		return proveedorDao.findAll();
	}

	@Override
	public Mono<Proveedor> findById(String id) {
		
		return proveedorDao.findById(id);
	}

	@Override
	public Mono<Proveedor> save(Proveedor proveedor) {
		
		return proveedorDao.save(proveedor);
	}

	@Override
	public Mono<Void> delete(Proveedor proveedor) {
		
		return proveedorDao.delete(proveedor);
	}

}
