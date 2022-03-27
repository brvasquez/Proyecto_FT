package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author diego
 */
public class Conectar {
    Connection con;
    String bd="bdguia";
    String url ="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String password="";
    public  Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection(url, user, password);
            System.out.println("se conecto");
        } catch (ClassNotFoundException ex) {
           System.out.println("no se conecto");
        } catch (SQLException ex) {
            System.out.println("no se conecto");
        }
        
    }
     public Connection getConnection(){
        return con;
    }

    public void desconectar(){
        con = null;
    }
}