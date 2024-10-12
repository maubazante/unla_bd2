package com.grupo3.unla.model;

public class Domicilio {
	public int id;
	public String altura;
	public String calle;
	public String localidad;
	public String provincia;
	
	public Domicilio(int id, String altura, String calle, String localidad, String provincia) {
		super();
		this.id = id;
		this.altura = altura;
		this.calle = calle;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public boolean validarDireccion() {
	    if (altura == null || altura.isEmpty() || calle == null || calle.isEmpty() ||
	        localidad == null || localidad.isEmpty() || provincia == null || provincia.isEmpty()) {
	        System.out.println("La dirección no es válida. Faltan datos.");
	        return false;
	    }
	    return true;
	}

	public boolean validarLongitudCampos() {
	    if (altura.length() > 10 || localidad.length() > 50 || provincia.length() > 50) {
	        System.out.println("Los campos de la dirección exceden la longitud permitida.");
	        return false;
	    }
	    return true;
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", altura=" + altura + ", calle=" + calle + ", localidad=" + localidad
				+ ", provincia=" + provincia + "]";
	}
}
