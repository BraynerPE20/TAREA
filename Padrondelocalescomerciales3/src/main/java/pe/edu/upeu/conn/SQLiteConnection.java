package pe.edu.upeu.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteConnection {
    private static SQLiteConnection instance;
    private Connection connection;
    private String url = "jdbc:sqlite:data/cliente_db";

    private SQLiteConnection() {
        try {
            connection = DriverManager.getConnection(url);

            // --- ESTO ES LO QUE TE FALTA PARA QUE SALGA EL MENSAJE ---
            System.out.println("Conexión a SQLite establecida.");
            // ---------------------------------------------------------

        } catch (SQLException e) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static SQLiteConnection getInstance() {
        if (instance == null) {
            instance = new SQLiteConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}