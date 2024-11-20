package vista;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class VentaView extends JFrame {

    private JComboBox<Producto> nombreProductos;
    private JTextField nombre, cantidadVenta, precio, precioT;
    private JButton venderBoton, cancelarBoton;
    private ProductoRepositorio productoRepositorio;
    private ControladorIngresarProducto controladorIngresarProducto;

    public VentaView() {
        productoRepositorio = new ProductoRepositorio();
        JPanel panelFrane = new JPanel(new BorderLayout());
        this.setTitle("Venta de Producto");
        this.setSize(380, 200);
        this.add(panelPrincipalFormulario(), BorderLayout.CENTER);
        this.add(panelBotones(), BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public JPanel panelPrincipalFormulario() {
        // Agregar etiquetas y campos de texto
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        this.nombreProductos = new JComboBox<Producto>(new Vector<Producto>(productoRepositorio.listar()));

        System.out.println("Productos cargados: " + productoRepositorio.listar().size());
        panel.add(new JLabel("Productos:"));
        panel.add(nombreProductos);

        panel.add(new JLabel("Nombre del Producto:"));
        this.nombre = new JTextField();
        this.nombre.setEditable(false);
        panel.add(this.nombre);

        panel.add(new JLabel("Cantidad a vender:"));
        this.cantidadVenta = new JTextField();
        panel.add(cantidadVenta);

        panel.add(new JLabel("Precio unitario:"));
        this.precio = new JTextField();
        this.precio.setEditable(false);
        panel.add(precio);

        panel.add(new JLabel("Precio Total:"));
        this.precioT = new JTextField();
        this.precioT.setEditable(false);
        panel.add(precioT);

        //=============== Cargo los datos de los productos que tengamos en el sistema
        //=============================================================================

        nombreProductos.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Producto productoSeleccionado = (Producto) nombreProductos.getSelectedItem();
                if (productoSeleccionado != null) {
                    // Actualizar los JTextFields con los datos del producto seleccionado
                    nombre.setText(productoSeleccionado.getNombre());
                    precio.setText(String.valueOf(productoSeleccionado.getPrecio()));

                    // Verificar si la cantidad ingresada es un número válido
                    String cantidadStr = cantidadVenta.getText();
                    try {
                        double cantidad = Double.parseDouble(cantidadStr);
                        double precioTotal = productoSeleccionado.getPrecio() * cantidad;
                        precioT.setText(String.valueOf(precioTotal));
                    } catch (NumberFormatException ex) {
                        // Si la cantidad no es un número válido, limpiar el campo del total
                        precioT.setText("Cantidad inválida");
                    }
                }
            }
        });

        cantidadVenta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Producto productoSeleccionado = (Producto) nombreProductos.getSelectedItem();
                    if (productoSeleccionado != null) {
                        double cantidad = Double.parseDouble(cantidadVenta.getText());
                        double precioTotal = productoSeleccionado.getPrecio() * cantidad;
                        precioT.setText(String.valueOf(precioTotal));
                    }
                } catch (NumberFormatException ex) {
                    precioT.setText("Cantidad inválida");
                }
            }

        });
        return panel;
    }

    public JPanel panelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout());
        this.venderBoton = new JButton("Vender");
        this.cancelarBoton = new JButton("Cancelar");
        panelBotones.add(venderBoton);
        panelBotones.add(cancelarBoton);
        return panelBotones;
    }

    public JButton getVenderBoton() {
        return venderBoton;
    }
}
