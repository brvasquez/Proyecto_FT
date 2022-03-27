package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MaterialApoyoVO;

import util.Conexion;

public class MaterialApoyoDao {

	
	
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	Conexion c=new Conexion();
	
	
public List listarMaterial() throws SQLException {
		
		List<MaterialApoyoVO> materiales=new ArrayList<>();
		sql="SELECT *from materialapoyo";
		try {
			con=c.conectar(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
			
			while(rs.next()) {
				MaterialApoyoVO m=new  MaterialApoyoVO();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setDescripcion(rs.getString("descripcion"));
				m.setLink(rs.getString("link"));
				
				materiales.add(m);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return materiales;
	}

public MaterialApoyoVO consultaId(int id) throws SQLException {
	
	MaterialApoyoVO m=new MaterialApoyoVO();
	sql="SELECT *from materialapoyo WHERE id="+id;
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		rs=ps.executeQuery();//Ejeución de la sentencia guardar resultado en el resulset
		
		while(rs.next()) {
			
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			m.setDescripcion(rs.getString("descripcion"));
			m.setLink(rs.getString("link"));
			
			
			
			
			System.out.println("Consulta exitosa");
			
		}
		
		ps.close();
		
		
	}catch(Exception e) {
		System.out.println("Consulta no exitosa" +e.getMessage());
	}
	finally {
		con.close();
	}
	return m;
}

public int registrar(MaterialApoyoVO m) throws SQLException {
	sql="INSERT INTO materialapoyo(nombre,descripcion,link) VALUES (?,?,?)";
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1,m.getNombre());
		ps.setString(2,m.getDescripcion());
		ps.setString(3,m.getLink());
		
		
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
	sql = "DELETE FROM materialapoyo WHERE id=" + id;

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

public int edit(MaterialApoyoVO m) throws SQLException {
	sql="UPDATE materialapoyo SET nombre=?,descripcion=?,link=? WHERE id="+m.getId();
	
	try {
		con=c.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		ps.setString(1, m.getNombre());
		ps.setString(2, m.getDescripcion());
		ps.setString(3, m.getLink());
		
		
		
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
