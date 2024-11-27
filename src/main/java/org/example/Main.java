package org.example;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;

import modelo.ProductosCompras;
import vista.CompraProductoView;
import vista.IngresarProductoView;
import vista.ReportesVentasYComprasView;
import vista.VentaView;

public class Main {
    public static void main(String[] args) {
        CompraProductoView view = new CompraProductoView();
        VentaView viewVenta = new VentaView();
        ProductoRepositorio productoRepositorio = new ProductoRepositorio();
        ControladorIngresarProducto controladorIngresarProducto = new ControladorIngresarProducto(viewVenta, productoRepositorio);
        IngresarProductoView view1 = new IngresarProductoView();
        ControladorIngresarProducto controladorIngresarProducto2 = new ControladorIngresarProducto(view1, productoRepositorio);
        ControladorIngresarProducto controladorIngresarProducto1 = new ControladorIngresarProducto(view, productoRepositorio);
        ReportesVentasYComprasView reportesVentasYComprasView = new ReportesVentasYComprasView();
        ProductosCompras productosCompras = new ProductosCompras();
        ControladorIngresarProducto controladorIngresarProducto3 = new ControladorIngresarProducto(reportesVentasYComprasView, productosCompras);


    }
}
