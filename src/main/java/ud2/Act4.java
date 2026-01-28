package ud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Act4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("SELECT dnombre, AVG(salario) as avg_sal, MAX(salario) as max_sal from empresa.empleados INNER JOIN empresa.departamentos d on empleados.dept_no = d.dept_no GROUP BY d.dept_no");

            while(rs.next()){
                String nombre = rs.getString("dnombre");
                String avg_sal = rs.getString("avg_sal");
                String max_sal = rs.getString("max_sal");

                System.out.println(nombre + " " + avg_sal + " " + max_sal);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
