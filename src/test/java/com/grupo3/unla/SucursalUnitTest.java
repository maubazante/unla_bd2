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
import com.grupo3.unla.model.Venta;

public class SucursalUnitTest {

    private Sucursal sucursal;
    private List<Empleado> empleadosMock;
    private List<Venta> ventasMock;

    @BeforeEach
    public void setUp() {
        empleadosMock = List.of(mock(Empleado.class), mock(Empleado.class));
        ventasMock = List.of(mock(Venta.class), mock(Venta.class));
        sucursal = new Sucursal(1, "Sucursal 1", empleadosMock, empleadosMock.get(0));
    }

    @Test
    public void testCalcularVentasTotales() {
        when(ventasMock.get(0).getTotalVenta()).thenReturn(1000.0);
        when(ventasMock.get(1).getTotalVenta()).thenReturn(2000.0);
        
        when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(0)));
        when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(1)));

        assertEquals(3000.0, sucursal.calcularTotalVentasSucursal(), 
            "Las ventas totales deberían ser 3000.0");
    }

    @Test
    public void testPromedioVentasPorEmpleado() {
        when(ventasMock.get(0).getTotalVenta()).thenReturn(1000.0);
        when(ventasMock.get(1).getTotalVenta()).thenReturn(2000.0);
        
        when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(0)));
        when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(1)));

        assertEquals(1500.0, sucursal.calcularPromedioVentasPorEmpleado(),
            "El promedio de ventas por empleado debería ser 1500.0");
    }

    @Test
    public void testTieneEmpleadoEstrella() {
        when(empleadosMock.get(0).esVendedorEstrella()).thenReturn(true);

        assertTrue(sucursal.tieneEmpleadoEstrella(), 
            "Debería haber un empleado estrella.");
    }

	@Test
	public void testContarEmpleados() {
		assertEquals(2, sucursal.contarEmpleados(sucursal.getEmpleados()), "El número de empleados debería ser 2");
	}

	@Test
	public void testCalcularTotalVentasSucursalSinVentas() {
		when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(List.of());
		when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of());

		// Verificación de que el total de ventas es 0
		assertEquals(0.0, sucursal.calcularTotalVentasSucursal(), "Las ventas totales deberían ser 0.0");
	}

	@Test
	public void testTieneEmpleadoEstrellaSinEstrella() {
		when(empleadosMock.get(0).getVentasRealizadas())
				.thenReturn(List.of(mock(Venta.class), mock(Venta.class), mock(Venta.class))); // 3 ventas
		when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of(mock(Venta.class))); // 1 venta

		assertTrue(!sucursal.tieneEmpleadoEstrella(), "No debería haber un empleado estrella.");
	}

}
