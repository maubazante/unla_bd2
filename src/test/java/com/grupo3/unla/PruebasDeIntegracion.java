package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Domicilio;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.FormaDePago;
import com.grupo3.unla.model.Laboratorio;
import com.grupo3.unla.model.ObraSocial;
import com.grupo3.unla.model.Producto;
import com.grupo3.unla.model.Sucursal;
import com.grupo3.unla.model.Venta;

public class PruebasDeIntegracion {

	@Test
	public void testVentaConDescuentoFidelidadYObraSocial() {
		// Crear ObraSocial y agregar medicamentos cubiertos
		ObraSocial obraSocial = new ObraSocial(1, "OSDE");
		Producto medicamentoCubierto = new Producto(1, true, "Amoxicilina", 1000.0, null);
		obraSocial.getMedicamentosCubiertos().add(medicamentoCubierto);

		// Crear Cliente con historial de compras y afiliado a la ObraSocial
		Cliente cliente = new Cliente(12345678, "Juan", "Perez", null, obraSocial, "OS123");
		cliente.setHistorialCompras(new ArrayList<>());
		// Simular antigüedad mayor a 5 años
		LocalDate fechaRegistro = LocalDate.now().minusYears(6);

		// Crear Productos
		Producto productoNoCubierto = new Producto(2, true, "Ibuprofeno", 500.0, null);
		Producto productoNoMedicamento = new Producto(3, false, "Shampoo", 200.0, null);

		// Crear Venta con los productos
		List<Producto> productos = Arrays.asList(medicamentoCubierto, productoNoCubierto, productoNoMedicamento);
		Empleado empleado = new Empleado(20304050607L, 98765432, "Ana", "Gomez", "A123", null, null);

		Venta venta = new Venta(LocalDate.now(), empleado, "Efectivo", cliente, productos, null);

		// Agregar venta al historial del cliente
		cliente.getHistorialCompras().add(venta);

		// Calcular total con descuentos
		double totalEsperado = 0.0;
		// Medicamento cubierto por ObraSocial con 50% de descuento
		totalEsperado += medicamentoCubierto.getPrecio() * 0.5;
		// Medicamento no cubierto sin descuento
		totalEsperado += productoNoCubierto.getPrecio();
		// Producto no medicamento sin descuento
		totalEsperado += productoNoMedicamento.getPrecio();

		// Aplicar descuento por fidelidad (10% si antigüedad > 5 años)
		totalEsperado = cliente.aplicarDescuentoFidelidad(totalEsperado, fechaRegistro);

		assertEquals(totalEsperado, venta.getTotalVenta(), 0.01,
				"El total de la venta con descuentos debería ser correcto.");
	}

	@Test
	public void testActualizarVentasTotalesSucursalConVentasDeEmpleados() {
		// Crear Empleados
		Empleado empleado1 = new Empleado(20304050607L, 87654321, "Carlos", "Diaz", "B456", null, null);
		empleado1.setVentasRealizadas(new ArrayList<>());
		Empleado empleado2 = new Empleado(20304050608L, 87654322, "Lucia", "Fernandez", "B457", null, null);
		empleado2.setVentasRealizadas(new ArrayList<>());

		// Crear Sucursal
		Sucursal sucursal = new Sucursal(1, "Sucursal Centro", Arrays.asList(empleado1, empleado2), empleado1);

		// Crear Productos
		Producto producto1 = new Producto(1, false, "Jabón", 50.0, null);
		Producto producto2 = new Producto(2, false, "Pasta dental", 80.0, null);

		// Crear Ventas
		Venta venta1 = new Venta(LocalDate.now(), empleado1, "Efectivo", null, Arrays.asList(producto1), sucursal);
		Venta venta2 = new Venta(LocalDate.now(), empleado2, "Tarjeta de Crédito", null, Arrays.asList(producto2),
				sucursal);

		// Agregar ventas a los empleados
		empleado1.getVentasRealizadas().add(venta1);
		empleado2.getVentasRealizadas().add(venta2);

		// Calcular ventas totales de la sucursal
		double totalVentasSucursal = sucursal.calcularTotalVentasSucursal();

		// Verificar el total
		double totalEsperado = producto1.getPrecio() + producto2.getPrecio();
		assertEquals(totalEsperado, totalVentasSucursal, 0.01,
				"El total de ventas de la sucursal debería ser correcto.");
	}

