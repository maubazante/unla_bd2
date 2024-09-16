package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Laboratorio;
import com.grupo3.unla.model.Producto;

public class ProductoUnitTest {

    private Producto producto;
    private Laboratorio laboratorioMock;

    @BeforeEach
    public void setUp() {
        laboratorioMock = mock(Laboratorio.class);
        producto = new Producto(101, true, "Paracetamol", 500.0, laboratorioMock);
    }

    @Test
    public void testGetCodigo() {
        assertEquals(101, producto.getCodigo(), "El código del producto debería ser 101");
    }

    @Test
    public void testSetCodigo() {
        producto.setCodigo(202);
        assertEquals(202, producto.getCodigo(), "El código del producto debería haber sido cambiado a 202");
    }

    @Test
    public void testAplicarDescuento() {
        producto.aplicarDescuento(10.0);
        assertEquals(450.0, producto.getPrecio(), 0.01, "El precio después del 10% de descuento debería ser 450");
    }

    @Test
    public void testSetPrecioNegativo() {
        producto.setPrecio(-50.0);
        assertEquals(-50.0, producto.getPrecio(), "El precio debería poder ser negativo");
    }
}
