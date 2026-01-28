package ud2.derby;

import java.sql.*;

public class Principal {

	public static void main(String[] args) {
		pruebamysql();
		//pruebamysql2();
	}

	public static void pruebamysql2() {
		try {
			// Cargar el driver
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:derby:empresa", "", "");
          
			// Preparamos la consulta
			Statement sentencia = conexion.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, // Permite moverse en ambas direcciones
					ResultSet.CONCUR_READ_ONLY // Solo lectura
			);

			String sql = "SELECT * FROM departamentos";
			
			ResultSet resul = sentencia.executeQuery(sql);

			resul.last(); // Nos situamos en el último registro
			System.out.println("NÚMERO DE FILAS: " + resul.getRow());

			resul.beforeFirst(); // Nos situamos antes del primer registro

			// Recorremos el resultado para visualizar cada fila
			while (resul.next())
				System.out.printf("Fila %d: %d, %s, %s %n", resul.getRow(), resul.getInt(1), resul.getString(2),
						resul.getString(3));
				

			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de pruebamysql

	public static void pruebamysql() {
		try {
			// Cargar el driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:derby:C:/Users/Marcos/Documents/Derby/bin/MyDb", "", "");

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet resul = sentencia.executeQuery(sql);

			// Recorremos el resultado para visualizar cada fila
			// Se hace un bucle mientras haya registros y se van mostrando
			System.out.println("**** Prueba Mysql ****");
			while (resul.next()) {
				System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
			}

			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de pruebamysql

} // Fin Principal
