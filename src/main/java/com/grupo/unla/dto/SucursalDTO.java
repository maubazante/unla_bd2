package com.grupo.unla.dto;

import com.grupo3.unla.model.Sucursal;

public class SucursalDTO {
	public int id;
	public String nombre;
	
	public SucursalDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public SucursalDTO(Sucursal sucursal) {
		super();
		this.id = sucursal.getId();
		this.nombre = sucursal.getNombre();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
