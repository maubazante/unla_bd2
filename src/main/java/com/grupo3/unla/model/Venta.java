package com.grupo3.unla.model;

import java.time.LocalDate;

import com.grupo3.unla.utils.MathHelper;

public class Venta {
	public LocalDate fecha;
	public String ticket;
	public Empleado empleado;
	public Cliente cliente;
	public FormaDePago forCobro;
	public Sucursal sucursal;
	
	public Venta(LocalDate fecha, Empleado empleado, Cliente cliente, FormaDePago forCobro) {
		super();
		this.fecha = fecha;
		this.empleado = empleado;
		this.cliente = cliente;
		this.forCobro = forCobro;
		this.ticket = MathHelper.generarNumeroTicket(sucursal);
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public FormaDePago getForCobro() {
		return forCobro;
	}
	public void setForCobro(FormaDePago forCobro) {
		this.forCobro = forCobro;
	}
}
