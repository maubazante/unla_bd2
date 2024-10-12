package com.grupo3.unla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.grupo.unla.dto.SucursalDTO;
import com.grupo3.unla.model.Sucursal;

public class SucursalDTOTest {

	@Test
	public void testSucursalDTOConstructor() {
		Sucursal sucursal = new Sucursal(1, "Sucursal 1", List.of(), null);
		SucursalDTO dto = new SucursalDTO(sucursal);

		assertEquals(sucursal.getId(), dto.getId(), "El ID debería coincidir");
		assertEquals(sucursal.getNombre(), dto.getNombre(), "El nombre debería coincidir");
	}

	@Test
	public void testSucursalDTOConstructorConParametros() {
		SucursalDTO dto = new SucursalDTO(2, "Sucursal 2");

		assertEquals(2, dto.getId(), "El ID debería ser 2");
		assertEquals("Sucursal 2", dto.getNombre(), "El nombre debería ser 'Sucursal 2'");
	}

	@Test
	public void testSucursalDTOConstructorNulo() {
		SucursalDTO dto = new SucursalDTO(null);

		assertEquals(0, dto.getId(), "El ID debería ser 0 para sucursal nula");
		assertEquals(null, dto.getNombre(), "El nombre debería ser nulo para sucursal nula");
	}
}