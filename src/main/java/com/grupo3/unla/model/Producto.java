package com.grupo3.unla.model;

public class Producto {
	public int codigo;
	public boolean isMedicamento;
	public String descripcion;
	public double precio;
	public Laboratorio laboratorio;
	
	public Producto(int codigo, boolean isMedicamento, String descripcion, double precio, Laboratorio laboratorio) {
		super();
		this.codigo = codigo;
		this.isMedicamento = isMedicamento;
		this.descripcion = descripcion;
		this.precio = precio;
		this.laboratorio = laboratorio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isMedicamento() {
		return isMedicamento;
	}
	public void setMedicamento(boolean isMedicamento) {
		this.isMedicamento = isMedicamento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
}
