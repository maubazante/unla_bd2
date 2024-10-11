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
	
	public void aplicarDescuento(double porcentaje) {
	    if (porcentaje < 0 || porcentaje > 100) {
	        System.out.println("Porcentaje de descuento inválido.");
	        return;
	    }
	    double descuento = this.precio * (porcentaje / 100);
	    this.precio -= descuento;
	    System.out.println("Se aplicó un descuento del " + porcentaje + "%. Precio final: $" + this.precio);
	}
	
	public void actualizarPrecioPorInflacion(double porcentajeInflacion) {
	    if (porcentajeInflacion < 0) {
	        System.out.println("Porcentaje de inflación no válido.");
	        return;
	    }
	    this.precio += this.precio * (porcentajeInflacion / 100);
	    System.out.println("Precio actualizado por inflación. Nuevo precio: $" + this.precio);
	}
	
	public boolean esGenerico() {
	    return this.descripcion.toLowerCase().contains("genérico");
	}
}
