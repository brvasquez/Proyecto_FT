package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Configmail;
import model.SolicitudDao;
import model.SolicitudVO;
import model.TutoriaDao;
import model.TutoriaVO;

/**
 * Servlet implementation class SolicitudController
 */
@WebServlet("/SolicitudController")
public class SolicitudController extends HttpServlet {
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
      
	SolicitudDao sdao=new SolicitudDao();
	SolicitudVO s=new SolicitudVO();
	TutoriaDao tdao=new TutoriaDao();
	TutoriaVO t=new TutoriaVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accion=request.getParameter("accion");
		System.out.println("Entró al controlador"+accion);
		
		try {
			if(accion!=null) {
				switch(accion) {
				
				case "listarSolicitudes":
					//System.out.println("Entró a la opción listar");
					listarSolicitudes(request,response);
				break;
				
				case "listarSolicitudesEstudiante":
					//System.out.println("Entró a la opción listar");
					listarSolicitudesEstudiante(request,response);
				break;
				
				case "listarSolicitudesTutor":
					//System.out.println("Entró a la opción listar");
					listarSolicitudesTutor(request,response);
				break;
				
				case "listarSolicitudesTutorCorreo":
					//System.out.println("Entró a la opción listar");
					listarSolicitudesTutorCorreo(request,response);
				break;
				
				
				case "abrirForm":
					abrirForm(request,response);
				break;
				
				case "add":
					add(request,response);
				break;
				case "add2":
					add2(request,response);
				break;
					
				case "delete":
					delete(request,response);
				break;
				
				case "changeEstado":
					changeEstado(request,response);
				break;
				
				case "ver":
					ver(request,response);
				break;
				case "verEnviada":
					verEnviada(request,response);
				break;
				
				case "edit":
					edit(request,response);
				break;
				
				case "Buscar":
					String dato=request.getParameter("txtBuscar");
					List<SolicitudVO>lista=sdao.buscar(dato);
					request.setAttribute("datos", lista);
					request.getRequestDispatcher("views/MenuCards.jsp").forward(request, response);
				break;
				
				
				default:
					response.sendRedirect("views/login.jsp");
				}
			}
			
			else {
				response.sendRedirect("views/login.jsp");
			}
		}catch(Exception e) {
			
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void listarSolicitudes(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			request.getRequestDispatcher("views/solicitud.jsp").forward(request, response);
			System.out.println("Tutorias encontradas");
			
			
		}catch(Exception e) {
			System.out.println("Tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void listarSolicitudesEstudiante(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			request.getRequestDispatcher("views/solicitudEstudiante.jsp").forward(request, response);
			System.out.println("Tutorias encontradas");
			
			
		}catch(Exception e) {
			System.out.println("Tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void listarSolicitudesTutor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			List tutoria=tdao.listarTutorias();
			request.setAttribute("tutorias",tutoria);
			request.getRequestDispatcher("views/tutoria.jsp").forward(request, response);
			System.out.println("solicitud en las tutorias encontradas");
			
			
			
		}catch(Exception e) {
			System.out.println("Solicitud en las tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void listarSolicitudesTutorCorreo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			List tutoria=tdao.listarTutorias();
			request.setAttribute("tutorias",tutoria);
			request.getRequestDispatcher("views/solicitudCorreoTutor.jsp").forward(request, response);
			System.out.println("solicitud en las tutorias encontradas");
			
			
			
		}catch(Exception e) {
			System.out.println("Solicitud en las tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void abrirForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("views/solicitud-add.jsp").forward(request, response);
			System.out.println("Formulario solicitud abierto");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario de solicitud");
			}
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("nombre") != null && request.getParameter("descripcion") != null) {
			
			s.setNombre(request.getParameter("nombre"));
			s.setDescripcion(request.getParameter("descripcion"));
			s.setUsuario(request.getParameter("usuario"));
			s.setEstudianteSolicitante(request.getParameter("estudianteSolicitante"));
			s.setCorreo(request.getParameter("correo"));
			s.setDescripcionSolicitud(request.getParameter("descripcionSolicitud"));
			s.setRolEstudiante(request.getParameter("rolEstudiante"));
			
			
		}

		if (request.getParameter("chkEstado") != null) {
			s.setEstado(true);
		} else {
			s.setEstado(false);
		}

	
		
		try {
			sdao.registrar(s);
			response.sendRedirect("SolicitudController?accion=listarSolicitudesEstudiante");
			System.out.println("solicitud registrada");
			System.out.println("" + s.getNombre() + s.getDescripcion() + s.getUsuario()
					+ s.isEstado());
		} catch (Exception e) {

			System.out.println("Error al registrar la solicitud");
		}
		
	}
	
	private void add2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("nombre") != null && request.getParameter("descripcion") != null) {
			
			s.setNombre(request.getParameter("nombre"));
			s.setDescripcion(request.getParameter("descripcion"));
			s.setUsuario(request.getParameter("usuario"));
			s.setEstudianteSolicitante(request.getParameter("estudianteSolicitante"));
			s.setCorreo(request.getParameter("correo"));
			s.setDescripcionSolicitud(request.getParameter("descripcionSolicitud"));
			s.setRolEstudiante(request.getParameter("rolEstudiante"));
			
			
		}

		if (request.getParameter("chkEstado") != null) {
			s.setEstado(true);
		} else {
			s.setEstado(false);
		}

		String tutoriaNombre=request.getParameter("nombre");
		String descripcionTutoria=request.getParameter("descripcion");
		String tutor=request.getParameter("usuario");
		String estudiante=request.getParameter("estudianteSolicitante");
		String descripcionSolicitud=request.getParameter("descripcionSolicitud");
		
		
		String destinatario = request.getParameter("correo");
		String asunto = "SOLICITUD DE  FRIENDLY TUTTOR ";
		String cuerpo = "<h2> Gracacias por solicitar nuestras tutorias </h2>" + " <img src =''/>"
				+ " <h4> La inteligencia consiste no sólo en el conocimiento, sino también en la destreza de aplicar los conocimientos en la práctica - Aristóteles</h4>"
				+ " <h5>Tutoria Escogida </h5>:"+tutoriaNombre+"<br>"+"<h5>Descripcion de la tutoria :</h5>"+descripcionTutoria+"<br>"+"<h5>Tutor Elegido :</h5>"+tutor+"<br>"+"<h5>Solicitante :</h5>"+estudiante+
				"<br>"+"<h5>Descipcion de la solicitud :</h5>"+descripcionSolicitud+"<br>";

		try {
			Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
			System.out.println("El Correo Solicitud fue enviado correctamente");
		} catch (Exception e) {
			System.out.println("El Correo Solicitud NO fue enviado correctamente " + e.getMessage());
		}
		
		try {
			sdao.registrar(s);
			response.sendRedirect("SolicitudController?accion=listarSolicitudesTutorCorreo");
			System.out.println("solicitud registrada");
			System.out.println("" + s.getNombre() + s.getDescripcion() + s.getUsuario()
					+ s.isEstado());
		} catch (Exception e) {

			System.out.println("Error al registrar la solicitud");
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null) {
			s.setId(Integer.parseInt(request.getParameter("id")));
		}

		try {
			sdao.eliminar(s.getId());
			response.sendRedirect("SolicitudController?accion=listarSolicitudes");
			System.out.println("solicitud eliminada");
		} catch (Exception e) {

			System.out.println("Error al eliminar la solicitud");
		}
		
	}
	
	private void changeEstado(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setEstado(Boolean.parseBoolean(request.getParameter("es")));

		try {
			sdao.changeEstado(s);
			response.sendRedirect("SolicitudController?accion=listarSolicitudes");
			System.out.println("Estado cambiado");
		} catch (Exception e) {

			System.out.println("Error al cambiar el estado ");
		}
		
	}
	
	private void ver(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		s.setId(Integer.parseInt(request.getParameter("id")));
		try {
			s = sdao.consultaId(s.getId());
			request.setAttribute("solicitudes", s);
			request.getRequestDispatcher("views/solicitud-edit.jsp").forward(request, response);
			System.out.println("solicitud encontrada");

		} catch (Exception e) {
			System.out.println("solicitud no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}
	
	private void verEnviada(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		s.setId(Integer.parseInt(request.getParameter("id")));
		try {
			s = sdao.consultaId(s.getId());
			request.setAttribute("solicitudes", s);
			request.getRequestDispatcher("views/solicitud-enviada.jsp").forward(request, response);
			System.out.println("solicitud encontrada");

		} catch (Exception e) {
			System.out.println("solicitud no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null && request.getParameter("nombre") != null
				&& request.getParameter("descripcion") != null) {
			
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setNombre(request.getParameter("nombre"));
			s.setDescripcion(request.getParameter("descripcion"));
			s.setUsuario(request.getParameter("usuario"));
			
			s.setEstudianteSolicitante(request.getParameter("estudianteSolicitante"));
			s.setRolEstudiante(request.getParameter("rolEstudiante"));
		

		}

		if (request.getParameter("chkEstado") != null) {
			s.setEstado(true);
		} else {
			s.setEstado(false);
		}

		try {
			sdao.edit(s);
			response.sendRedirect("SolicitudController?accion=listarSolicitudes");
			System.out.println("Solicitud cambiada");
		} catch (Exception e) {

			System.out.println("Error al cambiar la solicitud");
		}
		
	}

}
