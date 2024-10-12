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

	public static final int PORCENTAJE_IVA = 21;

	public Venta() {
		super();
	}

	public Venta(LocalDate fecha, Empleado empleado, String formaDePago, Cliente cliente, List<Producto> productos,
			Sucursal sucursal) {
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

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public void agregarProducto(Producto producto) {
		if (producto != null && this.productos != null) {
			this.productos.add(producto);
			this.total = getTotalVenta(); // Recalcular el total después de agregar
			System.out.println("Producto agregado: " + producto.getDescripcion());
		} else {
			System.out.println("No se puede agregar un producto nulo.");
		}
	}

	public void eliminarProducto(Producto producto) {
		if (this.productos != null && this.productos.contains(producto)) {
			this.productos.remove(producto);
			this.total = getTotalVenta(); // Recalcular el total después de eliminar
			System.out.println("Producto eliminado: " + producto.getDescripcion());
		} else {
			System.out.println("El producto no está en la lista.");
		}
	}

	public double calcularIVAdelTotal() {
		double impuestos = this.total * (PORCENTAJE_IVA / 100);
		System.out.println("Impuestos calculados: $" + impuestos);
		return impuestos;
	}

	public double getTotalVenta() {
		float total = 0;
		if (this.productos == null)
			return total;
		for (Producto producto : productos) {
			total += producto.getPrecio();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", ticket=" + ticket + ", empleado=" + empleado + ", cliente=" + cliente
				+ ", sucursal=" + sucursal + ", formaDePago=" + formaDePago + ", total=" + total + ", productos="
				+ productos + "]";
	}
}
