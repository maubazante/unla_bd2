package com.grupo3.unla;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grupo3.unla.model.Cliente;
import com.grupo3.unla.model.Domicilio;
import com.grupo3.unla.model.Empleado;
import com.grupo3.unla.model.Laboratorio;
import com.grupo3.unla.model.ObraSocial;
import com.grupo3.unla.model.Producto;
import com.grupo3.unla.model.Sucursal;
import com.grupo3.unla.model.Venta;

public class UnlaApplication {

	public static final String PAGO_EFECTIVO = "EFECTIVO";
	public static final String PAGO_DEBITO = "DEBITO";
	public static final String PAGO_CREDITO = "CREDITO";

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) {
		
		// GENERAR CLIENTES
		Cliente cliente_1 = new Cliente(11111111, "JUAN", "ROMAN",
				new Domicilio(1, "12", "LUZURIAGA", "TEMPERLEY", "BS AS"), new ObraSocial(1, "OSDE"), "08001213");
		Cliente cliente_2 = new Cliente(22222222, "JUAN", "PISELME",
				new Domicilio(2, "13", "THEQUIAC", "SAN JUSTO", "BS AS"));
		Cliente cliente_3 = new Cliente(33333333, "JUAN", "BRICKELME",
				new Domicilio(3, "14", "PRES. PERON", "CASTELAR", "BS AS"), new ObraSocial(2, "OSECAC"), "07001212");
		Cliente cliente_4 = new Cliente(44444444, "JUAN", "RIQUILMES",
				new Domicilio(4, "15", "KM 4", "GUERNICA", "BS AS"));
		Cliente cliente_5 = new Cliente(55555555, "ACERO", "INOXIDABLE",
				new Domicilio(5, "16", "BARADERO", "EZEIZA", "BS AS"));
		Cliente cliente_6 = new Cliente(66666666, "ACERO", "INOXIDABLE",
				new Domicilio(15, "17", "CORRIENTES", "EZEIZA", "BS AS"));
		Cliente cliente_7 = new Cliente(77777777, "ESCOBA", "ESCOBERO",
				new Domicilio(16, "18", "CATAMARCA", "EZEIZA", "BS AS"));
		Cliente cliente_8 = new Cliente(88888888, "PEPE", "ARGENTO",
				new Domicilio(17, "19", "SAN FERNANDO", "SAN MARTIN", "BS AS"));
		Cliente cliente_9 = new Cliente(99999999, "PIEDAD", "TEPIDO",
				new Domicilio(18, "20", "MORENO", "RAMOS MEJIA", "BS AS"));
		Cliente cliente_10 = new Cliente(10101010, "MIMANCHI", "CAFFE",
				new Domicilio(19, "21", "ALVEAR", "BANFIELD", "BS AS"));

		// GENERAR EMPLEADOS
		Empleado empleado_1 = new Empleado(Long.valueOf("20666666663"), 66666666, "ESTESEL", "JEFE", "08001345",
				new ObraSocial(2, "OSECAC"), new Domicilio(6, "20", "PRES. PERON", "LOMAS DE ZAMORA", "BS AS"));
		Empleado empleado_2 = new Empleado(Long.valueOf("20777777773"), 77777777, "ESTESNOESEL", "JEFE", "08001346",
				new ObraSocial(2, "OSECAC"), new Domicilio(7, "19", "PRES. PERON", "MORON", "BS AS"));
		Empleado empleado_3 = new Empleado(Long.valueOf("20888888883"), 88888888, "PELAZO", "ADRIAN", "08001347",
				new ObraSocial(2, "OSECAC"), new Domicilio(8, "1412", "PRES. PERON", "LUJAN", "BS AS"));
		Empleado empleado_4 = new Empleado(Long.valueOf("20999999993"), 99999999, "LEON", "MATENAL", "08001348",
				new ObraSocial(2, "OSECAC"), new Domicilio(9, "1421", "PRES. PERON", "BURZACO", "BS AS"));
		Empleado empleado_5 = new Empleado(Long.valueOf("20121212123"), 12121212, "ROBERT", "POLLARD", "08001349",
				new ObraSocial(2, "OSECAC"), new Domicilio(10, "114", "PRES. PERON", "COGHLAN", "BS AS"));
		Empleado empleado_6 = new Empleado(Long.valueOf("20413213563"), 41321356, "JAMES", "HETFIELD", "08001641",
				new ObraSocial(2, "OSECAC"), new Domicilio(11, "2145", "COLOMBRES", "LOMAS DE ZAMORA", "BS AS"));
		Empleado empleado_7 = new Empleado(Long.valueOf("20245653623"), 24565362, "JUAN", "RIVER", "08001642",
				new ObraSocial(2, "OSECAC"), new Domicilio(12, "544", "MBURUCUYA", "MORON", "BS AS"));
		Empleado empleado_8 = new Empleado(Long.valueOf("20162452523"), 16245252, "SANTI", "LG", "08001643",
				new ObraSocial(2, "OSECAC"), new Domicilio(13, "144", "THEQUIAC", "LUJAN", "BS AS"));
		Empleado empleado_9 = new Empleado(Long.valueOf("26746725653"), 74672565, "FIONA", "SURAN", "08001645",
				new ObraSocial(2, "OSECAC"), new Domicilio(14, "2322", "AV. ESPORA", "BURZACO", "BS AS"));
	

		// GENERAR PRODUCTOS

		Producto producto_1 = new Producto(1, true, "Roaccutan", 45000, new Laboratorio(1, "LabChemical"));
		Producto producto_2 = new Producto(2, true, "Ibuprofeno 600", 1000, new Laboratorio(2, "Biotenk"));
		Producto producto_3 = new Producto(3, true, "Poisson 200", 20000, new Laboratorio(3, "Wels SRL"));
		Producto producto_4 = new Producto(4, true, "Enalapril", 5000, new Laboratorio(4, "Elea"));
		Producto producto_5 = new Producto(5, false, "Perfume Paco", 26000, null);
		Producto producto_6 = new Producto(6, false, "Issey Miyake", 180000, null);
		Producto producto_7 = new Producto(7, true, "Acemuk", 10000, new Laboratorio(2, "Biotenk"));
		Producto producto_8 = new Producto(8, true, "Erisol", 20000, new Laboratorio(3, "Wels SRL"));
		Producto producto_9 = new Producto(9, false, "Anachaqueochumbi", 5000, null);
		Producto producto_10 = new Producto(10, true, "Paracetamol", 26000, new Laboratorio(3, "Wels SRL"));

		// GENERAL SUCURSALES
		List<Empleado> empleadosLomas = new ArrayList<>();
		empleadosLomas.add(empleado_6);
		empleadosLomas.add(empleado_4);
		empleadosLomas.add(empleado_5);
		Sucursal sucursal_lomas = new Sucursal(1, "LOMAS", empleadosLomas, empleado_5);

		List<Empleado> empleadosLanus = new ArrayList<>();
		empleadosLomas.add(empleado_1);
		empleadosLomas.add(empleado_2);
		empleadosLomas.add(empleado_3);
		Sucursal sucursal_lanus = new Sucursal(2, "LANUS", empleadosLanus, empleado_3);
		
		List<Empleado> empleadosBanfield = new ArrayList<>();
		empleadosLomas.add(empleado_7);
		empleadosLomas.add(empleado_8);
		empleadosLomas.add(empleado_9);
		Sucursal sucursal_banfield = new Sucursal(3, "BANFIELD", empleadosLanus, empleado_9);
				
		// VENTA N1
		List<Producto> productos_venta1 = new ArrayList<>();
		productos_venta1.add(producto_4);
		productos_venta1.add(producto_5);
		productos_venta1.add(producto_3);
		Venta venta_1 = new Venta(LocalDate.now(), empleado_1, PAGO_EFECTIVO, cliente_1, productos_venta1,
				sucursal_lanus);

		// VENTA N2
		List<Producto> productos_venta2 = new ArrayList<>();
		productos_venta2.add(producto_3);
		productos_venta2.add(producto_1);
		productos_venta2.add(producto_3);
		Venta venta_2 = new Venta(LocalDate.now(), empleado_2, PAGO_DEBITO, cliente_2, productos_venta2,
				sucursal_lanus);

		// VENTA N3
		List<Producto> productos_venta3 = new ArrayList<>();
		productos_venta3.add(producto_1);
		productos_venta3.add(producto_1);
		productos_venta3.add(producto_3);
		Venta venta_3 = new Venta(LocalDate.now(), empleado_3, PAGO_DEBITO, cliente_3, productos_venta3,
				sucursal_lanus);

		// VENTA N4
		List<Producto> productos_venta4 = new ArrayList<>();
		productos_venta4.add(producto_2);
		productos_venta4.add(producto_2);
		productos_venta4.add(producto_3);
		Venta venta_4 = new Venta(LocalDate.now(), empleado_4, PAGO_CREDITO, cliente_4, productos_venta4,
				sucursal_lomas);

		// VENTA N5
		List<Producto> productos_venta5 = new ArrayList<>();
		productos_venta5.add(producto_1);
		productos_venta5.add(producto_5);
		productos_venta5.add(producto_3);
		Venta venta_5 = new Venta(LocalDate.now(), empleado_5, PAGO_CREDITO, cliente_5, productos_venta5,
				sucursal_lomas);
		
		/* TODO: ---------> GENERAR 30 VENTAS POR SUCURSAL <----------- */
		
		System.out.println("----------------VENTA 1----------------");
		System.out.println(gson.toJson(venta_1));
		System.out.println("----------------VENTA 2----------------");
		System.out.println(gson.toJson(venta_2));
		System.out.println("----------------VENTA 3----------------");
		System.out.println(gson.toJson(venta_3));
		System.out.println("----------------VENTA 4----------------");
		System.out.println(gson.toJson(venta_4));
		System.out.println("----------------VENTA 5----------------");
		System.out.println(gson.toJson(venta_5));
	}

}
