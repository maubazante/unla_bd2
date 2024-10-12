package com.grupo3.unla.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	public long cuil;
	public int dni;
	public String nombre;
	public String apellido;
	public String nroAfiliado;
	public ObraSocial obraSocial;
	public Domicilio domicilio;
	public LocalDate fechaIngreso;
	private double salarioBase;
	private List<Venta> ventasRealizadas = new ArrayList<>();

	public Empleado() {
		super();
	}

	// con fechaIngreso
	public Empleado(long cuil, int dni, String nombre, String apellido, String nroAfiliado, ObraSocial obraSocial,
			Domicilio domicilio, LocalDate fechaIngreso) {
		super();
		this.cuil = cuil;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroAfiliado = nroAfiliado;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
		this.fechaIngreso = fechaIngreso;
	}

	public Empleado(long cuil, int dni, String nombre, String apellido, String nroAfiliado, ObraSocial obraSocial,
			Domicilio domicilio) {
		super();
		this.cuil = cuil;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroAfiliado = nroAfiliado;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
		this.fechaIngreso = LocalDate.now();
	}

	public long getCuil() {
		return cuil;
	}

	public void setCuil(long cuil) {
		this.cuil = cuil;
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

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public boolean validarCuil() {
		return String.valueOf(cuil).length() == 11;
	}

	public boolean validarDni() {
		return String.valueOf(dni).length() >= 7 && String.valueOf(dni).length() <= 8;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public List<Venta> getVentasRealizadas() {
		return ventasRealizadas;
	}

	public void setVentasRealizadas(List<Venta> ventasRealizadas) {
		this.ventasRealizadas = ventasRealizadas;
	}

	public Integer calcularAntiguedad() {
		if (fechaIngreso == null) {
			System.out.println("La fecha de ingreso no está asignada.");
			return null;
		}
		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}

	public double calcularBonificacionAnual(int aniosAntiguedad) {
		return salarioBase * (1 + (aniosAntiguedad * 0.05)); // Aumento
	}

	public double calcularSalarioConBonificacion() {
		int antiguedad = Period.between(fechaIngreso, LocalDate.now()).getYears();
		double bonificacion = salarioBase * (antiguedad * 0.01);
		return salarioBase + bonificacion;
	}

	public double calcularTotalVentas() {
		double total = 0;
		for (Venta venta : ventasRealizadas) {
			total += venta.getTotalVenta();
		}
		return total;
	}

	public boolean esVendedorEstrella() {
		return ventasRealizadas.size() > 50;
	}

	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", nroAfiliado=" + nroAfiliado + ", obraSocial=" + obraSocial + ", domicilio=" + domicilio
				+ ", fechaIngreso=" + fechaIngreso + ", salarioBase=" + salarioBase + ", ventasRealizadas="
				+ ventasRealizadas + "]";
	}

}
