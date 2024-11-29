package modelo;

import java.util.List;

public class FacturaCompra {
    private int id;
    private Proveedor proveedor;
    private List<Producto> listaProductos;
    private double montoPagar;

    public FacturaCompra() {
    }

    public FacturaCompra(int id, Proveedor proveedor, List<Producto> listaProductos, double montoPagar) {
        this.id = id;
        this.proveedor = proveedor;
        this.listaProductos = listaProductos;
        this.montoPagar = montoPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }
}
