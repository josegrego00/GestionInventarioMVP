package vista;

import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;
import controladores.respositorio.ProveedorRepositorio;
import modelo.FacturaCompra;
import modelo.Producto;
import modelo.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.util.Vector;

public class CompraProductoView extends JFrame {

    //Variables
    private JComboBox<Producto> nombrePorductos;
    private JComboBox<Proveedor> nombreProveedor;
    private JTextField nombre, cantidad, precio, numeroFactura;
    private JButton botonModificar, botonEliminar, botonLimpiar, comprarboton, salirboton;

    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    //Repositorios
    private ProductoRepositorio productoRepositorio;
    private ProveedorRepositorio proveedorRepositorio;
    private FacturaCompraRepositorio facturaCompraRepositorio;

    //Controladores
    private ControladorIngresarProducto controladorIngresarProducto;

    public CompraProductoView() {

        productoRepositorio = new ProductoRepositorio();
        proveedorRepositorio = new ProveedorRepositorio();
        this.setTitle("Gestión de Compra de Productos");
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(crearPanelDatosGenerales(), BorderLayout.NORTH);
        this.add(crearPanelTablaProductos(), BorderLayout.CENTER);
        this.add(crearPanelBotonesEdicion(), BorderLayout.WEST);
        this.add(crearPanelBotonGuardar(), BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private JPanel crearPanelDatosGenerales() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Datos Generales"));

        panel.add(new JLabel("Número de Factura:"));
        numeroFactura = new JTextField();
        panel.add(numeroFactura);

        //Evento cuando Pierda el Foco.
        //Ideal para verificar si la factura es unica
        numeroFactura.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        panel.add(new JLabel("Proveedor:"));
        this.nombreProveedor = new JComboBox<Proveedor>(new Vector<Proveedor>(proveedorRepositorio.listar()));
        panel.add(nombreProveedor);

        panel.add(new JLabel("Producto:"));
        this.nombrePorductos = new JComboBox<Producto>(new Vector<Producto>(productoRepositorio.listar()));
        panel.add(nombrePorductos);

        panel.add(new JLabel("Cantidad a comprar:"));
        cantidad = new JTextField();
        panel.add(cantidad);

        return panel;
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

        /*nombrePorductos.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
                if (productoSeleccionado != null) {
                    // Actualizar los JTextFields con los datos del producto seleccionado
                    nombre.setText(productoSeleccionado.getNombre());
                    cantidad.setText("");
                    precio.setText("");

                }
            }
        });*/
        return panel;
    }

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

    private JPanel crearPanelBotonGuardar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        comprarboton = new JButton("Guardar Compra");
        salirboton = new JButton("Salir Compra");
        panel.add(comprarboton);
        panel.add(salirboton);
        return panel;
    }

    public void controladorBotonComprar(ControladorIngresarProducto controladorIngresarProducto) {
        this.controladorIngresarProducto = controladorIngresarProducto;
        comprarboton.addActionListener(e -> {
            Producto productoSeleccionado = (Producto) nombrePorductos.getSelectedItem();
            int cantidadAnterior = productoSeleccionado.getCantidad();
            productoSeleccionado.setCantidad((Integer.parseInt(cantidad.getText()) + cantidadAnterior));
            productoSeleccionado.setPrecio(Integer.parseInt(precio.getText()));
            controladorIngresarProducto.cargarCompra(productoSeleccionado);
            nombre.setText("");
            cantidad.setText("");
            precio.setText("");
            productoSeleccionado = null;
        });
    }

}