	@Test
	public void testValidarDireccionCliente() {
		// Crear Domicilio
		Domicilio domicilio = new Domicilio(1, "123", "Calle Falsa", "Springfield", "Buenos Aires");

		// Validar dirección y longitud de campos
		assertTrue(domicilio.validarDireccion(), "La dirección del domicilio debería ser válida.");
		assertTrue(domicilio.validarLongitudCampos(), "La longitud de los campos del domicilio debería ser válida.");

		// Asignar domicilio a Cliente
		Cliente cliente = new Cliente(12345678, "Homer", "Simpson", domicilio);

		// Verificar que el domicilio del cliente es válido
		assertNotNull(cliente.getDomicilio(), "El cliente debería tener un domicilio asignado.");
		assertEquals(domicilio, cliente.getDomicilio(), "El domicilio del cliente debería ser el asignado.");
	}

	@Test
	public void testCalculoSalarioConBonificacionBasadoEnVentas() {
		// Crear Empleado con salario base y fecha de ingreso
		Empleado empleado = new Empleado(20304050607L, 87654321, "Laura", "Suarez", "D012", null, null,
				LocalDate.now().minusYears(5));
		empleado.setSalarioBase(5000.0);
		empleado.setVentasRealizadas(new ArrayList<>());

		// Crear Ventas realizadas por el empleado
		Producto producto1 = new Producto(1, false, "Producto X", 1000.0, null);
		Producto producto2 = new Producto(2, false, "Producto Y", 2000.0, null);
		Venta venta1 = new Venta(LocalDate.now(), empleado, "Efectivo", null, Arrays.asList(producto1), null);
		Venta venta2 = new Venta(LocalDate.now(), empleado, "Efectivo", null, Arrays.asList(producto2), null);
		empleado.getVentasRealizadas().addAll(Arrays.asList(venta1, venta2));

		// Calcular salario con bonificación
		double salarioConBonificacion = empleado.calcularSalarioConBonificacion();

		// Calcular bonificación esperada
		int antiguedad = empleado.calcularAntiguedad();
		double bonificacionEsperada = empleado.getSalarioBase() * (antiguedad * 0.01);
		double salarioEsperado = empleado.getSalarioBase() + bonificacionEsperada;

		assertEquals(salarioEsperado, salarioConBonificacion, 0.01,
				"El salario con bonificación debería ser correcto.");
	}

	@Test
	public void testValidarTarjetaYCalcularRecargo() {
		// Crear FormaDePago con tipo Tarjeta de Crédito
		FormaDePago formaDePago = new FormaDePago(1, "Tarjeta de Crédito");
		formaDePago.setMontoTotal(1000.0);

		// Validar número de tarjeta (usando un número válido de prueba)
		String numeroTarjetaValido = "4539578763621486"; // Número válido para Luhn Algorithm
		assertTrue(formaDePago.validarNumeroTarjeta(numeroTarjetaValido), "El número de tarjeta debería ser válido.");

		// Calcular recargo
		double recargo = formaDePago.calcularRecargo();
		double montoConRecargo = formaDePago.calcularMontoConRecargo();

		assertEquals(50.0, recargo, 0.01, "El recargo debería ser del 5% del monto total.");
		assertEquals(1050.0, montoConRecargo, 0.01, "El monto con recargo debería ser correcto.");
	}

