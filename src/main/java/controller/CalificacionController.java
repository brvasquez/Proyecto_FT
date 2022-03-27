package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalificacionDao;
import model.CalificaionVo;


@WebServlet("/CalificacionController")
public class CalificacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CalificacionDao cadao=new CalificacionDao();
	CalificaionVo ca=new CalificaionVo();
    
    public CalificacionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String accion=request.getParameter("accion");
		System.out.println("Entró al controlador"+accion);
		
		try {
			if(accion!=null) {
				switch(accion) {
				
				case "listarCalificacion":
					//System.out.println("Entró a la opción listar");
					listarCalificacion(request,response);
				break;
				
				case "listarCalificacionTutor":
					//System.out.println("Entró a la opción listar");
					listarCalificacionTutor(request,response);
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
				
				case "ver":
					ver(request,response);
				break;
				
				case "edit":
					edit(request,response);
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

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		

		if (request.getParameter("id") != null && request.getParameter("nombreTutoria") != null
				&& request.getParameter("tutor") != null) {
			
			ca.setId(Integer.parseInt(request.getParameter("id")));
			ca.setNombreTutoria(request.getParameter("nombreTutoria"));
			ca.setTutor(request.getParameter("tutor"));
			ca.setEstudiante(request.getParameter("estudiante"));
			ca.setCalificacion(request.getParameter("calificacion"));
			
		}
		try {
			cadao.edit(ca);
			response.sendRedirect("CalificacionController?accion=listarCalificacion");
			System.out.println("calificacion cambiada");
		} catch (Exception e) {

			System.out.println("Error al cambiar la calificacion");
		}
		
		
	}

	private void ver(HttpServletRequest request, HttpServletResponse response) {
		
		ca.setId(Integer.parseInt(request.getParameter("id")));
		try {
			ca = cadao.consultaId(ca.getId());
			request.setAttribute("calificaciones", ca);
			request.getRequestDispatcher("views/Calificaciones-edit.jsp").forward(request, response);
			System.out.println("calificacion encontrada");

		} catch (Exception e) {
			System.out.println("calificacion no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		
		if (request.getParameter("id") != null) {
			ca.setId(Integer.parseInt(request.getParameter("id")));
		}

		try {
			cadao.eliminar(ca.getId());
			response.sendRedirect("CalificacionController?accion=listarCalificacion");
			System.out.println("calificacion eliminada");
		} catch (Exception e) {

			System.out.println("Error al eliminar la calificacion");
		}
		
		
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		
		if (request.getParameter("nombreTutoria") != null && request.getParameter("tutor") != null) {
			
			ca.setNombreTutoria(request.getParameter("nombreTutoria"));
			ca.setTutor(request.getParameter("tutor"));
			ca.setEstudiante(request.getParameter("estudiante"));
			ca.setCalificacion(request.getParameter("calificacion"));
			
		}

	try {
			cadao.registrar(ca);
			response.sendRedirect("CalificacionController?accion=listarCalificacion");
			System.out.println("calificacion registrada");
			System.out.println("" + ca.getNombreTutoria() + ca.getTutor() + ca.getEstudiante() + ca.getCalificacion());
		} catch (Exception e) {

			System.out.println("Error al registrar la calificacion");
		}
		
		
	}

	private void abrirForm(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.getRequestDispatcher("views/calificacion-add.jsp").forward(request, response);
			System.out.println("Formulario calificacion abierto");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario calificacion");
			}
		
		
	}

	private void listarCalificacionTutor(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List calificacion=cadao.listarCalificacion();
			request.setAttribute("calificaciones",calificacion);
			
			request.getRequestDispatcher("views/listaCalificacionTutor.jsp").forward(request, response);
			System.out.println("calificacion encontradas");
			
			
		}catch(Exception e) {
			System.out.println("calificacion no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}

	private void listarCalificacion(HttpServletRequest request, HttpServletResponse response) {
		
	System.out.println("Entramos al método listar");
			
			try {
				List calificacion=cadao.listarCalificacion();
				request.setAttribute("calificaciones",calificacion);
				
				request.getRequestDispatcher("views/listaCalificacion.jsp").forward(request, response);
				System.out.println("calificacion encontradas");
				
				
			}catch(Exception e) {
				System.out.println("calificacion no encontrados "+e.getMessage());
			}
			finally {
				//rdao=null;
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
