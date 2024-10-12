package com.grupo3.unla.model;

public class FormaDePago {
	public int id;
	public String tipo;
	private double montoTotal;

	public FormaDePago() {
		super();
	}

	public FormaDePago(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public double calcularCuota(double monto, int cantidadCuotas, double interesAnual) {
		double tasaMensual = interesAnual / 12 / 100;
		return (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -cantidadCuotas));
	}

	public boolean validarNumeroTarjeta(String numeroTarjeta) {
		int suma = 0;
		boolean alternar = false;
		for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
			int digito = Character.getNumericValue(numeroTarjeta.charAt(i));
			if (alternar) {
				digito *= 2;
				if (digito > 9)
					digito -= 9;
			}
			suma += digito;
			alternar = !alternar;
		}
		return suma % 10 == 0;
	}

	public double calcularRecargo() {
		if ("Tarjeta de Crédito".equalsIgnoreCase(tipo)) {
			return montoTotal * 0.05; // Recargo
		}
		return 0;
	}

	public double calcularMontoConRecargo() {
		return montoTotal + calcularRecargo();
	}

	public boolean esFormaDePagoValida() {
		return "Efectivo".equalsIgnoreCase(tipo) || "Tarjeta de Crédito".equalsIgnoreCase(tipo);
	}

	@Override
	public String toString() {
		return "FormaDePago [id=" + id + ", tipo=" + tipo + ", montoTotal=" + montoTotal + "]";
	}
}
