package ud2;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StatementAct1 {
    public static void DeleteDepartment(Connection conn, int code) throws SQLException {
        String c = "{call EraseDep(?)}";
        CallableStatement cs = conn.prepareCall(c);

        cs.setInt("dep_code", code);
        cs.execute();

        System.out.println("Departamento eliminado");
    }

    public static void SumSalary(Connection conn, int code) throws SQLException {
        String c = "{call SumSal(?, ?)}";
        CallableStatement cs = conn.prepareCall(c);

        cs.setInt("dep_code", code);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();

        System.out.println(cs.getInt(2));
    }

    public static void ChangeLocation(Connection conn, int code, String newLoc) throws SQLException {
        String c = "{call ChangeLoc(?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(c);

        cs.setInt("dep_code", code);
        cs.setString("new_loc", newLoc);
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.execute();

        System.out.println(cs.getString(3));
    }

    public static void Menu(Scanner sc, Connection conn) throws SQLException {
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.print("Codigo de departamento: ");
                DeleteDepartment(conn, sc.nextInt());
                break;
            case 2:
                System.out.print("Codigo de departamento: ");
                SumSalary(conn, sc.nextInt());
                break;
            case 3:
                System.out.print("Codigo de departamento: ");
                int n = sc.nextInt();
                System.out.print("Nueva localización: ");
                sc.nextLine();
                String s = sc.nextLine();
                ChangeLocation(conn, n, s);
                break;
            case 4:
                break;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "Caburrasi", "u1d2t3c4");

        while(true){
            Menu(sc, conn);
        }
    }
}
