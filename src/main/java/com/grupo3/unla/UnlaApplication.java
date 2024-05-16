package com.grupo3.unla;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Domicilio;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.ObraSocial;


public class UnlaApplication {
	
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		// GENERAR CLIENTES
		Cliente cliente_1 = new Cliente(11111111, "JUAN", "ROMAN", new Domicilio(1, "12", "LUZURIAGA", "TEMPERLEY", "BS AS"), new ObraSocial(1, "OSDE"), "08001213");
		Cliente cliente_2 = new Cliente(22222222, "JUAN", "PISELME", new Domicilio(2, "13", "THEQUIAC", "SAN JUSTO", "BS AS"));
		Cliente cliente_3 = new Cliente(33333333, "JUAN", "BRICKELME", new Domicilio(3, "14", "PRES. PERON", "CASTELAR", "BS AS"), new ObraSocial(2, "OSECAC"), "07001212");
		Cliente cliente_4 = new Cliente(44444444, "JUAN", "RIQUILMES", new Domicilio(4, "15", "KM 4", "GUERNICA", "BS AS"));
		Cliente cliente_5 = new Cliente(55555555, "ACERO", "INOXIDABLE", new Domicilio(5, "16", "BARADERO", "EZEIZA", "BS AS"));
				
		// GENERAR EMPLEADOS
		Empleado empleado_1 = new Empleado(Long.valueOf("20666666663"), 66666666, "ESTESEL", "JEFE", "08001345", new ObraSocial(2, "OSECAC"), new Domicilio(6, "20", "PRES. PERON", "LOMAS DE ZAMORA", "BS AS"));
		Empleado empleado_2 = new Empleado(Long.valueOf("20777777773"), 77777777, "ESTESNOESEL", "JEFE", "08001346", new ObraSocial(2, "OSECAC"), new Domicilio(7, "19", "PRES. PERON", "MORON", "BS AS"));
		Empleado empleado_3 = new Empleado(Long.valueOf("20888888883"), 88888888, "PELAZO", "ADRIAN", "08001347", new ObraSocial(2, "OSECAC"), new Domicilio(8, "1412", "PRES. PERON", "LUJAN", "BS AS"));
		Empleado empleado_4 = new Empleado(Long.valueOf("20999999993"), 99999999, "LEON", "MATENAL", "08001348", new ObraSocial(2, "OSECAC"), new Domicilio(9, "1421", "PRES. PERON", "BURZACO", "BS AS"));
		Empleado empleado_5 = new Empleado(Long.valueOf("20121212123"), 12121212, "ROBERT", "POLLARD", "08001349", new ObraSocial(2, "OSECAC"), new Domicilio(10, "114", "PRES. PERON", "COGHLAN", "BS AS"));
				
		
		// EJEMPLO DE SERIALIZACION, JSON LISTA DE CLIENTES
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente_1);
		clientes.add(cliente_2);
		clientes.add(cliente_3);
		clientes.add(cliente_4);
		clientes.add(cliente_5);
		String json = gson.toJson(clientes);
		System.out.print(json);
	}

}
