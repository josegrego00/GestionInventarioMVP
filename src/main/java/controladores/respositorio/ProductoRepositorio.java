package controladores.respositorio;

import controladores.basedatos.BaseDatos;
import modelo.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProductoRepositorio implements repositorio<Producto> {

    private Connection connection;

    public ProductoRepositorio() {
        this.connection = BaseDatos.getConnection();
    }

    @Override
    public void create(Producto producto) {
        String sql = "INSERT INTO productos (nombre, cantidad, precio, minimo_stock) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getMinimoStock());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se Creo un producto");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No se Pueden crear 2 Productos con el mismo nombre");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al ingresar los Datos");
        }
    }

    @Override
    public void delete(Producto producto) {

    }

    @Override
    public Producto read() {
        return null;
    }

    @Override
    public void update(Producto producto) {

    }
}
