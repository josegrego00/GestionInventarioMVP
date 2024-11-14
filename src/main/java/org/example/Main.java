package org.example;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;
import vista.BucarProductoView;
import vista.IngresarProductoView;

public class Main {
    public static void main(String[] args) {
        IngresarProductoView view= new IngresarProductoView();
        ProductoRepositorio controlRepos= new ProductoRepositorio();
        ControladorIngresarProducto controladorIngresarProducto= new ControladorIngresarProducto(view, controlRepos);

    }
    }
