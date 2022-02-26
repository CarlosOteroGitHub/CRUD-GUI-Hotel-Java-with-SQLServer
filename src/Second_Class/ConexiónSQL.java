package Second_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexiónSQL {

    //Método Encargado de Establecer la Conexión a la Base de Datos. 
    static Connection conexion = null;

    public static Connection getConnection() {
        String usuario = "sa", contraseña = "12345", nombreDB = "DBSistemaHotelero";
        String url = "jdbc:sqlserver://CharlyOtero-PC\\CHARLYSQLSERVER:1434;databaseName=".concat(nombreDB);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            new Second_Class.Métodos().Sonido("Error");
            JOptionPane.showMessageDialog(null, "No se Pudo Establecer la Conexión al Servidor de la Base de Datos.\n" + e.getMessage(), "Revisa las Configuraciones de Conexión", JOptionPane.ERROR_MESSAGE);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            new Second_Class.Métodos().Sonido("Error");
            JOptionPane.showMessageDialog(null, "No se Pudo Establecer la Conexión al Servidor de la Base de Datos.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }

    //Método Encargado de Realizar Consultas a la Base de Datos.
    public ResultSet Consulta(String consulta) {
        Connection con = getConnection();
        Statement sta;
        try {
            sta = con.createStatement();
            ResultSet respuesta = sta.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
        }
        return null;
    }
}
