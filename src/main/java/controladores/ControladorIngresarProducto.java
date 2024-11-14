package controladores;

import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;
import vista.IngresarProductoView;

public class ControladorIngresarProducto {
    private IngresarProductoView productoView;
    private ProductoRepositorio productoRepositorio;

    public ControladorIngresarProducto(IngresarProductoView productoView, ProductoRepositorio productoRepositorio) {
        this.productoView = productoView;
        this.productoRepositorio = productoRepositorio;
        productoView.setConrolador(this);
    }
    public void crearProducto(Producto producto){
            productoRepositorio.create(producto);
    }


}
