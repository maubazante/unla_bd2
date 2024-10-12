package com.grupo3.unla.model;

import java.util.List;

public class Sucursal {
	public int id;
	public String nombre;
	public List<Empleado> empleados;
	public Empleado encargado;

	public Sucursal() {
		super();
	}

	public Sucursal(int id, String nombre, List<Empleado> empleados, Empleado encargado) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public double calcularVentasTotales(List<Venta> ventas) {
		return ventas.stream().filter(venta -> venta.getSucursal().equals(this)).mapToDouble(Venta::getTotalVenta)
				.sum();
	}

	public long contarEmpleados(List<Empleado> empleados) {
		return empleados.size();
	}

	public double calcularTotalVentasSucursal() {
		double total = 0;
		for (Empleado empleado : empleados) {
			List<Venta> ventas = empleado.getVentasRealizadas();
			if (ventas != null) {
				for (Venta venta : ventas) {
					total += venta.getTotalVenta();
				}
			}
		}
		return total;
	}


	public double calcularPromedioVentasPorEmpleado() {
		if (empleados.isEmpty()) {
			return 0;
		}
		return calcularTotalVentasSucursal() / empleados.size();
	}

	public boolean tieneEmpleadoEstrella() {
		for (Empleado empleado : empleados) {
			if (empleado.getVentasRealizadas().size() > 100) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", nombre=" + nombre + ", empleados=" + empleados + ", encargado=" + encargado
				+ "]";
	}

}
