package pe.edu.upeu.repository;

import pe.edu.upeu.conn.SQLiteConnection;
import pe.edu.upeu.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private Connection conn = SQLiteConnection.getInstance().getConnection();
    private static ClienteRepository instance;

    private ClienteRepository() {}

    public static ClienteRepository getInstance() {
        if (instance == null) instance = new ClienteRepository();
        return instance;
    }

    public void agregarCliente(Cliente c) {
        String sql = "INSERT INTO cliente (id, nombre, telefono, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM cliente")) {
            while (rs.next()) {
                lista.add(new Cliente(rs.getString("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void actualizarCliente(Cliente c, int index) {
        String sql = "UPDATE cliente SET nombre=?, telefono=?, email=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminarCliente(String ruc) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ruc);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}