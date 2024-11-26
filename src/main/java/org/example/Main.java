package org.example;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;

import vista.CompraProductoView;
import vista.IngresarProductoView;
import vista.VentaView;

public class Main {
    public static void main(String[] args) {
        CompraProductoView view= new CompraProductoView();
        VentaView viewVenta= new VentaView();
        ProductoRepositorio productoRepositorio= new ProductoRepositorio();
        ControladorIngresarProducto controladorIngresarProducto= new ControladorIngresarProducto(viewVenta, productoRepositorio);
       IngresarProductoView view1= new IngresarProductoView();
      ControladorIngresarProducto controladorIngresarProducto2= new ControladorIngresarProducto(view1, productoRepositorio);
      ControladorIngresarProducto controladorIngresarProducto1= new ControladorIngresarProducto(view, productoRepositorio);





    }
    }
