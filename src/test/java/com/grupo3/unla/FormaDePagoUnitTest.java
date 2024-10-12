package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.FormaDePago;

public class FormaDePagoUnitTest {

	private FormaDePago formaDePago;

	@BeforeEach
	public void setUp() {
		formaDePago = new FormaDePago(1, "Tarjeta de Crédito");
		formaDePago.setMontoTotal(100.0);
	}

	@Test
	public void testCalcularCuotaConDatosValidos() {
		double cuota = formaDePago.calcularCuota(1000.0, 12, 12.0);
		assertEquals(88.85, cuota, 0.01, "La cuota calculada debería ser correcta");
	}

	@Test
	public void testCalcularCuotaConInteresCero() {
		double cuota = formaDePago.calcularCuota(1000.0, 12, 0.0);
		assertEquals(83.33, cuota, 0.01, "La cuota calculada debería ser correcta con interés cero");
	}

	@Test
	public void testCalcularRecargoConTarjetaCredito() {
		double recargo = formaDePago.calcularRecargo();
		assertEquals(5.0, recargo, 0.01, "El recargo para tarjeta de crédito debería ser 5.0");
	}

	@Test
	public void testCalcularRecargoConEfectivo() {
		formaDePago.setTipo("Efectivo");
		double recargo = formaDePago.calcularRecargo();
		assertEquals(0.0, recargo, 0.01, "No debería haber recargo para efectivo");
	}

	@Test
	public void testCalcularMontoConRecargo() {
		double montoConRecargo = formaDePago.calcularMontoConRecargo();
		assertEquals(105.0, montoConRecargo, 0.01, "El monto con recargo debería ser 105.0");
	}

	@Test
	public void testEsFormaDePagoValidaConEfectivo() {
		formaDePago.setTipo("Efectivo");
		assertTrue(formaDePago.esFormaDePagoValida(), "La forma de pago debe ser válida para efectivo");
	}

	@Test
	public void testEsFormaDePagoValidaConTarjetaCredito() {
		assertTrue(formaDePago.esFormaDePagoValida(), "La forma de pago debe ser válida para tarjeta de crédito");
	}

	@Test
	public void testEsFormaDePagoValidaConTipoInvalido() {
		formaDePago.setTipo("Cheque");
		assertFalse(formaDePago.esFormaDePagoValida(), "La forma de pago no debe ser válida para tipos inválidos");
	}

	@Test
	public void testValidarNumeroTarjetaValido() {
		assertTrue(formaDePago.validarNumeroTarjeta("4532015112830366"), "El número de tarjeta debe ser válido");
	}

	@Test
	public void testValidarNumeroTarjetaInvalido() {
		assertFalse(formaDePago.validarNumeroTarjeta("1234567890123456"), "El número de tarjeta debe ser inválido");
	}

	@Test
	public void testToString() {
		String expectedString = "FormaDePago [id=1, tipo=Tarjeta de Crédito, montoTotal=100.0]";
		assertEquals(expectedString, formaDePago.toString(),
				"El método toString debería retornar la representación correcta");
	}
}
