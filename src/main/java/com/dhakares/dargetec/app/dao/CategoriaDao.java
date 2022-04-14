package com.dhakares.dargetec.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.dhakares.dargetec.app.documents.Categoria;

public interface CategoriaDao extends ReactiveMongoRepository<Categoria, String>{

}
