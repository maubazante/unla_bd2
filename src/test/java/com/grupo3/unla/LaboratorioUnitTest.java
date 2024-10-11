package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Laboratorio;
import com.grupo3.unla.model.Producto;

public class LaboratorioUnitTest {

	private Laboratorio laboratorio;

	@BeforeEach
	public void setUp() {
		laboratorio = new Laboratorio(12345, "LabX");
	}

	@Test
	public void testCalcularIngresosPorProductosVendidos() {
		List<Producto> productosVendidos = List.of(new Producto(101, true, "Producto1", 200.0, laboratorio));
		assertEquals(200.0, laboratorio.calcularIngresos(productosVendidos),
				"El ingreso debería ser de 200.0");
	}

	@Test
	public void testAplicarDescuentoPorLote() {
		int total = 1000;
		assertEquals(900.0, laboratorio.aplicarDescuentoLote(total, 10.0),
				"El total después del descuento debería ser 900.0");
	}

	@Test
	public void testObtenerProductoMasCaro() {
		List<Producto> productos = List.of(new Producto(101, true, "Producto1", 200.0, laboratorio),
				new Producto(102, true, "Producto2", 300.0, laboratorio));
		assertEquals("Producto2", laboratorio.obtenerProductoMasCaro(),
				"El producto más caro debería ser 'Producto2'.");
	}

	@Test
	public void testHayProductosConPrecioMayorA() {
		List<Producto> productos = List.of(new Producto(101, true, "Producto1", 200.0, laboratorio));
		assertTrue(laboratorio.tieneProductoMayorA(150.0),
				"Debería haber productos con precio mayor a 150.0");
	}
}
