package com.grupo3.unla.model;

import java.time.LocalDate;
import java.util.List;

import com.grupo.unla.dto.SucursalDTO;
import com.grupo3.unla.utils.MathHelper;

public class Venta {
	public LocalDate fecha;
	public String ticket;
	public Empleado empleado;
	public Cliente cliente;
	public SucursalDTO sucursal;
	public String formaDePago;
	public double total;
	public List<Producto> productos;
	
	public Venta(LocalDate fecha, Empleado empleado, String formaDePago, Cliente cliente, List<Producto> productos, Sucursal sucursal) {
		super();
		SucursalDTO sucursalDTO = new SucursalDTO(sucursal);
		
		this.fecha = fecha;
		this.empleado = empleado;
		this.cliente = cliente;
		this.formaDePago = formaDePago;
		this.productos = productos;
		this.total = getTotalVenta();
		this.sucursal = sucursalDTO;
		this.ticket = MathHelper.generarNumeroTicket(sucursalDTO);
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

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	private double getTotalVenta() {
		float total = 0;
		if(this.productos == null) return total;
		for(Producto prodIt: this.productos) {
			total += prodIt.getPrecio();
		}
		return total;
	}
}
