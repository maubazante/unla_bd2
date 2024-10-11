package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.Sucursal;

public class SucursalUnitTest {

	private Sucursal sucursal;
	private List<Empleado> empleadosMock;

	@BeforeEach
	public void setUp() {
		empleadosMock = List.of(mock(Empleado.class), mock(Empleado.class));
		sucursal = new Sucursal(1, "Sucursal 1", empleadosMock, empleadosMock.get(0));
	}

	@Test
	public void testCalcularVentasTotales() {
		when(empleadosMock.get(0).getVentasRealizadas()).then(1000.0);
		when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(2000.0);
		assertEquals(3000.0, sucursal.calcularVentasTotales(), "Las ventas totales deberían ser 3000.0");
	}

	@Test
	public void testContarEmpleadosActivos() {
		when(empleadosMock.get(0)).thenReturn(true);
		when(empleadosMock.get(1)).thenReturn(false);
		assertEquals(1, sucursal.contarEmpleados(sucursal.getEmpleados()), "Debería haber 1 empleado activo.");
	}

	@Test
	public void testPromedioVentasPorEmpleado() {
		when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(1000.0);
		when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(2000.0);
		assertEquals(1500.0, sucursal.calcularPromedioVentasPorEmpleado(),
				"El promedio de ventas por empleado debería ser 1500.0");
	}

	@Test
	public void testTieneEmpleadoEstrella() {
		when(empleadosMock.get(0).esVendedorEstrella()).thenReturn(true);
		assertTrue(sucursal.tieneEmpleadoEstrella(), "Debería haber un empleado estrella.");
	}
}
