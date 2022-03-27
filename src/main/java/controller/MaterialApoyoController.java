package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MaterialApoyoVO;

import model.MaterialApoyoDao;


@WebServlet("/MaterialApoyoController")
public class MaterialApoyoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MaterialApoyoDao mdao=new MaterialApoyoDao();
	MaterialApoyoVO m=new MaterialApoyoVO();
    	
    public MaterialApoyoController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String accion=request.getParameter("accion");
		System.out.println("Entró al controlador"+accion);
		
		try {
			if(accion!=null) {
				switch(accion) {
				
				case "listarMaterial":
					//System.out.println("Entró a la opción listar");
					listarMaterial(request,response);
				break;
				
				case "listarMaterialPublicado":
					//System.out.println("Entró a la opción listar");
					listarMaterialPublicado(request,response);
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

	
	


	private void listarMaterialPublicado(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
System.out.println("Entramos al método listar");
		
		try {
			List material=mdao.listarMaterial();
			request.setAttribute("materiales",material);
			
			request.getRequestDispatcher("views/MaterialPublicado.jsp").forward(request, response);
			System.out.println("material encontradas");
			
			
		}catch(Exception e) {
			System.out.println("material no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}


	private void listarMaterial(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	System.out.println("Entramos al método listar");
		
		try {
			List material=mdao.listarMaterial();
			request.setAttribute("materiales",material);
			
			request.getRequestDispatcher("views/MaterialApoyo.jsp").forward(request, response);
			System.out.println("material encontradas");
			
			
		}catch(Exception e) {
			System.out.println("material no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	

	private void abrirForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.getRequestDispatcher("views/MaterialApoyo-add.jsp").forward(request, response);
			System.out.println("Formulario material abierto");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario material");
			}
		
	}
	

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("nombre") != null && request.getParameter("descripcion") != null) {
					
					m.setNombre(request.getParameter("nombre"));
					m.setDescripcion(request.getParameter("descripcion"));
					m.setLink(request.getParameter("link"));
					
				}
		
			try {
					mdao.registrar(m);
					response.sendRedirect("MaterialApoyoController?accion=listarMaterial");
					System.out.println("material registrada");
					System.out.println("" + m.getNombre() + m.getDescripcion() + m.getLink());
				} catch (Exception e) {
		
					System.out.println("Error al registrar la material");
				}
				
			}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null) {
			m.setId(Integer.parseInt(request.getParameter("id")));
		}

		try {
			mdao.eliminar(m.getId());
			response.sendRedirect("MaterialApoyoController?accion=listarMaterial");
			System.out.println("material eliminada");
		} catch (Exception e) {

			System.out.println("Error al eliminar la material");
		}
		
	}
	

	private void ver(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		m.setId(Integer.parseInt(request.getParameter("id")));
		try {
			m = mdao.consultaId(m.getId());
			request.setAttribute("materiales", m);
			request.getRequestDispatcher("views/MaterialApoyo-edit.jsp").forward(request, response);
			System.out.println("material encontrada");

		} catch (Exception e) {
			System.out.println("material no encontrada " + e.getMessage());
		} finally {
			// rdao=null;
		}
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") != null && request.getParameter("nombre") != null
				&& request.getParameter("descripcion") != null) {
			
			m.setId(Integer.parseInt(request.getParameter("id")));
			m.setNombre(request.getParameter("nombre"));
			m.setDescripcion(request.getParameter("descripcion"));
			m.setLink(request.getParameter("link"));
			
		}
		try {
			mdao.edit(m);
			response.sendRedirect("MaterialApoyoController?accion=listarMaterial");
			System.out.println("material cambiada");
		} catch (Exception e) {

			System.out.println("Error al cambiar la material");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
