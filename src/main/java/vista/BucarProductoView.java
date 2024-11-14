package vista;

import javax.swing.*;
import java.awt.*;

public class BucarProductoView extends JFrame {

    private JComboBox nombrePorductos;
    private JTextField nombre, cantidad, precio, minimoStock;
    private JButton buscarBoton, modificarBoton, eliminarBoton, cancelarBoton;


    public BucarProductoView() {
        JPanel panelFrane = new JPanel(new BorderLayout());
        this.setTitle("Buscar, Modificar, Eliminar Producto");
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

        this.nombrePorductos= new JComboBox();
        panel.add(new JLabel("Productos:"));
        panel.add(nombrePorductos);

        panel.add(new JLabel("Nombre del Producto:"));
        this.nombre = new JTextField();
        nombre.setEditable(false);
        panel.add(this.nombre);

        panel.add(new JLabel("Cantidad:"));
        this.cantidad = new JTextField();
        cantidad.setEditable(false);
        panel.add(cantidad);

        panel.add(new JLabel("Precio:"));
        this.precio = new JTextField();
        precio.setEditable(false);
        panel.add(precio);

        panel.add(new JLabel("Stock Mínimo:"));
        this.minimoStock = new JTextField();
        minimoStock.setEditable(false);
        panel.add(minimoStock);

        return panel;
    }

    public JPanel panelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout());
        this.buscarBoton = new JButton("Buscar.");
        this.modificarBoton = new JButton("Modificar.");
        this.eliminarBoton = new JButton("Eliminar.");
        this.cancelarBoton = new JButton("Salir.");

        panelBotones.add(buscarBoton);
        panelBotones.add(modificarBoton);
        panelBotones.add(eliminarBoton);
        panelBotones.add(cancelarBoton);
        return panelBotones;
    }
}
