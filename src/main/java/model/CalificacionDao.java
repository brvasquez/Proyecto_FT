package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class CalificacionDao {

	

	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	Conexion c=new Conexion();
	
	
public List listarCalificacion() throws SQLException {
		
		List<CalificaionVo> calificaciones=new ArrayList<>();
		sql="SELECT *from calificacion";
		try {
			con=c.conectar(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
			
			while(rs.next()) {
				CalificaionVo ca=new  CalificaionVo();
				ca.setId(rs.getInt("id"));
				ca.setNombreTutoria(rs.getString("nombreTutoria"));
				ca.setTutor(rs.getString("tutor"));
				ca.setEstudiante(rs.getString("estudiante"));
				ca.setCalificacion(rs.getString("calificacion"));
				
				calificaciones.add(ca);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return calificaciones;
	}


	
public CalificaionVo consultaId(int id) throws SQLException {
	
	CalificaionVo ca=new CalificaionVo();
	sql="SELECT *from calificaion WHERE id="+id;
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
		
		while(rs.next()) {
			
			ca.setId(rs.getInt("id"));
			ca.setNombreTutoria(rs.getString("nombreTutoria"));
			ca.setTutor(rs.getString("tutor"));
			ca.setEstudiante(rs.getString("estudiante"));
			ca.setCalificacion(rs.getString("calificacion"));
			
			
			
			
			System.out.println("Consulta exitosa");
			
		}
		
		ps.close();
		
		
	}catch(Exception e) {
		System.out.println("Consulta no exitosa" +e.getMessage());
	}
	finally {
		con.close();
	}
	return ca;
}

public int registrar(CalificaionVo ca) throws SQLException {
	sql="INSERT INTO calificaion(nombreTutoria,tutor,estudiante,calificacion) VALUES (?,?,?,?)";
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1,ca.getNombreTutoria());
		ps.setString(2,ca.getTutor());
		ps.setString(3,ca.getEstudiante());
		ps.setString(4,ca.getCalificacion());
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró una calificacion");
		
	}catch(Exception e) {
		System.out.println("Error al registrar la calificacion" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int eliminar(int id) throws SQLException {
	sql = "DELETE FROM calificaion WHERE id=" + id;

	try {
		con = c.conectar(); // Abriendo la conexión a la BD
		ps = con.prepareStatement(sql); // preparar sentencia

		System.out.println(ps);
		ps.executeUpdate();// Ejeución de la sentencia
		ps.close();
		System.out.println("Se eliminó ");

	} catch (Exception e) {
		System.out.println("Error al eliminar" + e.getMessage());
	} finally {
		con.close();
	}
	return row;// Retorna cantidad de filas afectadas
}

public int edit(CalificaionVo ca) throws SQLException {
	sql="UPDATE calificaion SET nombreTutoria=?,tutor=?,estudiante=?,calificacion=? WHERE id="+ca.getId();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1, ca.getNombreTutoria());
		ps.setString(2,ca.getTutor());
		ps.setString(3,ca.getEstudiante());
		ps.setString(4,ca.getCalificacion());
		
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se edito la solicitud");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el la solicitud" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}


	
}
