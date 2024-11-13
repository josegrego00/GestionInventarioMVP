package org.example;

import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;

public class Main {
    public static void main(String[] args) {
        ProductoRepositorio pp= new ProductoRepositorio();
        pp.create(new Producto("Mother Board", 10, 100, 2));
        }
    }
