package ud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Act3 {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

            Statement stm1 = conexion.createStatement();
            ResultSet rs = stm1.executeQuery("SELECT dnombre, loc, apellido, oficio FROM departamentos d INNER JOIN empresa.empleados e on d.dept_no = e.dept_no order by d.dept_no");
            String dnombre = "";

            while (rs.next()){
                if (!dnombre.equals(rs.getString("dnombre"))){
                    if (!dnombre.isEmpty()){
                        System.out.println("}\n");
                    }
                    dnombre = rs.getString("dnombre");
                    System.out.println(rs.getString("dnombre") + " " + rs.getString("loc") + " {");
                }

                System.out.println("\t" + rs.getString("apellido") + " " + rs.getString("oficio"));
            }

            System.out.println("}\n");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
