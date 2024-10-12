package com.grupo3.unla.model;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    public int id;
    public String nombre;
    private List<Producto> productos = new ArrayList<>();

    public Laboratorio() {
        super();
    }

    public Laboratorio(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

	// Método para eliminar un producto por codigo
	public boolean eliminarProductoPorId(int codigo) {
		return productos.removeIf(producto -> producto.getCodigo() == codigo);
    }

    // Método para obtener el número total de productos
    public int obtenerNumeroTotalProductos() {
        return productos.size();
    }

    // Método para calcular ingresos totales
    public double calcularIngresosTotales() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public double calcularIngresos(List<Producto> productosVendidos) {
        return productosVendidos.stream().filter(producto -> producto.getLaboratorio().equals(this))
                .mapToDouble(Producto::getPrecio).sum();
    }

    public double aplicarDescuentoLote(int cantidad, double precioUnitario) {
        if (cantidad > 100) {
            return precioUnitario * cantidad * 0.95; // 5% de descuento
        }
        return precioUnitario * cantidad;
    }

    public double calcularPromedioPrecios() {
        double sumaPrecios = 0;
        for (Producto producto : productos) {
            sumaPrecios += producto.getPrecio();
        }
        return productos.isEmpty() ? 0 : sumaPrecios / productos.size();
    }

    public Producto obtenerProductoMasCaro() {
        Producto masCaro = null;
        for (Producto producto : productos) {
            if (masCaro == null || producto.getPrecio() > masCaro.getPrecio()) {
                masCaro = producto;
            }
        }
        return masCaro;
    }

    public boolean tieneProductoMayorA(double umbral) {
        for (Producto producto : productos) {
            if (producto.getPrecio() > umbral) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Laboratorio [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
    }
}

