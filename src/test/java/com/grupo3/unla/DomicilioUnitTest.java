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

	@Test
	public void testAlturaNula() {
		domicilio.setAltura(null);
		assertFalse(domicilio.validarDireccion(), "La dirección no debería ser válida cuando falta la altura.");
	}

	@Test
	public void testCalleNula() {
		domicilio.setCalle(null);
		assertFalse(domicilio.validarDireccion(), "La dirección no debería ser válida cuando falta la calle.");
	}

	@Test
	public void testLocalidadNula() {
		domicilio.setLocalidad(null);
		assertFalse(domicilio.validarDireccion(), "La dirección no debería ser válida cuando falta la localidad.");
	}

	@Test
	public void testProvinciaNula() {
		domicilio.setProvincia(null);
		assertFalse(domicilio.validarDireccion(), "La dirección no debería ser válida cuando falta la provincia.");
	}

	@Test
	public void testLongitudAlturaExcede() {
		domicilio.setAltura("12345678901");
		assertFalse(domicilio.validarLongitudCampos(), "La longitud del campo altura debería ser inválida.");
	}

	@Test
	public void testLongitudLocalidadExcede() {
		domicilio.setLocalidad(
				"Una Localidad con un nombre demasiado largo para ser válido y que excede los 50 caracteres");
		assertFalse(domicilio.validarLongitudCampos(), "La longitud del campo localidad debería ser inválida.");
	}

	@Test
	public void testLongitudProvinciaExcede() {
		domicilio.setProvincia(
				"Una Provincia con un nombre demasiado largo para ser válido y que excede los 50 caracteres");
		assertFalse(domicilio.validarLongitudCampos(), "La longitud del campo provincia debería ser inválida.");
	}

}
