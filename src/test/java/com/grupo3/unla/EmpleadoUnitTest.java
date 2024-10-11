package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Domicilio;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.ObraSocial;

public class EmpleadoUnitTest {

	private Empleado empleado;
	private ObraSocial obraSocialMock;
	private Domicilio domicilioMock;

	@BeforeEach
	public void setUp() {
		obraSocialMock = mock(ObraSocial.class);
		domicilioMock = mock(Domicilio.class);
		empleado = new Empleado(12345678901L, 12345678, "Jane", "Doe", "A1234", obraSocialMock, domicilioMock);
	}

	@Test
	public void testCalcularAntiguedad() {
		empleado.setFechaIngreso(LocalDate.of(2015, 1, 1));
		assertEquals(9, empleado.calcularAntiguedad(), "La antigüedad debería ser de 9 años.");
	}

	@Test
	public void testValidarCuil() {
		assertTrue(empleado.validarCuil(), "El CUIL debería ser válido.");
	}

	@Test
	public void testBonificaciones() {
		double bonificacion = empleado.calcularBonificacionAnual(1);
		assertEquals(1000.0, bonificacion, "La bonificación debería ser 1000.0.");
	}

	@Test
	public void testSalarioConBonificacion() {
		double salarioConBonificacion = empleado.calcularSalarioConBonificacion();
		assertEquals(5000.0, salarioConBonificacion, "El salario con bonificación debería ser 5000.0.");
	}

	@Test
	public void testVentasTotales() {
		double ventasTotales = empleado.calcularTotalVentas();
		assertEquals(15000.0, ventasTotales, "El total de ventas debería ser 15000.0.");
	}

	@Test
	public void testVendedorEstrella() {
		boolean esEstrella = empleado.esVendedorEstrella();
		assertTrue(esEstrella, "El empleado debería ser considerado un vendedor estrella.");
	}
}
