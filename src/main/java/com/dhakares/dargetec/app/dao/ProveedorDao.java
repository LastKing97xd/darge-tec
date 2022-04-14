package com.dhakares.dargetec.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.dhakares.dargetec.app.documents.Proveedor;

public interface ProveedorDao extends ReactiveMongoRepository<Proveedor, String>{

}
