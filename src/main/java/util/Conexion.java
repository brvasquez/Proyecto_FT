package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	//Definici�n de atributos de la conexi�n
	private static final String bd="jdbc:mysql://localhost:3306/bdguia";
	private static final String usuario="root";
	private static final String clave="";
	
	private static Connection con;
	
	
	//M�todo de conexi�n
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(bd,usuario,clave);
			System.out.println("Conexi�n Exitosa");
		}catch(Exception e) {
			System.out.println("Error en la conexi�n "+e.getMessage().toString());
		}
		
		return con;
	}
}
