package com.grupo3.unla.model;

import java.util.ArrayList;
import java.util.List;

public class ObraSocial {
	public int id;
	public String nombre;
	private List<Cliente> afiliados = new ArrayList<>();
	private List<Producto> medicamentosCubiertos = new ArrayList<>();

	public ObraSocial() {
		super();
	}

	public ObraSocial(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public List<Producto> getMedicamentosCubiertos() {
		return medicamentosCubiertos;
	}

	public void setMedicamentosCubiertos(List<Producto> medicamentosCubiertos) {
		this.medicamentosCubiertos = medicamentosCubiertos;
	}

	public double calcularReintegro(double montoConsulta, String plan) {
		switch (plan) {
		case "Basico":
			return montoConsulta * 0.50;
		case "Intermedio":
			return montoConsulta * 0.70;
		case "Premium":
			return montoConsulta * 0.90;
		default:
			return 0;
		}
	}

	public boolean verificarCoberturaMedicamento(Producto producto) {
		return medicamentosCubiertos.contains(producto.getCodigo());
	}

	public int calcularTotalAfiliados() {
		return afiliados.size();
	}

	public double calcularPorcentajeClientesActivos() {
		int clientesActivos = 0;
		for (Cliente cliente : afiliados) {
			if (!cliente.getHistorialCompras().isEmpty()) {
				clientesActivos++;
			}
		}
		return (double) clientesActivos / afiliados.size() * 100;
	}

	public boolean tieneClienteConMasDeVentas(int cantidadVentas) {
		for (Cliente cliente : afiliados) {
			if (cliente.getHistorialCompras().size() > cantidadVentas) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "ObraSocial [id=" + id + ", nombre=" + nombre + ", afiliados=" + afiliados + ", medicamentosCubiertos="
				+ medicamentosCubiertos + "]";
	}
}
