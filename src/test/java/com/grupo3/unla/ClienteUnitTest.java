package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Domicilio;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.Laboratorio;
import com.grupo3.unla.model.ObraSocial;
import com.grupo3.unla.model.Producto;
import com.grupo3.unla.model.Sucursal;
import com.grupo3.unla.model.Venta;

public class ClienteUnitTest {

	private Cliente cliente;
	public static final String PAGO_EFECTIVO = "EFECTIVO";
	public static final String PAGO_DEBITO = "DEBITO";
	public static final String PAGO_CREDITO = "CREDITO";

	@BeforeEach
	public void setUp() {
		cliente = new Cliente(1, "John", "Doe");
	}

	@Test
	public void testGetNombreCompleto() {
		String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();
		assertEquals("John Doe", nombreCompleto, "El nombre completo debería ser 'John Doe'.");
	}

	@Test
	public void testActualizarDireccion() {
		Domicilio nuevoDomicilio = new Domicilio(1, "456", "Nueva Calle", "Springfield", "Cordoba");
		cliente.setDomicilio(nuevoDomicilio);
		assertEquals(nuevoDomicilio, cliente.getDomicilio(), "El domicilio debería haberse actualizado.");
	}

	@Test
	public void testAplicarDescuento() {
		Empleado empleado_1 = new Empleado(Long.valueOf("20666666663"), 66666666, "ESTESEL", "JEFE", "08001345",
				new ObraSocial(2, "OSECAC"), new Domicilio(6, "20", "PRES. PERON", "LOMAS DE ZAMORA", "BS AS"));
		Empleado empleado_2 = new Empleado(Long.valueOf("20777777773"), 77777777, "ESTESNOESEL", "JEFE", "08001346",
				new ObraSocial(2, "OSECAC"), new Domicilio(7, "19", "PRES. PERON", "MORON", "BS AS"));
		Empleado empleado_3 = new Empleado(Long.valueOf("20888888883"), 88888888, "PELAZO", "ADRIAN", "08001347",
				new ObraSocial(2, "OSECAC"), new Domicilio(8, "1412", "PRES. PERON", "LUJAN", "BS AS"));

		Cliente cliente_1 = new Cliente(11111111, "JUAN", "ROMAN",
				new Domicilio(1, "12", "LUZURIAGA", "TEMPERLEY", "BS AS"), new ObraSocial(1, "OSDE"), "08001213");

		List<Producto> productos_venta1 = new ArrayList<>();
		Producto producto_4 = new Producto(4, true, "Enalapril", 5000, new Laboratorio(4, "Elea"));
		Producto producto_5 = new Producto(5, false, "Perfume Paco", 26000, null);
		Producto producto_6 = new Producto(6, false, "Issey Miyake", 180000, null);
		productos_venta1.add(producto_4);
		productos_venta1.add(producto_5);
		productos_venta1.add(producto_6);

		List<Empleado> empleadosLanus = new ArrayList<>();
		empleadosLanus.add(empleado_1);
		empleadosLanus.add(empleado_2);
		empleadosLanus.add(empleado_3);
		Sucursal sucursal_lanus = new Sucursal(2, "LANUS", empleadosLanus, empleado_3);

		cliente_1.getHistorialCompras().add(
				new Venta(LocalDate.now(), empleado_1, PAGO_EFECTIVO, cliente_1, productos_venta1, sucursal_lanus));

		double totalCompra = cliente_1.calcularMontoTotalCompras(); // Obtiene el total de compras
		double descuento = cliente_1.aplicarDescuentoFidelidad(totalCompra, LocalDate.now()); // Aplica el descuento

		double descuentoEsperado = (cliente_1.calcularAntiguedadCliente(LocalDate.now()) > 5) ? totalCompra * 0.90
				: totalCompra;

		assertEquals(descuentoEsperado, descuento, "El descuento aplicado debería ser del 10%.");
	}

