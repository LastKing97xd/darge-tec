package com.dhakares.dargetec.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.dhakares.dargetec.app.documents.Producto;

public interface ProductoDao extends ReactiveMongoRepository<Producto, String>{

}
