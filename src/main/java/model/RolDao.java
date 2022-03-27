package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class RolDao {
	
	//Definir esas variables necesarias para realizar operaciones sobre la BD
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();

	//Métodos
	
	public List listarRoles() throws SQLException {
		
		List<RolVo> roles=new ArrayList<>();
		sql="SELECT *from rolUsuario";
		try {
			con=c.conectar(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
			
			while(rs.next()) {
				RolVo r=new RolVo();
				r.setIdRol(rs.getInt("idRolUsuario"));
				r.setDescripcionRol(rs.getString("descripcionRolUsuario"));
				r.setEstadoRol(rs.getBoolean("estadoRolUsuario"));
				
				roles.add(r);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return roles;
	}
	
	
public int registrar(RolVo r) throws SQLException {
	sql="INSERT INTO rolusuario(descripcionRolUsuario,estadoRolUsuario) VALUES (?,?)";
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1,r.getDescripcionRol());
		ps.setBoolean(2, r.isEstadoRol());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró un rol");
		
	}catch(Exception e) {
		System.out.println("Error al registrar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}


public int eliminar(int id) throws SQLException {
	sql="DELETE FROM rolusuario WHERE idRolUsuario="+id;
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se eliminó un rol");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int changeEstado(RolVo r) throws SQLException {
	sql="UPDATE rolusuario SET estadoRolUsuario=? WHERE idRolUsuario="+r.getIdRol();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setBoolean(1, r.isEstadoRol());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se cambió el estado de un rol");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el estado del rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
	
public RolVo consultaId(int id) throws SQLException {
	
	RolVo r=new RolVo();
	sql="SELECT *from rolUsuario WHERE idRolUsuario="+id;
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
		
		while(rs.next()) {
			
			r.setIdRol(rs.getInt("idRolUsuario"));
			r.setDescripcionRol(rs.getString("descripcionRolUsuario"));
			r.setEstadoRol(rs.getBoolean("estadoRolUsuario"));
			
			System.out.println("Consulta exitosa");
			
		}
		
		ps.close();
		
		
	}catch(Exception e) {
		System.out.println("Consulta no exitosa" +e.getMessage());
	}
	finally {
		con.close();
	}
	return r;
}

public int edit(RolVo r) throws SQLException {
	sql="UPDATE rolusuario SET descripcionRolUsuario=?, estadoRolUsuario=? WHERE idRolUsuario="+r.getIdRol();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getDescripcionRol());
		ps.setBoolean(2, r.isEstadoRol());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se cambió el rol");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}



}
