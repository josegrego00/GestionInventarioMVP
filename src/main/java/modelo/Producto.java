package modelo;

import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;
    private int minimoStock;

    public Producto() {
    }

    public Producto(String nombre, int cantidad, double precio, int minimoStock) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.minimoStock = minimoStock;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getMinimoStock() {
        return minimoStock;
    }

    public void setMinimoStock(int minimoStock) {
        this.minimoStock = minimoStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
