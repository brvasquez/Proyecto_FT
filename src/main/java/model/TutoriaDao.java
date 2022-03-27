package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class TutoriaDao {

	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	Conexion c=new Conexion();
	
	
public List listarTutorias() throws SQLException {
		
		List<TutoriaVO> tutorias=new ArrayList<>();
		sql="SELECT *from tutoria";
		try {
			con=c.conectar(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
			
			while(rs.next()) {
				TutoriaVO t=new TutoriaVO();
				t.setIdTutoria(rs.getInt("idTutoria"));
				t.setNombre(rs.getString("nombre"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setUsuario(rs.getString("usuario"));
				t.setEstado(rs.getBoolean("estado"));
				
			    tutorias.add(t);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return tutorias;
	}

public TutoriaVO consultaId(int id) throws SQLException {
	
	TutoriaVO t=new TutoriaVO();
	sql="SELECT *from tutoria WHERE idTutoria="+id;
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
		
		while(rs.next()) {
			
			t.setIdTutoria(rs.getInt("idTutoria"));
			t.setNombre(rs.getString("nombre"));
			t.setDescripcion(rs.getString("descripcion"));
			t.setUsuario(rs.getString("usuario"));
			t.setEstado(rs.getBoolean("estado"));
			
			
			
			System.out.println("Consulta exitosa");
			
		}
		
		ps.close();
		
		
	}catch(Exception e) {
		System.out.println("Consulta no exitosa" +e.getMessage());
	}
	finally {
		con.close();
	}
	return t;
}

public int registrar(TutoriaVO t) throws SQLException {
	sql="INSERT INTO tutoria(nombre,descripcion,usuario,estado) VALUES (?,?,?,?)";
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1,t.getNombre());
		ps.setString(2,t.getDescripcion());
		ps.setString(3,t.getUsuario());
		ps.setBoolean(4,t.isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró una tutoria");
		
	}catch(Exception e) {
		System.out.println("Error al registrar la tutoria" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int eliminar(int id) throws SQLException {
	sql = "DELETE FROM tutoria WHERE idTutoria=" + id;

	try {
		con = c.conectar(); // Abriendo la conexión a la BD
		ps = con.prepareStatement(sql); // preparar sentencia

		System.out.println(ps);
		ps.executeUpdate();// Ejeución de la sentencia
		ps.close();
		System.out.println("Se eliminó un usuario");

	} catch (Exception e) {
		System.out.println("Error al eliminar el usuario" + e.getMessage());
	} finally {
		con.close();
	}
	return row;// Retorna cantidad de filas afectadas
}


public int changeEstado(TutoriaVO t) throws SQLException {
	sql = "UPDATE tutoria SET estado=? WHERE idTutoria=" + t.getIdTutoria();

	try {
		con = c.conectar(); // Abriendo la conexión a la BD
		ps = con.prepareStatement(sql); // preparar sentencia
		ps.setBoolean(1, t.isEstado());

		System.out.println(ps);
		ps.executeUpdate();// Ejeución de la sentencia
		ps.close();
		System.out.println("Se cambió el estado ");

	} catch (Exception e) {
		System.out.println("Error al cambiar el estado " + e.getMessage());
	} finally {
		con.close();
	}
	return row;// Retorna cantidad de filas afectadas
}


public int edit(TutoriaVO t) throws SQLException {
	sql="UPDATE tutoria SET nombre=?,descripcion=?,usuario=?, estado=? WHERE idTutoria="+t.getIdTutoria();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1, t.getNombre());
		ps.setString(2, t.getDescripcion());
		ps.setString(3, t.getUsuario());
		ps.setBoolean(4, t.isEstado());
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se edito la tutoria");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el la tutoria" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int validarTutoria(String nombre) throws SQLException {
	UsuarioVo u = new UsuarioVo();
	int total = 0;
	sql = "SELECT COUNT(*)AS cantidad from tutoria WHERE nombre=?";
	try {
		con = c.conectar();
		ps = con.prepareStatement(sql);
		
		ps.setString(1,nombre);
		rs = ps.executeQuery();
		while (rs.next()) {
			total = rs.getInt("cantidad");

		}
		ps.close();
		System.out.println("El total de nombres que coinciden " + total);
	} catch (Exception e) {
		System.out.println("Error en la consulta de validar nombre " + e.getMessage());
	} finally {
		con.close();
	}
	return total;
}

}
