package modelo;

import controladores.basedatos.BaseDatos;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductosCompras {

    private String nombreP;
    private int cantidadC;
    private LocalDate fecha;
    private Connection connection;

    public ProductosCompras() {
        this.connection = BaseDatos.getConnection();
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getCantidadC() {
        return cantidadC;
    }

    public void setCantidadC(int cantidadC) {
        this.cantidadC = cantidadC;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<ProductosCompras> listarReportesCompras() {
        List<ProductosCompras> listaProductosComprados = new ArrayList<>();
        // String sql = "SELECT * FROM registrocompras";
        String sql = "SELECT r.fechacompra, p.nombre, SUM(r.cantidadcomprada) AS total_cantidad FROM productos AS p JOIN registrocompras AS r ON p.id = r.idproducto GROUP BY r.fechacompra, p.nombre ORDER BY r.fechacompra";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ProductosCompras productosCompras = new ProductosCompras();
                Timestamp timestamp = rs.getTimestamp("fechacompra");
                if (timestamp != null) {
                    productosCompras.setFecha(timestamp.toLocalDateTime().toLocalDate());
                }
                productosCompras.setCantidadC(rs.getInt("total_cantidad"));
                productosCompras.setNombreP(rs.getString("p.nombre"));
                listaProductosComprados.add(productosCompras);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los productos Comprados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pida soporte técnico...");
        }
        return listaProductosComprados;
    }
}
