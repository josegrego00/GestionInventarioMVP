package controladores;

import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;

import modelo.ProductosCompras;
import vista.CompraProductoView;
import vista.IngresarProductoView;
import vista.ReportesVentasYComprasView;
import vista.VentaView;

import java.util.List;

public class ControladorIngresarProducto {
    private IngresarProductoView productoView;
    private ProductoRepositorio productoRepositorio;
    private CompraProductoView compraProductoView;
    private VentaView ventaView;
    private ReportesVentasYComprasView reportesVentasYComprasView;
    private ProductosCompras productosCompras;

    public ControladorIngresarProducto(ReportesVentasYComprasView reportesVentasYComprasView, ProductosCompras productosCompras) {
        this.reportesVentasYComprasView = reportesVentasYComprasView;
        this.productosCompras = productosCompras;
        this.reportesVentasYComprasView.controladorBotonPDF(this);
        this.reportesVentasYComprasView.controladorBotonExcel(this);
    }

    public ControladorIngresarProducto(VentaView ventaView, ProductoRepositorio productoRepositorio) {
        this.ventaView = ventaView;
        this.productoRepositorio = productoRepositorio;
        ventaView.controladorBotonVender(this);
    }

    public ControladorIngresarProducto(IngresarProductoView productoView, ProductoRepositorio productoRepositorio) {
        this.productoView = productoView;
        this.productoRepositorio = productoRepositorio;
        productoView.setConrolador(this);
    }

    public ControladorIngresarProducto(CompraProductoView compraProductoView, ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.compraProductoView = compraProductoView;
        compraProductoView.controladorBotonComprar(this);
    }

    public void crearProducto(Producto producto) {
        productoRepositorio.create(producto);
    }


    public void cargarCompra(Producto producto) {
        productoRepositorio.update(producto);
    }
    public void ventaproducto(Producto producto) {
        productoRepositorio.update(producto);
    }


}
