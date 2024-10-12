package com.grupo3.unla.utils;

import com.grupo.unla.dto.SucursalDTO;

public class MathHelper {
	
	public static String generarNumeroTicket(SucursalDTO sucursal) {
		return "000" + sucursal.getId() + "-" + (int)Math.floor(Math.random() * (99999999 - 10000000 + 1) + 10000000);
	}
	
}
