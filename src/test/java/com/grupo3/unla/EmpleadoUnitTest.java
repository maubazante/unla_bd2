package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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

	@Test
	public void testValidarDni_Valido() {
		empleado.setDni(12345678); // DNI válido
		assertTrue(empleado.validarDni(), "El DNI debería ser válido.");
	}

	@Test
	public void testValidarDni_Invalido_Corto() {
		empleado.setDni(123456); // DNI demasiado corto
		assertFalse(empleado.validarDni(), "El DNI debería ser inválido.");
	}

	@Test
	public void testValidarDni_Invalido_Largo() {
		empleado.setDni(123456789); // DNI demasiado largo
		assertFalse(empleado.validarDni(), "El DNI debería ser inválido.");
	}

	@Test
	public void testCalcularAntiguedad_NullFechaIngreso() {
		empleado.setFechaIngreso(null); // Sin fecha de ingreso
		Integer antiguedad = empleado.calcularAntiguedad();
		assertNull(antiguedad, "La antigüedad debería ser nula cuando no hay fecha de ingreso.");
	}

	@Test
	public void testCalcularBonificacionAnual_MultiplesAnios() {
		empleado.setSalarioBase(2000.0);
		double bonificacion5Anios = empleado.calcularBonificacionAnual(5);
		assertEquals(3000.0, bonificacion5Anios, "La bonificación para 5 años debería ser 3000.0.");

		double bonificacion10Anios = empleado.calcularBonificacionAnual(10);
		assertEquals(7000.0, bonificacion10Anios, "La bonificación para 10 años debería ser 7000.0.");
	}

	@Test
	public void testCalcularSalarioConBonificacion_MultiplesSalarios() {
		empleado.setSalarioBase(3000.0);
		double salarioConBonificacion = empleado.calcularSalarioConBonificacion();
		assertEquals(3300.0, salarioConBonificacion, "El salario con bonificación debería ser 3300.0.");

		empleado.setSalarioBase(5000.0);
		salarioConBonificacion = empleado.calcularSalarioConBonificacion();
		assertEquals(5500.0, salarioConBonificacion, "El salario con bonificación debería ser 5500.0.");
	}
}
