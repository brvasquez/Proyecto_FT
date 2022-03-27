package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	//Definición de atributos de la conexión
	private static final String bd="jdbc:mysql://localhost:3306/bdguia";
	private static final String usuario="root";
	private static final String clave="";
	
	private static Connection con;
	
	
	//Método de conexión
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(bd,usuario,clave);
			System.out.println("Conexión Exitosa");
		}catch(Exception e) {
			System.out.println("Error en la conexión "+e.getMessage().toString());
		}
		
		return con;
	}
}