	@Test
	public void testCalcularIngresosLaboratoriosPostVenta() {
		// Crear Laboratorios
		Laboratorio lab1 = new Laboratorio(1, "Lab A");
		Laboratorio lab2 = new Laboratorio(2, "Lab B");

		// Crear Productos y asignar a laboratorios
		Producto prod1 = new Producto(1, true, "Med A1", 100.0, lab1);
		Producto prod2 = new Producto(2, true, "Med B1", 200.0, lab2);
		lab1.getProductos().add(prod1);
		lab2.getProductos().add(prod2);

		// Crear Venta con productos de diferentes laboratorios
		Venta venta = new Venta(LocalDate.now(), null, "Efectivo", null, Arrays.asList(prod1, prod2), null);

		// Calcular ingresos de cada laboratorio
		double ingresosLab1 = lab1.calcularIngresos(venta.getProductos());
		double ingresosLab2 = lab2.calcularIngresos(venta.getProductos());

		// Verificar ingresos
		assertEquals(100.0, ingresosLab1, 0.01, "El ingreso del Lab A debería ser 100.0.");
		assertEquals(200.0, ingresosLab2, 0.01, "El ingreso del Lab B debería ser 200.0.");
	}

	@Test
	public void testAplicarDescuentoProductoEnVenta() {
		// Crear Producto
		Producto producto = new Producto(1, false, "Crema", 100.0, null);

		// Aplicar descuento del 10%
		producto.aplicarDescuento(10.0);

		// Verificar precio actualizado
		assertEquals(90.0, producto.getPrecio(), 0.01,
				"El precio del producto debería ser 90.0 después del descuento.");

		// Crear Venta con el producto
		Venta venta = new Venta(LocalDate.now(), null, "Efectivo", null, Arrays.asList(producto), null);

		// Verificar total de la venta
		assertEquals(90.0, venta.getTotalVenta(), 0.01,
				"El total de la venta debería reflejar el precio con descuento.");
	}

	@Test
	public void testCalcularReintegroObraSocialEnVenta() {
		// Crear ObraSocial con plan Premium
		ObraSocial obraSocial = new ObraSocial(1, "Swiss Medical");
		String plan = "Premium";

		// Crear Cliente afiliado
		Cliente cliente = new Cliente(12345678, "Luis", "Martinez", null, obraSocial, "SM789");

		// Crear Producto (consulta médica)
		Producto consultaMedica = new Producto(1, false, "Consulta Médica", 1000.0, null);

		// Crear Venta
		Venta venta = new Venta(LocalDate.now(), null, "Efectivo", cliente, Arrays.asList(consultaMedica), null);

		// Calcular reintegro
		double reintegro = obraSocial.calcularReintegro(consultaMedica.getPrecio(), plan);
		double totalEsperado = consultaMedica.getPrecio() - reintegro;

		assertEquals(totalEsperado, venta.getTotalVenta(), 0.01,
				"El total de la venta debería reflejar el reintegro de ObraSocial.");
	}

	@Test
	public void testAsignarProductosAlLaboratorioYObtenerMasCaro() {
		// Crear Laboratorio
		Laboratorio laboratorio = new Laboratorio(1, "LabCorp");

		// Crear Productos y asignar al laboratorio
		Producto producto1 = new Producto(1, true, "Medicamento A", 100.0, laboratorio);
		Producto producto2 = new Producto(2, true, "Medicamento B", 200.0, laboratorio);
		laboratorio.getProductos().addAll(Arrays.asList(producto1, producto2));

		// Obtener producto más caro
		Producto masCaro = laboratorio.obtenerProductoMasCaro();

		// Verificar que es el correcto
		assertEquals(producto2, masCaro, "El producto más caro debería ser 'Medicamento B'.");
	}

	@Test
	public void testProcesarVentaConFormaDePagoYCalculoIVA() {
		// Crear FormaDePago válida
		FormaDePago formaDePago = new FormaDePago(1, "Efectivo");
		assertTrue(formaDePago.esFormaDePagoValida(), "La forma de pago debería ser válida.");

		// Crear Producto
		Producto producto = new Producto(1, false, "Perfume", 1000.0, null);

		// Crear Venta
		Venta venta = new Venta(LocalDate.now(), null, formaDePago.getTipo(), null, Arrays.asList(producto), null);

		// Calcular IVA del total
		double iva = venta.calcularIVAdelTotal();
		double totalConIVA = venta.getTotalVenta() + iva;

		// Verificar cálculos
		assertEquals(210.0, iva, 0.01, "El IVA debería ser el 21% del total.");
		assertEquals(1210.0, totalConIVA, 0.01, "El total con IVA debería ser correcto.");
	}
}
