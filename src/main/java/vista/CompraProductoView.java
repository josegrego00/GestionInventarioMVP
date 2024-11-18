package vista;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Vector;

public class CompraProductoView extends JFrame {

    private JComboBox<Producto> nombrePorductos;
    private JTextField nombre, cantidad, precio;
    private JButton comprarboton, cancelarBoton;
    private ProductoRepositorio productoRepositorio;
    private ControladorIngresarProducto controladorIngresarProducto;

    public CompraProductoView() {
        productoRepositorio = new ProductoRepositorio();
        JPanel panelFrane = new JPanel(new BorderLayout());
        this.setTitle("Compra de Producto");
        this.setSize(380, 200);
        this.add(panelPrincialFormulario(), BorderLayout.CENTER);
        this.add(panelBotones(), BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public JPanel panelPrincialFormulario() {
        // Agregar etiquetas y campos de texto
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        this.nombrePorductos = new JComboBox<Producto>(new Vector<Producto>(productoRepositorio.listar()));

        System.out.println("Productos cargados: " + productoRepositorio.listar().size());
        panel.add(new JLabel("Productos:"));
        panel.add(nombrePorductos);

        panel.add(new JLabel("Nombre del Producto:"));
        this.nombre = new JTextField();
        this.nombre.setEditable(false);
        panel.add(this.nombre);

        panel.add(new JLabel("Cantidad:"));
        this.cantidad = new JTextField();

        panel.add(cantidad);

        panel.add(new JLabel("Precio:"));
        this.precio = new JTextField();

        panel.add(precio);

        nombrePorductos.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
                if (productoSeleccionado != null) {
                    // Actualizar los JTextFields con los datos del producto seleccionado
                    nombre.setText(productoSeleccionado.getNombre());
                    cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));
                    precio.setText(String.valueOf(productoSeleccionado.getPrecio()));

                }
            }
        });
        return panel;
    }

    public JPanel panelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout());
        this.comprarboton = new JButton("Comprar.");
        this.cancelarBoton = new JButton("Salir.");
        panelBotones.add(comprarboton);
        panelBotones.add(cancelarBoton);
        return panelBotones;
    }

    public JButton getComprarboton() {
        return comprarboton;
    }


    // este controlador no sirve para nada
    // iguaal lo dejo ya que tengo q colocar el controlador paara el boton.

    public void controladorComboBox(ControladorIngresarProducto controladorIngresarProducto) {
        this.controladorIngresarProducto = controladorIngresarProducto;
        nombrePorductos.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
                System.out.println("===============00");
                if (productoSeleccionado != null) {
                    System.out.println("Producto seleccionado: " + productoSeleccionado.getNombre());
                    System.out.println("Cantidad: " + productoSeleccionado.getCantidad());
                    System.out.println("Precio: " + productoSeleccionado.getPrecio());

                    nombre.setText(productoSeleccionado.getNombre());
                    cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));
                    precio.setText(String.valueOf(productoSeleccionado.getPrecio()));

                   }else {
                    System.out.println("No se seleccionó ningún producto.");
                }

            }

        });
    }

}
