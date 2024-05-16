package com.grupo3.unla.model;

public class Empleado {
	public long cuil;
	public int dni;
	public String nombre;
	public String apellido;
	public String nroAfiliado;
	public ObraSocial obraSocial;
	public Domicilio domicilio;
	public long getCuil() {
		return cuil;
	}
	public void setCuil(long cuil) {
		this.cuil = cuil;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNroAfiliado() {
		return nroAfiliado;
	}
	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}
	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	public Empleado(long cuil, int dni, String nombre, String apellido, String nroAfiliado, ObraSocial obraSocial,
			Domicilio domicilio) {
		super();
		this.cuil = cuil;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroAfiliado = nroAfiliado;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
	}

	
}
