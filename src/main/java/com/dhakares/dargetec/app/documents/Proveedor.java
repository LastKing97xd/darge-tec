package com.dhakares.dargetec.app.documents;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection="proveedores")
public class Proveedor {

	@Id
	private String id;
	private String nombre;
	private String ubicacion;
	private Double puntuacion;
	private Date creacion;
		
	public Proveedor(String nombre, String ubicacion, Double puntuacion) {
		
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.puntuacion = puntuacion;
		
	}
	
}
