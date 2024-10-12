package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.Producto;
import com.grupo3.unla.model.Sucursal;
import com.grupo3.unla.model.Venta;

public class VentaUnitTest {

	private Venta venta;
	private Empleado empleadoMock;
	private Cliente clienteMock;
	private List<Producto> productosMock;
	private Sucursal sucursalMock;

	@BeforeEach
	public void setUp() {
		empleadoMock = mock(Empleado.class);
		clienteMock = mock(Cliente.class);
		productosMock = new ArrayList<>();
		sucursalMock = mock(Sucursal.class);

		Producto productoMock = mock(Producto.class);
		when(productoMock.getPrecio()).thenReturn(500.0);
		productosMock.add(productoMock);

		venta = new Venta(LocalDate.now(), empleadoMock, "Tarjeta", clienteMock, productosMock, sucursalMock);
	}

	@Test
	public void testGetTotalVenta() {
		assertEquals(500.0, venta.getTotalVenta(), "El total de la venta debería ser 500.0");
	}

	@Test
	public void testAgregarProducto() {
		Producto productoNuevo = mock(Producto.class);
		when(productoNuevo.getPrecio()).thenReturn(300.0);

		venta.agregarProducto(productoNuevo);
		assertEquals(800.0, venta.getTotalVenta(), "El total después de agregar el producto debería ser 800.0");
	}

	@Test
	public void testEliminarProducto() {
		Producto productoAEliminar = productosMock.get(0);
		venta.eliminarProducto(productoAEliminar);
		assertEquals(0.0, venta.getTotalVenta(), "El total después de eliminar el producto debería ser 0.0");
	}

	@Test
	public void testCalcularIva() {
		venta.calcularIVAdelTotal();
		assertEquals(605.0, venta.getTotalVenta(), "El total después de aplicar el 21% del IVA debería ser 605.0");
	}

	@Test
	public void testAgregarEliminarProducto() {
		Producto productoMock = mock(Producto.class);
		when(productoMock.getPrecio()).thenReturn(400.0);

		venta.agregarProducto(productoMock);
		assertEquals(900.0, venta.getTotalVenta(), "El total después de agregar el producto debería ser 900.0");

		venta.eliminarProducto(productoMock);
		assertEquals(500.0, venta.getTotalVenta(),
				"El total después de eliminar el producto debería volver a ser 500.0");
	}

	@Test
	public void testConstructorVentaSinProductos() {
		Venta ventaSinProductos = new Venta(LocalDate.now(), empleadoMock, "Efectivo", clienteMock, new ArrayList<>(),
				sucursalMock);
		assertEquals(0.0, ventaSinProductos.getTotalVenta(),
				"El total de la venta debería ser 0.0 si no hay productos.");
	}

	@Test
	public void testSetFecha() {
		LocalDate nuevaFecha = LocalDate.now().plusDays(1);
		venta.setFecha(nuevaFecha);
		assertEquals(nuevaFecha, venta.getFecha(), "La fecha debería actualizarse correctamente.");
	}

	@Test
	public void testSetEmpleado() {
		Empleado nuevoEmpleado = mock(Empleado.class);
		venta.setEmpleado(nuevoEmpleado);
		assertEquals(nuevoEmpleado, venta.getEmpleado(), "El empleado debería actualizarse correctamente.");
	}

	@Test
	public void testSetCliente() {
		Cliente nuevoCliente = mock(Cliente.class);
		venta.setCliente(nuevoCliente);
		assertEquals(nuevoCliente, venta.getCliente(), "El cliente debería actualizarse correctamente.");
	}

	@Test
	public void testSetFormaDePago() {
		String nuevaFormaDePago = "Transferencia";
		venta.setFormaDePago(nuevaFormaDePago);
		assertEquals(nuevaFormaDePago, venta.getFormaDePago(), "La forma de pago debería actualizarse correctamente.");
	}

	@Test
	public void testEliminarProductoNoExistente() {
		Producto productoNoExistente = mock(Producto.class);
		when(productoNoExistente.getPrecio()).thenReturn(400.0);

		// Eliminar un producto que no está en la lista
		venta.eliminarProducto(productoNoExistente);
		assertEquals(500.0, venta.getTotalVenta(),
				"El total debería seguir siendo 500.0 después de intentar eliminar un producto no existente.");
	}

	@Test
	public void testCalcularIVADesdeTotalVenta() {
		double ivaCalculado = venta.calcularIVAdelTotal();
		assertEquals(105.0, ivaCalculado, "El IVA debería ser 105.0 para un total de 500.0.");
	}

	@Test
	public void testAgregarProductoNulo() {
		assertEquals(500.0, venta.getTotalVenta(), "El total inicial debe ser 500.0.");
		venta.agregarProducto(null);
		assertEquals(500.0, venta.getTotalVenta(), "El total no debería cambiar al intentar agregar un producto nulo.");
	}


	@Test
	public void testCalcularTotalConVariosProductos() {
		Producto productoMock1 = mock(Producto.class);
		when(productoMock1.getPrecio()).thenReturn(300.0);
		productosMock.add(productoMock1);

		double totalCalculado = venta.getTotalVenta();
		assertEquals(800.0, totalCalculado,
				"El total de la venta debería ser 800.0 después de agregar un segundo producto.");
	}

}
