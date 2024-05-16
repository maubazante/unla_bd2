package com.grupo3.unla.model;

import java.util.List;

public class Sucursal {
	public int id;
	public String nombre;
	public Venta venta;
	public List<Empleado> empleados;
	public Empleado encargado;
	
	public Sucursal(int id, String nombre, Venta venta, List<Empleado> empleados, Empleado encargado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.venta = venta;
		this.empleados = empleados;
		this.encargado = encargado;
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
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public Empleado getEncargado() {
		return encargado;
	}
	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}
}
