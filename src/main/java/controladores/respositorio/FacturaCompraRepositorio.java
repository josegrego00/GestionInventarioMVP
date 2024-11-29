package controladores.respositorio;

import controladores.basedatos.BaseDatos;
import modelo.FacturaCompra;
import modelo.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacturaCompraRepositorio implements  repositorio<FacturaCompra> {

    private Connection connection;

    public FacturaCompraRepositorio() {
        this.connection= BaseDatos.getConnection();
    }

    @Override
    public void create(FacturaCompra facturaCompra) {

    }

    @Override
    public void delete(FacturaCompra facturaCompra) {

    }

    @Override
    public FacturaCompra read(int i) {
        FacturaCompra facturaCompra;
        String sql = "SELECT * FROM productos WHERE numerofactura=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, i);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                facturaCompra = new FacturaCompra();
                facturaCompra.setId(rs.getInt("id"));
                facturaCompra.set(rs.getString("nombre"));
                facturaCompra.setCantidad(rs.getInt("cantidad"));
                facturaCompra.setPrecio(rs.getDouble("precio"));

                return producto;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro producto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(FacturaCompra facturaCompra) {

    }

    @Override
    public List<FacturaCompra> listar() {
        return List.of();
    }
}
