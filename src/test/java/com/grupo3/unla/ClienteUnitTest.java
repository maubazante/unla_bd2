package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Domicilio;

public class ClienteUnitTest {

    private Cliente cliente;

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

}
