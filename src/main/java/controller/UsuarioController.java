package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Configmail;
import model.RolDao;
import model.RolVo;
import model.UsuarioDao;
import model.UsuarioVo;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

	private String host;
	private String puerto;
	private String remitente;
	private String password;

	public void init() {
		ServletContext contexto = getServletContext();
		host = contexto.getInitParameter("host");
		puerto = contexto.getInitParameter("puerto");
		remitente = contexto.getInitParameter("remitente");
		password = contexto.getInitParameter("password");
	}

	private static final long serialVersionUID = 1L;

	UsuarioVo u = new UsuarioVo();
	UsuarioDao udao = new UsuarioDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion = request.getParameter("accion");
		HttpSession session = request.getSession();
		System.out.println("Entró al controlador" + accion);
		try {
			if (accion != null) {
				switch (accion) {

				case "abrirLogin":
					abrirLogin(request, response);
					break;
				case "abrirRegistro":
					abrirRegistro(request, response);
					break;	

				case "login":
					u.setCorreoUsuario(request.getParameter("correo"));
					u.setPasswordUsuario(request.getParameter("password"));

					try {
						u = udao.validarUsuario(u.getCorreoUsuario(), u.getPasswordUsuario());
						
					        
						
						
						
						if ( u != null && u.getRolUs().getDescripcionRol().equals("Admin") ) {
				            session = request.getSession();
				            session.setAttribute("us", u);
				            request.setAttribute("msje", "Bienvenido ");
				            this.getServletConfig().getServletContext().getRequestDispatcher("/UsuarioController?accion=listar").forward(request, response);
				            
				            
				            
						} else if (u.getNombreUsuario() != null && u.isEstadoUsuario() == true) {
								System.out.println("Se encontro un usuario activo");
								session.setAttribute("us", u);
								

							} else if (u.getNombreUsuario() != null && u.isEstadoUsuario() == false) {
								System.out.println("Se encontro un usuario inactivo");
								response.sendRedirect(
										"UsuarioController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
							} else {
								System.out.println("Se encontro no registrado");
								response.sendRedirect(
										"UsuarioController?accion=abrirLogin&msn=Datos de acceso incorrectos");
							}
				            
				        if(u != null && u.getRolUs().getDescripcionRol().equals("Estudiante")){
				           session = request.getSession();
				            session.setAttribute("Estudiante", u);
				            this.getServletConfig().getServletContext().getRequestDispatcher("/TutoriaController?accion=listarMenu").forward(request, response);
				            
				        }
				        else if(u != null && u.getRolUs().getDescripcionRol().equals("Tutor")){
					           session = request.getSession();
					            session.setAttribute("Tutor", u);
					            this.getServletConfig().getServletContext().getRequestDispatcher("/TutoriaController?accion=listarTutorias2").forward(request, response); 
					        
				        }else {
				            request.setAttribute("msje", "Credenciales Incorrectas");
				            request.getRequestDispatcher("index.jsp").forward(request, response);
				        }
						
						

						
						
						
					
						
						
						
					} catch (Exception e) {
						System.out.println("Se presentó un error " + e);
					}

					break;

				case "logout":
					session.removeAttribute("us");
					session.invalidate();
					response.sendRedirect("UsuarioController?accion=abrirLogin&msn=Se ha cerrado la sesión");
					break;

				case "openPass":
					abrirchangepass(request, response);
					break;
					
				case "openPassTutor":
					abrirchangepassTutor(request, response);
					break;
					
				case "openPassEstudiante":
					abrirchangepassEstudiante(request, response);
					break;		

				case "changePass":
					changePass(request, response);
					break;
					
				case "changePassTutor":
					changePassTutor(request, response);
					break;
					
				case "changePassEstudiante":
					changePassEstudiante(request, response);
					break;	
					
				case "listar":
					// System.out.println("Entró a la opción listar");
					listar(request, response);
					break;

				case "abrirForm":
					abrirForm(request, response);
					break;
				
				case "abrirFormRegistro":
					abrirFormRegistro(request, response);
					break;


				case "add":
					add(request, response);
					break;
				
				case "add2":
					add2(request, response);
					break;	

				case "validarCorreo":
					validarCorreo(request, response);
					break;
				case "delete":
					delete(request, response);
					break;
				case "changeEstado":
					changeEstado(request, response);
					break;

				case "ver":
					ver(request, response);
					break;

				case "edit":
					edit(request, response);
					break;
				case "verunico":
					verunico(request, response);
					break;
				case "verunicoTutor":
					verunicoTutor(request, response);
					break;	
					
				case "verunicoEstudiante":
					verunicoEstudiante(request, response);
					break;	

				case "editunico":
					editunico(request, response);
					break;
				case "editunicoTutor":
					editunicoTutor(request, response);
					break;	
					
				case "editunicoEstudiante":
					editunicoEstudiante(request, response);
					break;	
				case "ListarUnico":
					System.out.println("Entro al  caso Listarusuario unico");
					ListarUnico(request, response);
				case "ListarUnicoTutor":
					System.out.println("Entro al  caso Listarusuario unico");
					ListarUnicoTutor(request, response);
				
				case "ListarUnicoEstudiante":
					System.out.println("Entro al  caso Listarusuario unico");
					ListarUnicoEstudiante(request, response);	
				 case "verificar":
                     verificar(request, response);
                     break;

				default:
					response.sendRedirect("login.jsp");
				}
			}

			else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {

		}
	}

	private void verificar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	 private UsuarioVo obtenerRoles(HttpServletRequest request) {
		 UsuarioVo u = new UsuarioVo();
		    u.setCorreoUsuario(request.getParameter("correo"));
			u.setPasswordUsuario(request.getParameter("password"));
	        return u;
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void abrirLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			System.out.println("Login abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario Login");
		}
	}
	private void abrirRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/RegistroUsu.jsp").forward(request, response);
			System.out.println("registro abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario registro");
		}
	}

	private void abrirchangepass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePass.jsp").forward(request, response);
			System.out.println("Cambio Password abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}
	
	private void abrirchangepassTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePassTutor.jsp").forward(request, response);
			System.out.println("Cambio Password Tutor abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}
	
	private void abrirchangepassEstudiante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePassEstudiante.jsp").forward(request, response);
			System.out.println("Cambio Password Tutor abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}

	private void changePass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		if (request.getParameter("id") != null && request.getParameter("passnew") != null) {
			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setPasswordUsuario(request.getParameter("passnew"));

			try {
				udao.changePassword(u);
				request.getRequestDispatcher("UsuarioController?accion=logout").forward(request, response);
			} catch (Exception e) {
				System.out.println("Error al cambiar password");
			}
		}
	}
	
	private void changePassTutor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		if (request.getParameter("id") != null && request.getParameter("passnew") != null) {
			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setPasswordUsuario(request.getParameter("passnew"));

			try {
				udao.changePassword(u);
				request.getRequestDispatcher("UsuarioController?accion=logout").forward(request, response);
			} catch (Exception e) {
				System.out.println("Error al cambiar password");
			}
		}
	}
	
	private void changePassEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		if (request.getParameter("id") != null && request.getParameter("passnew") != null) {
			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setPasswordUsuario(request.getParameter("passnew"));

			try {
				udao.changePassword(u);
				request.getRequestDispatcher("UsuarioController?accion=logout").forward(request, response);
			} catch (Exception e) {
				System.out.println("Error al cambiar password");
			}
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Entramos al método listar");

		try {
			List usu = udao.listar();
			request.setAttribute("user", usu);
			request.getRequestDispatcher("views/usuario.jsp").forward(request, response);
			System.out.println("Usuarios encontrados");

		} catch (Exception e) {
			System.out.println("Usuarios no encontrados " + e.getMessage());
		} finally {
			// rdao=null;
		}

	}

	private void abrirForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			this.obtenerRoles(request, response);
			request.getRequestDispatcher("views/usuario-add.jsp").forward(request, response);
			System.out.println("Formulario Usuario abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario Usuario");
		}
	}
	
	private void abrirFormRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			this.obtenerRoles(request, response);
			request.getRequestDispatcher("views/RegistroUsu.jsp").forward(request, response);
			System.out.println("Formulario Usuario abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario Usuario");
		}
	}

	private void obtenerRoles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entramos al método obtener roles");
		RolDao rdao = new RolDao();
		List<RolVo> rol = null;

		try {
			rol = rdao.listarRoles();
			request.setAttribute("roles", rol);

			System.out.println("Roles encontrados");

		} catch (Exception e) {
			System.out.println("Roles no encontrados " + e.getMessage());
		} finally {
			// rdao=null;
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("nombre") != null && request.getParameter("apellido") != null) {
			u.setTipoDocUsuario(request.getParameter("tipodoc"));
			u.setNoDocUsuario(request.getParameter("numdoc"));
			u.setNombreUsuario(request.getParameter("nombre"));
			u.setApellidoUsuario(request.getParameter("apellido"));
			u.setDireccionUsuario(request.getParameter("direccion"));
			u.setTelefonoUsuario(request.getParameter("telefono"));
			u.setCorreoUsuario(request.getParameter("correo"));
			u.setPasswordUsuario(request.getParameter("password"));
			RolVo r = new RolVo();
			r.setIdRol(Integer.parseInt(request.getParameter("rolusu")));
			u.setRolUs(r);
			
			

		}

		if (request.getParameter("chkEstado") != null) {
			u.setEstadoUsuario(true);
		} else {
			u.setEstadoUsuario(false);
		}

		String usuario=request.getParameter("nombre");
		
		String destinatario = request.getParameter("correo");
		String asunto = "BIENVENIDO A FRIENDLY TUTTOR   ";
		String cuerpo = "<h2> Gracacias por registrarte con nosotros  </h2>" + " <img src =''/>"
				+ " <h4> La inteligencia consiste no sólo en el conocimiento, sino también en la destreza de aplicar los conocimientos en la práctica - Aristóteles</h4>"
				+ " bienvernido Friendly Tutoor"+"Su usuario es :"+usuario;

		try {
			Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
			System.out.println("El mensaje fue enviado correctamente");
		} catch (Exception e) {
			System.out.println("El mensaje NO fue enviado correctamente " + e.getMessage());
		}

		try {
			udao.registrar(u);
			response.sendRedirect("UsuarioController?accion=listar");
			System.out.println("Usuario registrado");
			System.out.println("" + u.getTipoDocUsuario() + u.getNoDocUsuario() + u.getNombreUsuario()
					+ u.getApellidoUsuario() + u.getTelefonoUsuario() + u.getCorreoUsuario() + u.getPasswordUsuario()
					+ u.getEstadoUsuarioRep() + u.getRolUs().getIdRol());
		} catch (Exception e) {

			System.out.println("Error al registrar usuario");
		}
	}
	

	private void add2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("nombre") != null && request.getParameter("apellido") != null) {
			u.setTipoDocUsuario(request.getParameter("tipodoc"));
			u.setNoDocUsuario(request.getParameter("numdoc"));
			u.setNombreUsuario(request.getParameter("nombre"));
			u.setApellidoUsuario(request.getParameter("apellido"));
			u.setDireccionUsuario(request.getParameter("direccion"));
			u.setTelefonoUsuario(request.getParameter("telefono"));
			u.setCorreoUsuario(request.getParameter("correo"));
			u.setPasswordUsuario(request.getParameter("password"));
			RolVo r = new RolVo();
			r.setIdRol(Integer.parseInt(request.getParameter("rolusu")));
			u.setRolUs(r);
			
			

		}

		if (request.getParameter("chkEstado") != null) {
			u.setEstadoUsuario(true);
		} else {
			u.setEstadoUsuario(false);
		}

		String usuario=request.getParameter("nombre");
		
		String destinatario = request.getParameter("correo");
		String asunto = "BIENVENIDO A FRIENDLY TUTTOR   ";
		String cuerpo = "<h2> Gracacias por registrarte con nosotros  </h2>" + " <img src =''/>"
				+ " <h4> La inteligencia consiste no sólo en el conocimiento, sino también en la destreza de aplicar los conocimientos en la práctica - Aristóteles</h4>"
				+ " bienvernido Friendly Tutoor"+"Su usuario es :"+usuario;

		try {
			Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
			System.out.println("El mensaje fue enviado correctamente");
		} catch (Exception e) {
			System.out.println("El mensaje NO fue enviado correctamente " + e.getMessage());
		}

		try {
			udao.registrar(u);
			response.sendRedirect("UsuarioController?accion=abrirLogin");
			System.out.println("Usuario registrado");
			System.out.println("" + u.getTipoDocUsuario() + u.getNoDocUsuario() + u.getNombreUsuario()
					+ u.getApellidoUsuario() + u.getTelefonoUsuario() + u.getCorreoUsuario() + u.getPasswordUsuario()
					+ u.getEstadoUsuarioRep() + u.getRolUs().getIdRol());
		} catch (Exception e) {

			System.out.println("Error al registrar usuario");
		}
	}


	private void validarCorreo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();
		try {
			int cant = udao.validarCorreo(request.getParameter("correo"));
			System.out.println("Usuarios encontrados " + cant);

			if (cant != 0) {
				System.out.println("El correo ya se encuentra registrado");
				out.println("El correo ya se encuentra registrado");
			} else {
				System.out.println("El correo ya no encuentra registrado");
				out.println("El correo no se encuentra registrado puede continuar su registro");
			}

		} catch (Exception e) {
			System.out.println("Correo no encontrado " + e.getMessage());
		} finally {
			// rdao=null;
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
		}

		try {
			udao.eliminar(u.getIdUsuario());
			response.sendRedirect("UsuarioController?accion=listar");
			System.out.println("Usuario eliminado");
		} catch (Exception e) {

			System.out.println("Error al eliminar el formulario Rol");
		}
	}

	private void changeEstado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
		u.setEstadoUsuario(Boolean.parseBoolean(request.getParameter("es")));

		try {
			udao.changeEstado(u);
			response.sendRedirect("UsuarioController?accion=listar");
			System.out.println("Rol cambiado");
		} catch (Exception e) {

			System.out.println("Error al cambiar el estado del Rol");
		}
	}

	private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
		try {
			u = udao.consultaId(u.getIdUsuario());
			request.setAttribute("usuarios", u);
			request.getRequestDispatcher("views/usuario-edit.jsp").forward(request, response);
			System.out.println("usuario encontrados");

		} catch (Exception e) {
			System.out.println("usuario no encontrados " + e.getMessage());
		} finally {
			// rdao=null;
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null && request.getParameter("tipoDocUsuario") != null
				&& request.getParameter("noDocUsuario") != null) {

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setTipoDocUsuario(request.getParameter("tipoDocUsuario"));
			u.setNoDocUsuario(request.getParameter("noDocUsuario"));
			u.setNombreUsuario(request.getParameter("nombreUsuario"));
			u.setApellidoUsuario(request.getParameter("apellidoUsuario"));
			u.setDireccionUsuario(request.getParameter("direccionUsuario"));
			u.setTelefonoUsuario(request.getParameter("telefonoUsuario"));
			u.setCorreoUsuario(request.getParameter("correoUsuario"));
			u.setPasswordUsuario(request.getParameter("passwordUsuario"));

		}

		if (request.getParameter("chkEstado") != null) {
			u.setEstadoUsuario(true);
		} else {
			u.setEstadoUsuario(false);
		}

		try {
			udao.edit(u);
			response.sendRedirect("UsuarioController?accion=listar");
			System.out.println("Usuario cambiado");
		} catch (Exception e) {

			System.out.println("Error al cambiar el Usuario");
		}
	}

	private void verunico(HttpServletRequest request, HttpServletResponse response) {

		try {
			if (request.getParameter("id") != null) {

				System.out.print("Se recibio el id");
			}
			System.out.print("Entro al metodo consultar");

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u = udao.consultaId(u.getIdUsuario());
			request.setAttribute("usuarios", u);

			request.getRequestDispatcher("views/editarUnico.jsp")

					.forward(request, response);

		} catch (Exception e) {

		} finally {
		}
	}
	
	private void verunicoTutor(HttpServletRequest request, HttpServletResponse response) {

		try {
			if (request.getParameter("id") != null) {

				System.out.print("Se recibio el id");
			}
			System.out.print("Entro al metodo consultar");

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u = udao.consultaId(u.getIdUsuario());
			request.setAttribute("usuarios", u);

			request.getRequestDispatcher("views/editarUnicoTutor.jsp")

					.forward(request, response);

		} catch (Exception e) {

		} finally {
		}
	}
	
	private void verunicoEstudiante(HttpServletRequest request, HttpServletResponse response) {

		try {
			if (request.getParameter("id") != null) {

				System.out.print("Se recibio el id");
			}
			System.out.print("Entro al metodo consultar");

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u = udao.consultaId(u.getIdUsuario());
			request.setAttribute("usuarios", u);

			request.getRequestDispatcher("views/editarUnicoEstudiante.jsp")

					.forward(request, response);

		} catch (Exception e) {

		} finally {
		}
	}
	
	private void editunicoTutor(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("id") != null && request.getParameter("tipoDocUsuario") != null) {

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setTipoDocUsuario(request.getParameter("tipoDocUsuario"));
			u.setNoDocUsuario(request.getParameter("noDocUsuario"));
			u.setNombreUsuario(request.getParameter("nombreUsuario"));
			u.setApellidoUsuario(request.getParameter("apellidoUsuario"));
			u.setDireccionUsuario(request.getParameter("direccionUsuario"));
			u.setTelefonoUsuario(request.getParameter("telefonoUsuario"));
			u.setCorreoUsuario(request.getParameter("correoUsuario"));
			u.setPasswordUsuario(request.getParameter("passwordUsuario"));

			System.out.print("Llego el id y los datos");

		}
		try {
			udao.editunico(u);
			List users = udao.listar();
			request.setAttribute("usuarios", users);
			response.sendRedirect("UsuarioController?accion=ListarUnicoTutor");
			request.getRequestDispatcher("Controlador?accion=ListarUnicoTutor")

					.forward(request, response);
			System.out.print("Se  actualizo el usuario");
		} catch (Exception e) {

			System.out.println("Error al cambiar el Usuario");
		}
	}
	
	private void editunicoEstudiante(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("id") != null && request.getParameter("tipoDocUsuario") != null) {

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setTipoDocUsuario(request.getParameter("tipoDocUsuario"));
			u.setNoDocUsuario(request.getParameter("noDocUsuario"));
			u.setNombreUsuario(request.getParameter("nombreUsuario"));
			u.setApellidoUsuario(request.getParameter("apellidoUsuario"));
			u.setDireccionUsuario(request.getParameter("direccionUsuario"));
			u.setTelefonoUsuario(request.getParameter("telefonoUsuario"));
			u.setCorreoUsuario(request.getParameter("correoUsuario"));
			u.setPasswordUsuario(request.getParameter("passwordUsuario"));

			System.out.print("Llego el id y los datos");

		}
		try {
			udao.editunico(u);
			List users = udao.listar();
			request.setAttribute("usuarios", users);
			response.sendRedirect("UsuarioController?accion=ListarUnicoEstudiante");
			request.getRequestDispatcher("Controlador?accion=ListarUnicoEstudiante")

					.forward(request, response);
			System.out.print("Se  actualizo el usuario");
		} catch (Exception e) {

			System.out.println("Error al cambiar el Usuario");
		}
	}
	// TODO Auto-generated method stub

	private void editunico(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("id") != null && request.getParameter("tipoDocUsuario") != null) {

			u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			u.setTipoDocUsuario(request.getParameter("tipoDocUsuario"));
			u.setNoDocUsuario(request.getParameter("noDocUsuario"));
			u.setNombreUsuario(request.getParameter("nombreUsuario"));
			u.setApellidoUsuario(request.getParameter("apellidoUsuario"));
			u.setDireccionUsuario(request.getParameter("direccionUsuario"));
			u.setTelefonoUsuario(request.getParameter("telefonoUsuario"));
			u.setCorreoUsuario(request.getParameter("correoUsuario"));
			u.setPasswordUsuario(request.getParameter("passwordUsuario"));

			System.out.print("Llego el id y los datos");

		}
		try {
			udao.editunico(u);
			List users = udao.listar();
			request.setAttribute("usuarios", users);
			response.sendRedirect("UsuarioController?accion=ListarUnico");
			request.getRequestDispatcher("Controlador?accion=ListarUnico")

					.forward(request, response);
			System.out.print("Se  actualizo el usuario");
		} catch (Exception e) {

			System.out.println("Error al cambiar el Usuario");
		}

	}

	private void ListarUnico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.print("Entro al metodo listarusuario  ");
			List users = udao.ListarUnico(u);
			request.setAttribute("usuarios", users);
			request.getRequestDispatcher("views/ListaUnico.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally {
		}
	}
	private void ListarUnicoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.print("Entro al metodo listarusuario  ");
			List users = udao.ListarUnico(u);
			request.setAttribute("usuarios", users);
			request.getRequestDispatcher("views/ListaUnicoTutor.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally {
		}
	}
	
	private void ListarUnicoEstudiante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.print("Entro al metodo listarusuario  ");
			List users = udao.ListarUnico(u);
			request.setAttribute("usuarios", users);
			request.getRequestDispatcher("views/ListaUnicoEstudiante.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally {
		}
	}
	
	  
}
