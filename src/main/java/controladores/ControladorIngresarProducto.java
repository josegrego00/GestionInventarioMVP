package controladores;

import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;
import vista.BucarProductoView;
import vista.CompraProductoView;
import vista.IngresarProductoView;

import java.util.List;

public class ControladorIngresarProducto {
    private IngresarProductoView productoView;
    private ProductoRepositorio productoRepositorio;
    private CompraProductoView compraProductoView;


    public ControladorIngresarProducto(IngresarProductoView productoView, ProductoRepositorio productoRepositorio) {
        this.productoView = productoView;
        this.productoRepositorio = productoRepositorio;
        productoView.setConrolador(this);
    }

    public ControladorIngresarProducto(ProductoRepositorio productoRepositorio, CompraProductoView compraProductoView) {
        this.productoRepositorio = productoRepositorio;
        this.compraProductoView = compraProductoView;
        compraProductoView.controladorComboBox(this);
    }

    public void crearProducto(Producto producto) {
        productoRepositorio.create(producto);
    }

    public void cargarCompra(Producto producto) {
        productoRepositorio.ingresarCompra(producto);
    }


}
