package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class UsuarioDao {

	// Definir esas variables necesarias para realizar operaciones sobre la BD

	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	model.UsuarioVo usu = null;

	Conexion c = new Conexion();

	// Métodos

	public UsuarioVo validarUsuario(String correo, String passw) throws SQLException {
		UsuarioVo u = new UsuarioVo();
		sql = "SELECT idUsuario,nombreUsuario,apellidoUsuario,correoUsuario,passwordUsuario,estadoUsuario,descripcionRolUsuario FROM usuario JOIN rolusuario ON rolusuario.idRolUsuario=usuario.idRolUsuarioFK WHERE correoUsuario=? and passwordUsuario=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, passw);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setIdUsuario(rs.getInt(1));
				u.setNombreUsuario(rs.getString(2));
				u.setApellidoUsuario(rs.getString(3));
				u.setCorreoUsuario(rs.getString(4));
				u.setPasswordUsuario(rs.getString(5));
				u.setEstadoUsuario(rs.getBoolean(6));
				u.setRolUs(new RolVo());
				u.getRolUs().setDescripcionRol(rs.getString(7));

			}
			ps.close();
			System.out.println("Se encontró el usuario");
		} catch (Exception e) {
			System.out.println("Se encontró el usuario " + e.getMessage());
		} finally {
			con.close();
		}
		return u;
	}

	public List listar() throws SQLException {

		List<UsuarioVo> users = new ArrayList<>();
		sql = "SELECT idUsuario,tipoDocUsuario,noDocUsuario,nombreUsuario,apellidoUsuario,direccionUsuario,telefonoUsuario,correoUsuario,estadoUsuario, descripcionRolUsuario FROM usuario JOIN rolusuario ON rolusuario.idRolUsuario = usuario.idRolUsuarioFK";
		try {
			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia
			rs = ps.executeQuery();// Ejeución de la sentencia guardar resultado en el resulset

			while (rs.next()) {
				UsuarioVo u = new UsuarioVo();
				u.setIdUsuario(rs.getInt(1));
				u.setTipoDocUsuario(rs.getString(2));
				u.setNoDocUsuario(rs.getString(3));
				u.setNombreUsuario(rs.getString(4));
				u.setApellidoUsuario(rs.getString(5));
				u.setDireccionUsuario(rs.getString(6));
				u.setTelefonoUsuario(rs.getString(7));
				u.setCorreoUsuario(rs.getString(8));
				u.setEstadoUsuario(rs.getBoolean(9));
				u.setRolUs(new RolVo());
				u.getRolUs().setDescripcionRol(rs.getString(10));
				;

				users.add(u);
				System.out.println("Consulta exitosa");

			}

			ps.close();

		} catch (Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		} finally {
			con.close();
		}
		return users;
	}

	public List ListarUnico(UsuarioVo u) throws SQLException {

		System.out.println("Ingreso al metodo listar usuario unico");
		List<UsuarioVo> users = new ArrayList<>();

		sql = "SELECT * from  usuario   where idUsuario=" + u.getIdUsuario();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeQuery(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setIdUsuario(rs.getInt(1));
				u.setTipoDocUsuario(rs.getString(2));
				u.setNoDocUsuario(rs.getString(3));
				u.setNombreUsuario(rs.getString(4));
				u.setApellidoUsuario(rs.getString(5));
				u.setDireccionUsuario(rs.getString(6));
				u.setTelefonoUsuario(rs.getString(7));
				u.setCorreoUsuario(rs.getString(8));

				System.out.println("Se hizo la consulta ");
				users.add(u);
			}
		} catch (Exception e) {
			System.out.println("Consulta no exitosa " + e.getMessage());
			ps.close();
		} finally {
		}
		return users;
	}

	public int registrar(UsuarioVo u) throws SQLException {
		sql = "INSERT INTO usuario(tipoDocUsuario, noDocUsuario, nombreUsuario, apellidoUsuario, direccionUsuario, telefonoUsuario, correoUsuario, passwordUsuario, estadoUsuario, idRolUsuarioFK) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia
			ps.setString(1, u.getTipoDocUsuario());
			ps.setString(2, u.getNoDocUsuario());
			ps.setString(3, u.getNombreUsuario());
			ps.setString(4, u.getApellidoUsuario());
			ps.setString(5, u.getDireccionUsuario());
			ps.setString(6, u.getTelefonoUsuario());
			ps.setString(7, u.getCorreoUsuario());
			ps.setString(8, u.getPasswordUsuario());
			ps.setBoolean(9, u.isEstadoUsuario());
			ps.setInt(10, u.getRolUs().getIdRol());

			System.out.println(ps);
			ps.executeUpdate();// Ejeución de la sentencia
			ps.close();
			System.out.println("Se registró un usuario");

		} catch (Exception e) {
			System.out.println("Error al registrar el usuario" + e.getMessage());
		} finally {
			con.close();
		}
		return row;// Retorna cantidad de filas afectadas
	}

	public int edit(UsuarioVo u) throws SQLException {
		sql = "UPDATE usuario SET tipoDocUsuario=?, noDocUsuario=?, nombreUsuario=?, apellidoUsuario=? , direccionUsuario=? , telefonoUsuario=? , correoUsuario=? , passwordUsuario=? , estadoUsuario=?  WHERE idUsuario="
				+ u.getIdUsuario();

		try {
			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia

			ps.setString(1, u.getTipoDocUsuario());
			ps.setString(2, u.getNoDocUsuario());
			ps.setString(3, u.getNombreUsuario());
			ps.setString(4, u.getApellidoUsuario());
			ps.setString(5, u.getDireccionUsuario());
			ps.setString(6, u.getTelefonoUsuario());
			ps.setString(7, u.getCorreoUsuario());
			ps.setString(8, u.getPasswordUsuario());
			ps.setBoolean(9, u.isEstadoUsuario());

			System.out.println(ps);
			ps.executeUpdate();// Ejeución de la sentencia
			ps.close();
			System.out.println("Se cambió el usuario");

		} catch (Exception e) {
			System.out.println("Error al cambiar al editar el usuario" + e.getMessage());
		} finally {
			con.close();
		}
		return row;// Retorna cantidad de filas afectadas
	}

	public int changePassword(UsuarioVo us) throws SQLException {
		sql = "UPDATE usuario SET passwordUsuario=? WHERE idUsuario=" + us.getIdUsuario();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getPasswordUsuario());
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al registrar el usuario" + e.getMessage());
		} finally {
			con.close();
		}
		return row;// Retorna cantidad de filas afectadas
	}

	public int validarCorreo(String correo) throws SQLException {
		UsuarioVo u = new UsuarioVo();
		int total = 0;
		sql = "SELECT COUNT(*) AS cantidad from usuario WHERE correoUsuario=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt("cantidad");

			}
			ps.close();
			System.out.println("El total de registros que coinciden " + total);
		} catch (Exception e) {
			System.out.println("Error en la consulta " + e.getMessage());
		} finally {
			con.close();
		}
		return total;
	}

	public UsuarioVo consultaId(int id) throws SQLException {

		UsuarioVo u = new UsuarioVo();
		sql = "SELECT *from usuario WHERE idUsuario=" + id;
		try {
			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia
			rs = ps.executeQuery();// Ejeución de la sentencia guardar resultado en el resulset

			while (rs.next()) {

				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setTipoDocUsuario(rs.getString("tipoDocUsuario"));
				u.setNoDocUsuario(rs.getString("noDocUsuario"));
				u.setNombreUsuario(rs.getString("nombreUsuario"));
				u.setApellidoUsuario(rs.getString("apellidoUsuario"));
				u.setDireccionUsuario(rs.getString("direccionUsuario"));
				u.setTelefonoUsuario(rs.getString("telefonoUsuario"));
				u.setCorreoUsuario(rs.getString("correoUsuario"));
				u.setPasswordUsuario(rs.getString("passwordUsuario"));
				u.setEstadoUsuario(rs.getBoolean("estadoUsuario"));

				System.out.println("Consulta exitosa");

			}

			ps.close();

		} catch (Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		} finally {
			con.close();
		}
		return u;
	}

	public int eliminar(int id) throws SQLException {
		sql = "DELETE FROM usuario WHERE idUsuario=" + id;

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

	public int changeEstado(UsuarioVo u) throws SQLException {
		sql = "UPDATE usuario SET estadoUsuario=? WHERE idUsuario=" + u.getIdUsuario();

		try {
			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia
			ps.setBoolean(1, u.isEstadoUsuario());

			System.out.println(ps);
			ps.executeUpdate();// Ejeución de la sentencia
			ps.close();
			System.out.println("Se cambió el estado de un rol");

		} catch (Exception e) {
			System.out.println("Error al cambiar el estado del rol" + e.getMessage());
		} finally {
			con.close();
		}
		return row;// Retorna cantidad de filas afectadas
	}

	public int editunico(UsuarioVo u) throws SQLException {
		sql = "UPDATE usuario SET tipoDocUsuario=?, noDocUsuario=?, nombreUsuario=?, apellidoUsuario=? , direccionUsuario=? , telefonoUsuario=? , correoUsuario=? , passwordUsuario=? , estadoUsuario=?  WHERE idUsuario="
				+ u.getIdUsuario();

		System.out.println("el id del usuario es: " + u.getIdUsuario());

		try {

			con = c.conectar(); // Abriendo la conexión a la BD
			ps = con.prepareStatement(sql); // preparar sentencia

			ps.setString(1, u.getTipoDocUsuario());
			ps.setString(2, u.getNoDocUsuario());
			ps.setString(3, u.getNombreUsuario());
			ps.setString(4, u.getApellidoUsuario());
			ps.setString(5, u.getDireccionUsuario());
			ps.setString(6, u.getTelefonoUsuario());
			ps.setString(7, u.getCorreoUsuario());
			ps.setString(8, u.getPasswordUsuario());
			ps.setBoolean(9, u.isEstadoUsuario());
			System.out.println(ps);
			ps.executeUpdate();// Ejeución de la sentencia
			ps.close();
			System.out.println("Se cambió el rol");
		} catch (Exception e) {
			System.out.println("Error al cambiar el usuario" + e.getMessage());
		} finally {
		}
		return row;// Retorna cantidad de filas afectadas
	}
}
