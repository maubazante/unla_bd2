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
		empleadosLanus.add(empleado_1);
		empleadosLanus.add(empleado_2);
		empleadosLanus.add(empleado_3);
		Sucursal sucursal_lanus = new Sucursal(2, "LANUS", empleadosLanus, empleado_3);

		List<Empleado> empleadosBanfield = new ArrayList<>();
		empleadosBanfield.add(empleado_7);
		empleadosBanfield.add(empleado_8);
		empleadosBanfield.add(empleado_9);
		Sucursal sucursal_banfield = new Sucursal(3, "BANFIELD", empleadosBanfield, empleado_9);

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

		// VENTA N6
		List<Producto> productos_venta6 = new ArrayList<>();
		productos_venta6.add(producto_2);
		productos_venta6.add(producto_5);
		productos_venta6.add(producto_4);
		Venta venta_6 = new Venta(LocalDate.now(), empleado_4, PAGO_CREDITO, cliente_3, productos_venta6,
				sucursal_lomas);

		// VENTA N7
		List<Producto> productos_venta7 = new ArrayList<>();
		productos_venta7.add(producto_1);
		productos_venta7.add(producto_3);
		productos_venta7.add(producto_4);
		Venta venta_7 = new Venta(LocalDate.now(), empleado_1, PAGO_EFECTIVO, cliente_3, productos_venta7,
				sucursal_lanus);

		// VENTA N8
		List<Producto> productos_venta8 = new ArrayList<>();
		productos_venta8.add(producto_2);
		productos_venta8.add(producto_3);
		productos_venta8.add(producto_5);
		Venta venta_8 = new Venta(LocalDate.now(), empleado_2, PAGO_DEBITO, cliente_1, productos_venta8,
				sucursal_lanus);

		// VENTA N9
		List<Producto> productos_venta9 = new ArrayList<>();
		productos_venta9.add(producto_7);
		productos_venta9.add(producto_2);
		productos_venta9.add(producto_9);
		Venta venta_9 = new Venta(LocalDate.now(), empleado_3, PAGO_DEBITO, cliente_8, productos_venta9,
				sucursal_lanus);

		// VENTA N10
		List<Producto> productos_venta10 = new ArrayList<>();
		productos_venta10.add(producto_1);
		productos_venta10.add(producto_5);
		productos_venta10.add(producto_8);
		Venta venta_10 = new Venta(LocalDate.now(), empleado_1, PAGO_CREDITO, cliente_6, productos_venta10,
				sucursal_lanus);

		// VENTA N11
		List<Producto> productos_venta11 = new ArrayList<>();
		productos_venta11.add(producto_3);
		productos_venta11.add(producto_7);
		productos_venta11.add(producto_8);
		Venta venta_11 = new Venta(LocalDate.now(), empleado_2, PAGO_EFECTIVO, cliente_7, productos_venta11,
				sucursal_lanus);

		// VENTA N12
		List<Producto> productos_venta12 = new ArrayList<>();
		productos_venta12.add(producto_4);
		productos_venta12.add(producto_6);
		productos_venta12.add(producto_7);
		Venta venta_12 = new Venta(LocalDate.now(), empleado_2, PAGO_DEBITO, cliente_3, productos_venta12,
				sucursal_lanus);

		// VENTA N13
		List<Producto> productos_venta13 = new ArrayList<>();
		productos_venta13.add(producto_1);
		productos_venta13.add(producto_3);
		productos_venta13.add(producto_7);
		Venta venta_13 = new Venta(LocalDate.now(), empleado_3, PAGO_CREDITO, cliente_9, productos_venta13,
				sucursal_lanus);

		// VENTA N14
		List<Producto> productos_venta14 = new ArrayList<>();
		productos_venta14.add(producto_1);
		productos_venta14.add(producto_5);
		productos_venta14.add(producto_10);
		Venta venta_14 = new Venta(LocalDate.now(), empleado_4, PAGO_CREDITO, cliente_2, productos_venta14,
				sucursal_lomas);

		// VENTA N15
		List<Producto> productos_venta15 = new ArrayList<>();
		productos_venta15.add(producto_3);
		productos_venta15.add(producto_7);
		productos_venta15.add(producto_10);
		Venta venta_15 = new Venta(LocalDate.now(), empleado_5, PAGO_EFECTIVO, cliente_5, productos_venta15,
				sucursal_lomas);

		// VENTA N16
		List<Producto> productos_venta16 = new ArrayList<>();
		productos_venta16.add(producto_6);
		productos_venta16.add(producto_7);
		productos_venta16.add(producto_8);
		Venta venta_16 = new Venta(LocalDate.now(), empleado_6, PAGO_EFECTIVO, cliente_6, productos_venta16,
				sucursal_lomas);

		// VENTA N17
		List<Producto> productos_venta17 = new ArrayList<>();
		productos_venta17.add(producto_1);
		productos_venta17.add(producto_5);
		productos_venta17.add(producto_10);
		Venta venta_17 = new Venta(LocalDate.now(), empleado_4, PAGO_EFECTIVO, cliente_10, productos_venta17,
				sucursal_lomas);
		// VENTA N18
		List<Producto> productos_venta18 = new ArrayList<>();
		productos_venta18.add(producto_3);
		productos_venta18.add(producto_2);
		productos_venta18.add(producto_6);
		Venta venta_18 = new Venta(LocalDate.now(), empleado_4, PAGO_CREDITO, cliente_5, productos_venta18,
				sucursal_lomas);
		// VENTA N19
		List<Producto> productos_venta19 = new ArrayList<>();
		productos_venta19.add(producto_6);
		productos_venta19.add(producto_5);
		productos_venta19.add(producto_4);
		Venta venta_19 = new Venta(LocalDate.now(), empleado_6, PAGO_DEBITO, cliente_1, productos_venta19,
				sucursal_lomas);
		// VENTA N20
		List<Producto> productos_venta20 = new ArrayList<>();
		productos_venta20.add(producto_9);
		productos_venta20.add(producto_7);
		productos_venta20.add(producto_1);
		Venta venta_20 = new Venta(LocalDate.now(), empleado_5, PAGO_DEBITO, cliente_3, productos_venta20,
				sucursal_lomas);

		// VENTA N21
		List<Producto> productos_venta21 = new ArrayList<>();
		productos_venta21.add(producto_6);
		productos_venta21.add(producto_2);
		productos_venta21.add(producto_10);
		Venta venta_21 = new Venta(LocalDate.now(), empleado_8, PAGO_EFECTIVO, cliente_8, productos_venta21,
				sucursal_banfield);
		// VENTA N22
		List<Producto> productos_venta22 = new ArrayList<>();
		productos_venta22.add(producto_4);
		productos_venta22.add(producto_3);
		productos_venta22.add(producto_1);
		Venta venta_22 = new Venta(LocalDate.now(), empleado_7, PAGO_EFECTIVO, cliente_2, productos_venta22,
				sucursal_banfield);
		// VENTA N23
		List<Producto> productos_venta23 = new ArrayList<>();
		productos_venta23.add(producto_5);
		productos_venta23.add(producto_8);
		productos_venta23.add(producto_10);
		Venta venta_23 = new Venta(LocalDate.now(), empleado_8, PAGO_CREDITO, cliente_10, productos_venta23,
				sucursal_banfield);
		// VENTA N24
		List<Producto> productos_venta24 = new ArrayList<>();
		productos_venta24.add(producto_3);
		productos_venta24.add(producto_10);
		productos_venta24.add(producto_6);
		Venta venta_24 = new Venta(LocalDate.now(), empleado_9, PAGO_DEBITO, cliente_7, productos_venta24,
				sucursal_banfield);
		// VENTA N25
		List<Producto> productos_venta25 = new ArrayList<>();
		productos_venta25.add(producto_7);
		productos_venta25.add(producto_8);
		productos_venta25.add(producto_2);
		Venta venta_25 = new Venta(LocalDate.now(), empleado_8, PAGO_CREDITO, cliente_4, productos_venta25,
				sucursal_banfield);
		// VENTA N26
		List<Producto> productos_venta26 = new ArrayList<>();
		productos_venta26.add(producto_1);
		productos_venta26.add(producto_3);
		productos_venta26.add(producto_5);
		Venta venta_26 = new Venta(LocalDate.now(), empleado_7, PAGO_EFECTIVO, cliente_5, productos_venta26,
				sucursal_banfield);
		// VENTA N27
		List<Producto> productos_venta27 = new ArrayList<>();
		productos_venta27.add(producto_6);
		productos_venta27.add(producto_9);
		productos_venta27.add(producto_10);
		Venta venta_27 = new Venta(LocalDate.now(), empleado_9, PAGO_EFECTIVO, cliente_9, productos_venta27,
				sucursal_banfield);
		// VENTA N28
		List<Producto> productos_venta28 = new ArrayList<>();
		productos_venta28.add(producto_4);
		productos_venta28.add(producto_7);
		productos_venta28.add(producto_1);
		Venta venta_28 = new Venta(LocalDate.now(), empleado_8, PAGO_CREDITO, cliente_1, productos_venta28,
				sucursal_banfield);
		// VENTA N29
		List<Producto> productos_venta29 = new ArrayList<>();
		productos_venta29.add(producto_10);
		productos_venta29.add(producto_9);
		productos_venta29.add(producto_8);
		Venta venta_29 = new Venta(LocalDate.now(), empleado_7, PAGO_DEBITO, cliente_10, productos_venta29,
				sucursal_banfield);
		// VENTA N30
		List<Producto> productos_venta30 = new ArrayList<>();
		productos_venta30.add(producto_4);
		productos_venta30.add(producto_3);
		productos_venta30.add(producto_7);
		Venta venta_30 = new Venta(LocalDate.now(), empleado_9, PAGO_CREDITO, cliente_6, productos_venta30,
				sucursal_banfield);

		/* TODO: ---------> GENERAR 30 VENTAS POR SUCURSAL <----------- */
		
		List<Venta> ventas = new ArrayList<>();
		ventas.add(venta_1);
		ventas.add(venta_2);
		ventas.add(venta_3);
		ventas.add(venta_4);
		ventas.add(venta_5);
		ventas.add(venta_6);
		ventas.add(venta_7);
		ventas.add(venta_8);
		ventas.add(venta_9);
		ventas.add(venta_10);
		ventas.add(venta_11);
		ventas.add(venta_12);
		ventas.add(venta_13);
		ventas.add(venta_14);
		ventas.add(venta_15);
		ventas.add(venta_16);
		ventas.add(venta_17);
		ventas.add(venta_18);
		ventas.add(venta_19);
		ventas.add(venta_20);
		ventas.add(venta_21);
		ventas.add(venta_22);
		ventas.add(venta_23);
		ventas.add(venta_24);
		ventas.add(venta_25);
		ventas.add(venta_26);
		ventas.add(venta_27);
		ventas.add(venta_28);
		ventas.add(venta_29);
		ventas.add(venta_30);

		System.out.println(gson.toJson(ventas));
	}

}
