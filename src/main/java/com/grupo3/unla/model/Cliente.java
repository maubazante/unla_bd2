package com.grupo3.unla.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public int dni;
	public String nombre;
	public String apellido;
	public Domicilio domicilio;
	public ObraSocial obraSocial;
	public String nroAfiliado;
	private List<Venta> historialCompras = new ArrayList<>();

	public Cliente(int dni, String nombre, String apellido, Domicilio domicilio) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
	}

	public Cliente(int dni, String nombre, String apellido, Domicilio domicilio, ObraSocial obraSocial,
			String nroAfiliado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.obraSocial = obraSocial;
		this.nroAfiliado = nroAfiliado;
	}

	public Cliente(int dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public List<Venta> getHistorialCompras() {
		return historialCompras;
	}

	public void setHistorialCompras(List<Venta> historialCompras) {
		this.historialCompras = historialCompras;
	}

	public int calcularAntiguedadCliente(LocalDate fechaRegistro) {
		return Period.between(fechaRegistro, LocalDate.now()).getYears();
	}

	public double aplicarDescuentoFidelidad(double totalCompra, LocalDate fechaRegistro) {
		int antiguedad = calcularAntiguedadCliente(fechaRegistro);
		if (antiguedad > 5) {
			return totalCompra * 0.90; // Descuento
		}
		return totalCompra;
	}

	public double calcularMontoTotalCompras() {
		double total = 0;
		for (Venta venta : historialCompras) {
			total += venta.getTotalVenta();
		}
		return total;
	}

	public boolean esClienteFrecuente() {
		return historialCompras.size() > 5;
	}

	public Venta obtenerUltimaVenta() {
		if (historialCompras.isEmpty()) {
			return null;
		}
		return historialCompras.get(historialCompras.size() - 1);
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", obraSocial=" + obraSocial + ", nroAfiliado=" + nroAfiliado + ", historialCompras="
				+ historialCompras + "]";
	}

}
