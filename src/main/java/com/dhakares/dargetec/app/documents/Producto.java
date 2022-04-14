package com.dhakares.dargetec.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection="productos")
public class Producto {

	@Id
	private String id;
	private String nombre;
	private String color;
	private String compatibilidad;
	private String descripcion;
	private Categoria categoria;
	private Proveedor proveedor;
	private Double precio;
	private Double mprecio;
		
	public Producto(String nombre, String color, String compatibilidad, String descripcion, Double precio,
			Double mprecio, Proveedor proveedor, Categoria categoria) {
		
		this.nombre = nombre;
		this.color = color;
		this.compatibilidad = compatibilidad;
		this.descripcion = descripcion;
		this.precio = precio;
		this.mprecio = mprecio;
		this.proveedor=proveedor;
		this.categoria=categoria;
		
	}
		
}
