package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.ObraSocial;
import com.grupo3.unla.model.Producto;
import com.grupo3.unla.model.Venta;

public class ObraSocialUnitTest {

	private ObraSocial obraSocial;
	private Cliente clienteMock;
	private Producto productoMock;

	@BeforeEach
	public void setUp() {
		obraSocial = new ObraSocial(1, "Obra Social Test");
		clienteMock = mock(Cliente.class);
		productoMock = mock(Producto.class);
	}

	@Test
	public void testCalcularReintegroBasico() {
		double reintegro = obraSocial.calcularReintegro(100.0, "Basico");
		assertEquals(50.0, reintegro, 0.01, "El reintegro para el plan básico debería ser 50");
    }

	@Test
    public void testCalcularReintegroIntermedio() {
        double reintegro = obraSocial.calcularReintegro(100.0, "Intermedio");
        assertEquals(70.0, reintegro, 0.01, "El reintegro para el plan intermedio debería ser 70");
    }

	@Test
    public void testCalcularReintegroPremium() {
        double reintegro = obraSocial.calcularReintegro(100.0, "Premium");
		assertEquals(90.0, reintegro, 0.01, "El reintegro para el plan premium debería ser 90");
	}

	@Test
	public void testCalcularReintegroPlanInvalido() {
		double reintegro = obraSocial.calcularReintegro(100.0, "Invalido");
		assertEquals(0.0, reintegro, 0.01, "El reintegro para un plan inválido debería ser 0");
	}

	@Test
	public void testVerificarCoberturaMedicamentoCubierto() {
		when(productoMock.getCodigo()).thenReturn(123);
		obraSocial.getMedicamentosCubiertos().add(productoMock);

		boolean cubierto = obraSocial.verificarCoberturaMedicamento(productoMock);
		assertTrue(cubierto, "El medicamento debería estar cubierto");
	}

	@Test
	public void testVerificarCoberturaMedicamentoNoCubierto() {
		when(productoMock.getCodigo()).thenReturn(456);

		boolean cubierto = obraSocial.verificarCoberturaMedicamento(productoMock);
		assertFalse(cubierto, "El medicamento no debería estar cubierto");
	}

	@Test
	public void testCalcularTotalAfiliados() {
		obraSocial.getAfiliados().add(clienteMock);
		int totalAfiliados = obraSocial.calcularTotalAfiliados();
		assertEquals(1, totalAfiliados, "El total de afiliados debería ser 1");
	}

	@Test
	public void testCalcularPorcentajeClientesActivos() {
		List<Cliente> clientes = new ArrayList<>();

		Venta ventaMock = mock(Venta.class);

		when(clienteMock.getHistorialCompras()).thenReturn(List.of(ventaMock)); // Cliente activo

		// Mock cliente sin historial de compras
		Cliente clienteInactivoMock = mock(Cliente.class);
		when(clienteInactivoMock.getHistorialCompras()).thenReturn(new ArrayList<>()); // Cliente inactivo

		clientes.add(clienteMock); // Agrega cliente activo
		clientes.add(clienteInactivoMock); // Agrega cliente inactivo

		obraSocial.getAfiliados().addAll(clientes);

		double porcentajeActivos = obraSocial.calcularPorcentajeClientesActivos();
		assertEquals(50.0, porcentajeActivos, 0.01, "El porcentaje de clientes activos debería ser 50%");
	}

	@Test
	public void testTieneClienteConMasDeVentas() {
		Venta ventaMock1 = mock(Venta.class);
		Venta ventaMock2 = mock(Venta.class);

		when(clienteMock.getHistorialCompras()).thenReturn(List.of(ventaMock1, ventaMock2));

		obraSocial.getAfiliados().add(clienteMock);
		boolean tieneCliente = obraSocial.tieneClienteConMasDeVentas(1);
		assertTrue(tieneCliente, "Debería haber un cliente con más de 1 venta");
	}

	@Test
    public void testNoTieneClienteConMasDeVentas() {
        when(clienteMock.getHistorialCompras()).thenReturn(new ArrayList<>());

        obraSocial.getAfiliados().add(clienteMock);
        boolean tieneCliente = obraSocial.tieneClienteConMasDeVentas(0);
        assertFalse(tieneCliente, "No debería haber un cliente con más de 0 ventas");
    }

	@Test
    public void testToString() {
        String expectedString = "ObraSocial [id=1, nombre=Obra Social Test, afiliados=[], medicamentosCubiertos=[]]";
        assertEquals(expectedString, obraSocial.toString(),
				"El método toString debería retornar la representación correcta");
	}
}
