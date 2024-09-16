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
}
