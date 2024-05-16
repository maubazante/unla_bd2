package com.grupo3.unla.model;

public class Domicilio {
	public int id;
	public String altura;
	public String calle;
	public String localidad;
	public String provincia;
	
	public Domicilio(int id, String altura, String calle, String localidad, String provincia) {
		super();
		this.id = id;
		this.altura = altura;
		this.calle = calle;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
