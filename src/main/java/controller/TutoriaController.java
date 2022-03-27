package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import model.RolVo;
import model.TutoriaDao;
import model.TutoriaVO;
import model.SolicitudDao;
import model.SolicitudVO;


/**
 * Servlet implementation class TutoriaController
 */

@WebServlet("/TutoriaController")

public class TutoriaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	TutoriaDao tdao=new TutoriaDao();
	TutoriaVO t=new TutoriaVO();
	SolicitudDao sdao=new SolicitudDao();
	SolicitudVO s=new SolicitudVO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public TutoriaController() {
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
				
				case "listarTutorias":
					//System.out.println("Entró a la opción listar");
					listarTutorias(request,response);
				break;
				case "listarTutorias2":
					//System.out.println("Entró a la opción listar");
					listarTutorias2(request,response);
				break;
				case "listarMenu":
					//System.out.println("Entró a la opción listar");
					listarMenu(request,response);
				break;
				
				case "abrirForm":
					abrirForm(request,response);
				break;
				
				case "add":
					add(request,response);
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
				
				case "ver2":
					ver2(request,response);
				break;
				
				case "verTutoria":
					verTutoria(request,response);
				break;
				
				case "edit":
					edit(request,response);
				break;
				
				case "validarNombre":
					validarNombre(request,response);
				break;
				
				
				default:
					response.sendRedirect("login.jsp");
				}
			}
			
			else {
				response.sendRedirect("login.jsp");
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


	private void abrirForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.getRequestDispatcher("views/tutoria-add.jsp").forward(request, response);
			System.out.println("Formulario Tutoria abierto");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario Tutoria");
			}
		
	}

	private void listarTutorias(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List tutoria=tdao.listarTutorias();
			request.setAttribute("tutorias",tutoria);
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			request.getRequestDispatcher("views/tutoria.jsp").forward(request, response);
			System.out.println("Tutorias encontradas");
			
			
		}catch(Exception e) {
			System.out.println("Tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	private void listarTutorias2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List tutoria=tdao.listarTutorias();
			request.setAttribute("tutorias",tutoria);
			List solicitudes=sdao.listarSolicitud();
			request.setAttribute("solicitud",solicitudes);
			request.getRequestDispatcher("views/tutoria.jsp").forward(request, response);
			System.out.println("Tutorias encontradas");
			
			
		}catch(Exception e) {
			System.out.println("Tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	private void listarMenu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("Entramos al método listar");
		
		try {
			List tutoria=tdao.listarTutorias();
			request.setAttribute("tutoria",tutoria);
			request.getRequestDispatcher("views/MenuCards.jsp").forward(request, response);
			System.out.println("Tutorias 2 encontradas");
			
			
		}catch(Exception e) {
			System.out.println("Tutorias no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("nombre") != null && request.getParameter("descripcion") != null) {
			
			t.setNombre(request.getParameter("nombre"));
			t.setDescripcion(request.getParameter("descripcion"));
			t.setUsuario(request.getParameter("usuario"));
			
		}

		if (request.getParameter("chkEstado") != null) {
			t.setEstado(true);
		} else {
			t.setEstado(false);
		}
		
		try {
			tdao.registrar(t);
			response.sendRedirect("TutoriaController?accion=listarTutorias");
			System.out.println("Tutoria registrada");
			System.out.println("" + t.getNombre() + t.getDescripcion() + t.getUsuario()
					+ t.isEstado());
		} catch (Exception e) {

			System.out.println("Error al registrar la tutoria");
		}
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null) {
			t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
		}

		try {
			tdao.eliminar(t.getIdTutoria());
			response.sendRedirect("TutoriaController?accion=listarTutorias");
			System.out.println("Tutoria eliminada");
		} catch (Exception e) {

			System.out.println("Error al eliminar la tutoria");
		}
		
	}

	
	private void ver(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
		try {
			t = tdao.consultaId(t.getIdTutoria());
			request.setAttribute("tutorias", t);
			request.getRequestDispatcher("views/tutoria-edit.jsp").forward(request, response);
			System.out.println("tutoria encontrada");

		} catch (Exception e) {
			System.out.println("tutoria no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}
	

	private void ver2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
		try {
			t = tdao.consultaId(t.getIdTutoria());
			request.setAttribute("tu", t);
			request.getRequestDispatcher("views/tutoria.jsp").forward(request, response);
			System.out.println("tutoria encontrada");

		} catch (Exception e) {
			System.out.println("tutoria no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}
	
	private void verTutoria(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
		try {
			t = tdao.consultaId(t.getIdTutoria());
			request.setAttribute("tutorias", t);
			request.getRequestDispatcher("views/ver.jsp").forward(request, response);
			System.out.println("tutoria card encontrada");

		} catch (Exception e) {
			System.out.println("tutoria no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}

	private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO Auto-generated method stub
		
		

			t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
			t.setEstado(Boolean.parseBoolean(request.getParameter("es")));

			try {
				tdao.changeEstado(t);
				response.sendRedirect("TutoriaController?accion=listarTutorias");
				System.out.println("Estado cambiado");
			} catch (Exception e) {

				System.out.println("Error al cambiar el estado ");
			}
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null && request.getParameter("nombre") != null
				&& request.getParameter("descripcion") != null) {
			
			t.setIdTutoria(Integer.parseInt(request.getParameter("id")));
			t.setNombre(request.getParameter("nombre"));
			t.setDescripcion(request.getParameter("descripcion"));
			t.setUsuario(request.getParameter("usuario"));
			
		

		}

		if (request.getParameter("chkEstado") != null) {
			t.setEstado(true);
		} else {
			t.setEstado(false);
		}

		try {
			tdao.edit(t);
			response.sendRedirect("TutoriaController?accion=listarTutorias");
			System.out.println("Tutoria cambiada");
		} catch (Exception e) {

			System.out.println("Error al cambiar la tutoria");
		}
		
	}
	
	private void validarNombre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			int cant = tdao.validarTutoria(request.getParameter("nombre"));
			System.out.println("nombre de tutorias encontrados " + cant);

			if (cant != 0) {
				System.out.println("El nombre de la tutoria ya se encuentra registrado");
				out.println("El nombre de la tutoria ya se encuentra registrado");
			} else {
				System.out.println("El nombre de la tutoria ya no encuentra registrado");
				out.println("El nombre de la tutoria no se encuentra registrado puede continuar su registro");
			}

		} catch (Exception e) {
			System.out.println("nombre de la tutoria no encontrado " + e.getMessage());
		} finally {
			// rdao=null;
		}

	}

}
