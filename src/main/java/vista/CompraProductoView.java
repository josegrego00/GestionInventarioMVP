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

        //=============== Cargo los datos de los productos que teng en el sistema
        //=============================================================================

        nombrePorductos.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
                if (productoSeleccionado != null) {
                    // Actualizar los JTextFields con los datos del producto seleccionado
                    nombre.setText(productoSeleccionado.getNombre());
                    cantidad.setText("");
                    precio.setText("");

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

        public void controladorBotonComprar(ControladorIngresarProducto controladorIngresarProducto) {
            this.controladorIngresarProducto = controladorIngresarProducto;
            comprarboton.addActionListener(e -> {
                Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
                int cantidadAnterior=productoSeleccionado.getCantidad();
                productoSeleccionado.setCantidad((Integer.parseInt(cantidad.getText())+cantidadAnterior));
                productoSeleccionado.setPrecio(Integer.parseInt(precio.getText()));
                controladorIngresarProducto.cargarCompra(productoSeleccionado);
                nombre.setText("");
                cantidad.setText("");
                precio.setText("");
                productoSeleccionado=null;
            });
    }

}
