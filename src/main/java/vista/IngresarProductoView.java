package vista;

import controladores.ControladorIngresarProducto;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarProductoView extends JFrame {

    private JTextField nombre, cantidad, precio, minimoStock;
    private JButton crearProductoBoton, cancelarBoton;
    private ControladorIngresarProducto controladorIngresarProducto;
    public IngresarProductoView() {
        JPanel panelFrane = new JPanel(new BorderLayout());
        this.setTitle("Producto");
        this.setSize(400, 180);
        this.add(panelPrincialFormulario(), BorderLayout.CENTER);
        this.add(panelBotones(), BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public JPanel panelPrincialFormulario() {
        // Agregar etiquetas y campos de texto
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
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

        return panel;
    }

    public JPanel panelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout());
        this.crearProductoBoton = new JButton("Guardar Producto");
        this.cancelarBoton= new JButton("Salir.");
        panelBotones.add(crearProductoBoton);
        panelBotones.add(cancelarBoton);
        return panelBotones;
    }

    public void setConrolador(ControladorIngresarProducto controladorIngresarProducto){
        this.controladorIngresarProducto=controladorIngresarProducto;
        crearProductoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto= new Producto();
                producto.setNombre(nombre.getText());
                producto.setCantidad(Integer.parseInt(cantidad.getText()));
                producto.setPrecio(Double.parseDouble(precio.getText()));
                producto.setMinimoStock(Integer.parseInt(minimoStock.getText()));
                controladorIngresarProducto.crearProducto(producto);
            }
        });
    }



}
