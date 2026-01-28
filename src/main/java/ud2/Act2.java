package ud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Act2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT apellido, salario FROM EMPLEADOS ORDER BY salario LIMIT 1");

            rs.next();
            String apellido = rs.getString("apellido");
            String salario = rs.getString("salario");

            System.out.println(apellido + " " + salario);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
