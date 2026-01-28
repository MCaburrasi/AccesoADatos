package ud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Act1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT apellido, oficio, salario FROM EMPRESA.EMPLEADOS where DEPT_NO = 10");

            while (rs.next()){
                String apellido = rs.getString("apellido");
                String oficio = rs.getString("oficio");
                String salario = rs.getString("salario");

                System.out.println(apellido + " " + oficio + " " + salario);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
