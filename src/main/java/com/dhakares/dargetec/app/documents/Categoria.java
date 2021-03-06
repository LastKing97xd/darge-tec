package com.dhakares.dargetec.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection="categorias")
public class Categoria {

	@Id
	private String id;
	private String nombre;
	private String descripcion;
	
	public Categoria(String nombre, String descripcion) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
}
