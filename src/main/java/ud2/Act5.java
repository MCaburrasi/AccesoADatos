package ud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Act5 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT d.dnombre, (SELECT AVG(salario) FROM empleados where empleados.dept_no = e.dept_no group by dept_no) as avg, e.salario, e.apellido FROM departamentos d inner join empresa.empleados e on d.dept_no = e.dept_no WHERE salario IN (SELECT MAX(salario) from empleados group by dept_no) group by d.dept_no;");

            while(rs.next()){
                String nombre = rs.getString("dnombre");
                String avg = rs.getString("avg");
                String salario = rs.getString("salario");
                String apellido = rs.getString("apellido");

                System.out.println(nombre + " " + avg + " " + salario + " " + apellido);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
}