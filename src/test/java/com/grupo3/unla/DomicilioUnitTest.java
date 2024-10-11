package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo3.unla.model.Domicilio;

public class DomicilioUnitTest {

	private Domicilio domicilio;

	@BeforeEach
	public void setUp() {
		domicilio = new Domicilio(1, "123", "Calle Falsa", "Springfield", "Buenos Aires");
	}

	@Test
	public void testValidarDireccion() {
		assertTrue(domicilio.validarDireccion(), "La dirección debería ser válida.");
	}

	@Test
	public void testDireccionInvalida() {
		domicilio.setAltura("");
		assertFalse(domicilio.validarDireccion(), "La dirección no debería ser válida cuando falta la altura.");
	}

	@Test
	public void testLongitudDeCampos() {
		assertTrue(domicilio.validarLongitudCampos(), "La longitud de los campos debería ser válida.");
	}
}
