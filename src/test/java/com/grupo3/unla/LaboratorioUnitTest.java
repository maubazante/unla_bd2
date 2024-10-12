package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
		assertEquals(200.0, laboratorio.calcularIngresos(productosVendidos), "El ingreso debería ser de 200.0");
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
		laboratorio.agregarProducto(productos.get(0));
		laboratorio.agregarProducto(productos.get(1));
		assertEquals("Producto2", laboratorio.obtenerProductoMasCaro().getDescripcion(),
				"El producto más caro debería ser 'Producto2'.");
	}

	@Test
	public void testHayProductosConPrecioMayorA() {
		List<Producto> productos = List.of(new Producto(101, true, "Producto1", 200.0, laboratorio));
		laboratorio.agregarProducto(productos.get(0));
		assertTrue(laboratorio.tieneProductoMayorA(150.0), "Debería haber productos con precio mayor a 150.0");
	}

	@Test
	public void testAgregarProducto() {
		Producto nuevoProducto = new Producto(103, true, "Producto3", 150.0, laboratorio);
		laboratorio.agregarProducto(nuevoProducto);
		assertEquals(1, laboratorio.obtenerNumeroTotalProductos(), "Debería haber un producto en el laboratorio.");
	}

	@Test
	public void testEliminarProductoPorId() {
		Producto nuevoProducto = new Producto(103, true, "Producto3", 150.0, laboratorio);
		laboratorio.agregarProducto(nuevoProducto);
		boolean eliminado = laboratorio.eliminarProductoPorId(103);
		assertTrue(eliminado, "El producto debería haberse eliminado.");
		assertEquals(0, laboratorio.obtenerNumeroTotalProductos(),
				"Debería haber 0 productos en el laboratorio después de la eliminación.");
	}

	@Test
	public void testObtenerNumeroTotalProductos() {
		laboratorio.agregarProducto(new Producto(101, true, "Producto1", 200.0, laboratorio));
		laboratorio.agregarProducto(new Producto(102, true, "Producto2", 300.0, laboratorio));
		assertEquals(2, laboratorio.obtenerNumeroTotalProductos(), "Debería haber 2 productos en el laboratorio.");
	}

	@Test
	public void testCalcularIngresosTotales() {
		laboratorio.agregarProducto(new Producto(101, true, "Producto1", 200.0, laboratorio));
		laboratorio.agregarProducto(new Producto(102, true, "Producto2", 300.0, laboratorio));
		assertEquals(500.0, laboratorio.calcularIngresosTotales(), "Los ingresos totales deberían ser 500.0.");
	}

	@Test
	public void testCalcularPromedioPreciosConProductos() {
		laboratorio.getProductos().add(new Producto(101, true, "Producto1", 100.0, laboratorio));
		laboratorio.getProductos().add(new Producto(102, true, "Producto2", 200.0, laboratorio));
		laboratorio.getProductos().add(new Producto(103, true, "Producto3", 300.0, laboratorio));

		assertEquals(200.0, laboratorio.calcularPromedioPrecios(), "El promedio de precios debería ser 200.0");
	}

	@Test
	public void testCalcularPromedioPreciosSinProductos() {
		assertEquals(0.0, laboratorio.calcularPromedioPrecios(),
				"El promedio de precios debería ser 0.0 cuando no hay productos.");
	}

	@Test
	public void testAplicarDescuentoLoteConCantidadBajoLimite() {
		int total = 50; // Por debajo del límite de 100
		assertEquals(500.0, laboratorio.aplicarDescuentoLote(total, 10.0),
				"El total después del descuento debería ser 500.0 sin descuento.");
	}

	@Test
	public void testAplicarDescuentoLoteConCantidadEnLimite() {
		int total = 100; // En el límite
		assertEquals(950.0, laboratorio.aplicarDescuentoLote(total, 10.0),
				"El total después del descuento debería ser 950.0 con descuento del 5%.");
	}

	@Test
	public void testTieneProductoMayorAConProductos() {
		laboratorio.getProductos().add(new Producto(101, true, "Producto1", 50.0, laboratorio));
		laboratorio.getProductos().add(new Producto(102, true, "Producto2", 150.0, laboratorio));

		assertTrue(laboratorio.tieneProductoMayorA(100.0), "Debería haber productos con precio mayor a 100.0");
	}

	@Test
	public void testTieneProductoMayorASinProductos() {
		assertFalse(laboratorio.tieneProductoMayorA(100.0), "No debería haber productos con precio mayor a 100.0");
	}

	@Test
	public void testObtenerProductoMasCaroConProductos() {
		laboratorio.getProductos().add(new Producto(101, true, "Producto1", 200.0, laboratorio));
		laboratorio.getProductos().add(new Producto(102, true, "Producto2", 300.0, laboratorio));

		assertEquals("Producto2", laboratorio.obtenerProductoMasCaro().getDescripcion(),
				"El producto más caro debería ser 'Producto2'.");
	}

	@Test
	public void testObtenerProductoMasCaroSinProductos() {
		assertNull(laboratorio.obtenerProductoMasCaro(), "Debería retornar null si no hay productos.");
	}

	@Test
	public void testConstructorLaboratorio() {
		Laboratorio lab = new Laboratorio(123, "Laboratorio Test");
		assertEquals(123, lab.getId());
		assertEquals("Laboratorio Test", lab.getNombre());
	}

}