	@Test
    public void testMontoTotalDeVentas() {
		Empleado empleado_1 = new Empleado(Long.valueOf("20666666663"), 66666666, "ESTESEL", "JEFE", "08001345",
				new ObraSocial(2, "OSECAC"), new Domicilio(6, "20", "PRES. PERON", "LOMAS DE ZAMORA", "BS AS"));
		Empleado empleado_2 = new Empleado(Long.valueOf("20777777773"), 77777777, "ESTESNOESEL", "JEFE", "08001346",
				new ObraSocial(2, "OSECAC"), new Domicilio(7, "19", "PRES. PERON", "MORON", "BS AS"));
		Empleado empleado_3 = new Empleado(Long.valueOf("20888888883"), 88888888, "PELAZO", "ADRIAN", "08001347",
				new ObraSocial(2, "OSECAC"), new Domicilio(8, "1412", "PRES. PERON", "LUJAN", "BS AS"));
		Cliente cliente_1 = new Cliente(11111111, "JUAN", "ROMAN",
				new Domicilio(1, "12", "LUZURIAGA", "TEMPERLEY", "BS AS"), new ObraSocial(1, "OSDE"), "08001213");
		List<Producto> productos_venta1 = new ArrayList<>();
		Producto producto_4 = new Producto(4, true, "Enalapril", 5000, new Laboratorio(4, "Elea"));
		Producto producto_5 = new Producto(5, false, "Perfume Paco", 26000, null);
		Producto producto_6 = new Producto(6, false, "Issey Miyake", 180000, null);
		productos_venta1.add(producto_4);
		productos_venta1.add(producto_5);
		productos_venta1.add(producto_6);
		List<Empleado> empleadosLanus = new ArrayList<>();
		empleadosLanus.add(empleado_1);
		empleadosLanus.add(empleado_2);
		empleadosLanus.add(empleado_3);
		Sucursal sucursal_lanus = new Sucursal(2, "LANUS", empleadosLanus, empleado_3);
        cliente.getHistorialCompras().add(new Venta(LocalDate.now(), empleado_1, PAGO_EFECTIVO, cliente_1, productos_venta1,
				sucursal_lanus)); // Crear una venta de ejemplo
        double totalVentas = cliente.calcularMontoTotalCompras();
        assertEquals(500.0, totalVentas, "El total de ventas debería ser 500.0.");
    }

	@Test
	public void testClienteFrecuente() {
		boolean esFrecuente = cliente.esClienteFrecuente();
		assertTrue(esFrecuente, "El cliente debería ser considerado frecuente.");
	}

	@Test
	public void testUltimaVenta() {
		Venta ultimaVenta = cliente.obtenerUltimaVenta();
		assertNotNull(ultimaVenta, "El cliente debería tener una última venta.");
	}

	@Test
	public void testSetDomicilio() {
		Domicilio nuevoDomicilio = new Domicilio(2, "789", "Otra Calle", "Springfield", "Cordoba");
		cliente.setDomicilio(nuevoDomicilio);
		assertEquals(nuevoDomicilio, cliente.getDomicilio(), "El domicilio debería haberse actualizado correctamente.");
	}

	@Test
	public void testClienteSinCompras() {
		double totalCompras = cliente.calcularMontoTotalCompras();
		assertEquals(0.0, totalCompras, "El total de compras debería ser 0.0 si no hay compras registradas.");
	}

	@Test
	public void testCalcularAntiguedadCliente() {
		cliente.getHistorialCompras()
				.add(new Venta(LocalDate.now().minusYears(6), null, null, cliente, new ArrayList<>(), null));
		double antiguedad = cliente.calcularAntiguedadCliente(LocalDate.now());
		assertEquals(6, antiguedad, "La antigüedad del cliente debería ser de 6 años.");
	}

	@Test
	public void testDescuentoSinCompras() {
		double descuento = cliente.aplicarDescuentoFidelidad(0.0, LocalDate.now());
		assertEquals(0.0, descuento, "El descuento aplicado debería ser 0.0 si no hay compras.");
	}

	@Test
	public void testHistorialComprasVacio() {
		List<Venta> historial = cliente.getHistorialCompras();
		assertTrue(historial.isEmpty(), "El historial de compras debería estar vacío si no se han realizado compras.");
	}

}
