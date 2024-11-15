package controladores;

import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;
import vista.BucarProductoView;
import vista.IngresarProductoView;

import java.util.List;

public class ControladorIngresarProducto {
    private IngresarProductoView productoView;
    private ProductoRepositorio productoRepositorio;
    private BucarProductoView bucarProductoView;



    public ControladorIngresarProducto(IngresarProductoView productoView, ProductoRepositorio productoRepositorio) {
        this.productoView = productoView;
        this.productoRepositorio = productoRepositorio;
        productoView.setConrolador(this);
    }

    public ControladorIngresarProducto(ProductoRepositorio productoRepositorio, BucarProductoView buscarProductoView) {
        this.productoRepositorio = productoRepositorio;
        this.bucarProductoView = buscarProductoView;
    }

    public void crearProducto(Producto producto){
            productoRepositorio.create(producto);
    }
    public void cargarProductosEnVista() {
        List<Producto> productos = productoRepositorio.listar(); // Obtener lista de productos
        bucarProductoView.cargarProductos(productos); // Cargar en el JComboBox
    }


}
