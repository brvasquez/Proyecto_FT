package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class SolcitudenviadaDao {
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	Conexion c=new Conexion();
	
	
public List listarSolicitudEnviada() throws SQLException {
		
		List<SolcitudenviadaVO> solicitudes=new ArrayList<>();
		sql="SELECT *from solicitudenviada";
		try {
			con=c.conectar(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
			
			while(rs.next()) {
				SolcitudenviadaVO s=new SolcitudenviadaVO();
				s.setId(rs.getInt("id"));
				s.setNombre(rs.getString("nombre"));
				s.setDescripcion(rs.getString("descripcion"));
				s.setUsuario(rs.getString("usuario"));
				s.setEstado(rs.getBoolean("estado"));
				s.setEstudianteSolicitante(rs.getString("estudianteSolicitante"));
				s.setCorreo(rs.getString("correo"));
				s.setDescripcionSolicitud(rs.getString("descripcionSolicitud"));
				s.setRolEstudiante(rs.getString("rolEstudiante"));
				
			    solicitudes.add(s);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return solicitudes;
	}

public SolcitudenviadaVO consultaId(int id) throws SQLException {
	
	SolcitudenviadaVO s=new SolcitudenviadaVO();
	sql="SELECT *from solicitudenviada WHERE id="+id;
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
		
		while(rs.next()) {
			
			s.setId(rs.getInt("id"));
			s.setNombre(rs.getString("nombre"));
			s.setDescripcion(rs.getString("descripcion"));
			s.setUsuario(rs.getString("usuario"));
			s.setEstado(rs.getBoolean("estado"));
			s.setEstudianteSolicitante(rs.getString("estudianteSolicitante"));
			s.setCorreo(rs.getString("correo"));
			s.setDescripcionSolicitud(rs.getString("descripcionSolicitud"));
			s.setRolEstudiante(rs.getString("rolEstudiante"));
			
			
			
			System.out.println("Consulta exitosa");
			
		}
		
		ps.close();
		
		
	}catch(Exception e) {
		System.out.println("Consulta no exitosa" +e.getMessage());
	}
	finally {
		con.close();
	}
	return s;
}

public int registrar(SolcitudenviadaVO s) throws SQLException {
	sql="INSERT INTO solicitudenviada(nombre,descripcion,usuario,estado,estudianteSolicitante,correo,descripcionSolicitud,rolEstudiante) VALUES (?,?,?,?,?,?,?,?)";
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1,s.getNombre());
		ps.setString(2,s.getDescripcion());
		ps.setString(3,s.getUsuario());
		ps.setBoolean(4,s.isEstado());
		ps.setString(5,s.getEstudianteSolicitante());
		ps.setString(6,s.getCorreo());
		ps.setString(7,s.getDescripcionSolicitud());
		ps.setString(8,s.getRolEstudiante());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró una solicitud");
		
	}catch(Exception e) {
		System.out.println("Error al registrar la solicitud" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int eliminar(int id) throws SQLException {
	sql = "DELETE FROM solicitudenviada WHERE id=" + id;

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


public int changeEstado(SolcitudenviadaVO t) throws SQLException {
	sql = "UPDATE solicitudenviada SET estado=? WHERE id=" + t.getId();

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


public int edit(SolcitudenviadaVO s) throws SQLException {
	sql="UPDATE solicitudenviada SET nombre=?,descripcion=?,usuario=?, estado=?, estudianteSolicitante=?, correo=?, descripcionSolicitud=?, rolEstudiante=? WHERE id="+s.getId();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1, s.getNombre());
		ps.setString(2, s.getDescripcion());
		ps.setString(3, s.getUsuario());
		ps.setBoolean(4, s.isEstado());
		ps.setString(5,s.getEstudianteSolicitante());
		ps.setString(6,s.getCorreo());
		ps.setString(7,s.getDescripcionSolicitud());
		ps.setString(8,s.getRolEstudiante());
		
		
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
