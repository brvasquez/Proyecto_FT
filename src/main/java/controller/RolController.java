package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RolDao;
import model.RolVo;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/RolController")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RolDao rdao=new RolDao();
	RolVo r=new RolVo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolController() {
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
				
				case "listarRoles":
					//System.out.println("Entró a la opción listar");
					listarRoles(request,response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Entramos al método listar");
		
		try {
			List rol=rdao.listarRoles();
			request.setAttribute("roles",rol);
			request.getRequestDispatcher("views/rol.jsp").forward(request, response);
			System.out.println("Roles encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Roles no encontrados "+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}
	
	private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.getRequestDispatcher("views/rol-add.jsp").forward(request, response);
		System.out.println("Formulario Rol abierto");
		}catch(Exception e) {
			
			System.out.println("Error al abrir el formulario Rol");
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("descripcion") !=null) {
			r.setDescripcionRol(request.getParameter("descripcion"));
		}
		
		if(request.getParameter("chkEstado") !=null){
			r.setEstadoRol(true);
		}
		else {
			r.setEstadoRol(false);
		}
		
		try {
			rdao.registrar(r);
			response.sendRedirect("RolController?accion=listarRoles");
			System.out.println("Rol registrado");
		}catch(Exception e) {
			
			System.out.println("Error al abrir el formulario Rol");
		}
	}
	
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id") !=null) {
			r.setIdRol(Integer.parseInt(request.getParameter("id")));
		}
		
		try {
			rdao.eliminar(r.getIdRol());
			response.sendRedirect("RolController?accion=listarRoles");
			System.out.println("Rol eliminado");
		}catch(Exception e) {
			
			System.out.println("Error al eliminar el formulario Rol");
		}
	}

private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	r.setIdRol(Integer.parseInt(request.getParameter("id")));
	r.setEstadoRol(Boolean.parseBoolean(request.getParameter("es")));
	
	
	try {
		rdao.changeEstado(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el estado del Rol");
	}
}


private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	r.setIdRol(Integer.parseInt(request.getParameter("id")));
	try {
		r=rdao.consultaId(r.getIdRol());
		request.setAttribute("roles",r);
		request.getRequestDispatcher("views/rol-edit.jsp").forward(request, response);
		System.out.println("Rol encontrados");
		
		
	}catch(Exception e) {
		System.out.println("Rol no encontrados "+e.getMessage());
	}
	finally {
		//rdao=null;
	}
	
}

private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("descripcion") !=null) {
		
		r.setIdRol(Integer.parseInt(request.getParameter("id")));
		r.setDescripcionRol(request.getParameter("descripcion"));
	}
	
	if(request.getParameter("chkEstado") !=null){
		r.setEstadoRol(true);
	}
	else {
		r.setEstadoRol(false);
	}
	
	try {
		rdao.edit(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el Rol");
	}
}

}
