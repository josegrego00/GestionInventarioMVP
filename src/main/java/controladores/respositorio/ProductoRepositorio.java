package controladores.respositorio;

import controladores.basedatos.BaseDatos;
import modelo.Producto;

import javax.swing.*;
import java.sql.*;

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
            JOptionPane.showMessageDialog(null, "Error al ingresar los Datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pida Soporte...");
        }
    }

    @Override
    public void delete(Producto producto) {
        String sql = "DELETE FROM productos WHERE nombre=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            int sw = stmt.executeUpdate();
            if (sw > 0) {
                JOptionPane.showMessageDialog(null, "Se Elimino el producto");
            }
            if (sw == 0) {
                JOptionPane.showMessageDialog(null, "No se Elimino ningun Reguistro");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pida Soporte...");
        }
    }

    @Override
    public Producto read(int i) {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, i);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setMinimoStock(rs.getInt("minimo_stock"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro producto");
            }
        } catch (SQLException e) {

        }
        return producto;
    }

    @Override
    public void update(Producto producto) {
        String sql = "UPDATE productos SET nombre=?,cantidad=?,precio=?,minimo_stock=? WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getMinimoStock());
            stmt.setInt(5, producto.getId());
            int i = stmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Se Actualizaron los Datos de un Producto");
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro producto, No se cambio ningun dato");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
