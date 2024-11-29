package pruebas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CompraProductoView2 extends JFrame {

            private JTextField numeroFactura, proveedor, nombreProducto, cantidad, precio;
            private JTable tablaProductos;
            private DefaultTableModel modeloTabla;
            private JButton botonGuardar, botonModificar, botonEliminar, botonLimpiar;

            public CompraProductoView2() {
                this.setTitle("Gestión de Compra de Productos");
                this.setSize(600, 400);
                this.setLayout(new BorderLayout());
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);

                // Paneles organizados
                this.add(crearPanelDatosGenerales(), BorderLayout.NORTH);
                this.add(crearPanelTablaProductos(), BorderLayout.CENTER);
                this.add(crearPanelBotonesEdicion(), BorderLayout.WEST);
                this.add(crearPanelBotonGuardar(), BorderLayout.SOUTH);

                this.setVisible(true);
            }

            // Panel 1: Datos generales
            private JPanel crearPanelDatosGenerales() {
                JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
                panel.setBorder(BorderFactory.createTitledBorder("Datos Generales"));

                panel.add(new JLabel("Número de Factura:"));
                numeroFactura = new JTextField();
                panel.add(numeroFactura);

                panel.add(new JLabel("Proveedor:"));
                proveedor = new JTextField();
                panel.add(proveedor);

                panel.add(new JLabel("Producto:"));
                nombreProducto = new JTextField();
                panel.add(nombreProducto);

                panel.add(new JLabel("Cantidad:"));
                cantidad = new JTextField();
                panel.add(cantidad);

                return panel;
            }

            // Panel 2: Tabla de productos
            private JPanel crearPanelTablaProductos() {
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createTitledBorder("Productos en la Compra"));

                String[] columnas = {"Producto", "Cantidad", "Precio Unitario", "Precio Total"};
                modeloTabla = new DefaultTableModel(columnas, 0);
                tablaProductos = new JTable(modeloTabla);

                JScrollPane scrollTabla = new JScrollPane(tablaProductos);
                panel.add(scrollTabla, BorderLayout.CENTER);

                return panel;
            }

            // Panel 3: Botones para editar la tabla
            private JPanel crearPanelBotonesEdicion() {
                JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
                panel.setBorder(BorderFactory.createTitledBorder("Opciones"));

                botonModificar = new JButton("Modificar");
                botonEliminar = new JButton("Eliminar");
                botonLimpiar = new JButton("Limpiar");

                panel.add(botonModificar);
                panel.add(botonEliminar);
                panel.add(botonLimpiar);

                return panel;
            }

            // Panel 4: Botón para guardar
            private JPanel crearPanelBotonGuardar() {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                botonGuardar = new JButton("Guardar Compra");
                panel.add(botonGuardar);
                return panel;
            }

            // Getters para los componentes necesarios
            public JTextField getNumeroFactura() {
                return numeroFactura;
            }

            public JTextField getProveedor() {
                return proveedor;
            }

            public JTextField getNombreProducto() {
                return nombreProducto;
            }

            public JTextField getCantidad() {
                return cantidad;
            }

            public JTable getTablaProductos() {
                return tablaProductos;
            }

            public DefaultTableModel getModeloTabla() {
                return modeloTabla;
            }

            public JButton getBotonGuardar() {
                return botonGuardar;
            }

            public JButton getBotonModificar() {
                return botonModificar;
            }

            public JButton getBotonEliminar() {
                return botonEliminar;
            }

            public JButton getBotonLimpiar() {
                return botonLimpiar;
            }
        }

