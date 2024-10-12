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
        // Se mockean las ventas realizadas por cada empleado
        when(ventasMock.get(0).getTotalVenta()).thenReturn(1000.0);
        when(ventasMock.get(1).getTotalVenta()).thenReturn(2000.0);
        
        when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(0)));
        when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(1)));

        // Verificación de que la suma de ventas es correcta
        assertEquals(3000.0, sucursal.calcularTotalVentasSucursal(), 
            "Las ventas totales deberían ser 3000.0");
    }

    @Test
    public void testPromedioVentasPorEmpleado() {
        // Mockear las ventas realizadas por cada empleado
        when(ventasMock.get(0).getTotalVenta()).thenReturn(1000.0);
        when(ventasMock.get(1).getTotalVenta()).thenReturn(2000.0);
        
        when(empleadosMock.get(0).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(0)));
        when(empleadosMock.get(1).getVentasRealizadas()).thenReturn(List.of(ventasMock.get(1)));

        // Verificación del promedio
        assertEquals(1500.0, sucursal.calcularPromedioVentasPorEmpleado(),
            "El promedio de ventas por empleado debería ser 1500.0");
    }

    @Test
    public void testTieneEmpleadoEstrella() {
        // Mockear que uno de los empleados es vendedor estrella
        when(empleadosMock.get(0).esVendedorEstrella()).thenReturn(true);

        // Verificación de que hay un empleado estrella
        assertTrue(sucursal.tieneEmpleadoEstrella(), 
            "Debería haber un empleado estrella.");
    }
}
