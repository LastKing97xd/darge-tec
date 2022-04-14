package com.dhakares.dargetec.app.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhakares.dargetec.app.dao.CategoriaDao;
import com.dhakares.dargetec.app.documents.Categoria;
import com.dhakares.dargetec.app.services.CategoriaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriaServiceImp implements CategoriaService{
	
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public Flux<Categoria> findAll() {
		
		return categoriaDao.findAll();
	}

	@Override
	public Mono<Categoria> findById(String id) {
		
		return categoriaDao.findById(id);
	}

	@Override
	public Mono<Categoria> save(Categoria categoria) {
		
		return categoriaDao.save(categoria);
	}

	@Override
	public Mono<Void> delete(Categoria categoria) {
		
		return categoriaDao.delete(categoria);
	}

}
