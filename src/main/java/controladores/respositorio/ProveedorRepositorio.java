package controladores.respositorio;

import controladores.basedatos.BaseDatos;
import modelo.Producto;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorRepositorio implements repositorio<Proveedor>{
    private Connection connection;

    public ProveedorRepositorio() {
        this.connection=BaseDatos.getConnection();
    }

    @Override
    public void create(Proveedor proveedor) {

    }

    @Override
    public void delete(Proveedor proveedor) {

    }

    @Override
    public Proveedor read(int i) {
        return null;
    }

    @Override
    public void update(Proveedor proveedor) {

    }

    @Override
    public List<Proveedor> listar() {
        List<Proveedor> listaProveedor= new ArrayList<>();
        String sql="SELECT * FROM proveedor";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setTelefono(rs.getString("telefono"));
                listaProveedor.add(proveedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los Proveedores");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pida soporte técnico...");
        }
        return  listaProveedor;
    }
}
