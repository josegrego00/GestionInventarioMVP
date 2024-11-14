package vista;

import javax.swing.*;
import java.awt.*;

public class IngresarProductoView extends JFrame {

    private JTextField nombre, cantidad, precio, minimoStock;
    private JButton crearProductoBoton;

    public IngresarProductoView() {
        this.setTitle("Producto");
        this.setSize(400, 250);
        this.add(panelPrincial());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public JPanel panelPrincial() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        // Agregar etiquetas y campos de texto
        panel.add(new JLabel("Nombre del Producto:"));
        this.nombre = new JTextField();
        panel.add(this.nombre);

        panel.add(new JLabel("Cantidad:"));
        this.cantidad = new JTextField();
        panel.add(cantidad);

        panel.add(new JLabel("Precio:"));
        this.precio = new JTextField();
        panel.add(precio);

        panel.add(new JLabel("Stock Mínimo:"));
        this.minimoStock = new JTextField();
        panel.add(minimoStock);

        // Botón para guardar
        this.crearProductoBoton = new JButton("Guardar Producto");
        panel.add(crearProductoBoton);

        // Añadir un espacio vacío para ajustar el diseño
        panel.add(new JLabel(""));

        return panel;
    }

}
