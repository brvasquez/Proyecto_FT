<%@page import="model.PdfVO"%>
<%@page import="model.PdfDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>


    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
        <meta httscriptp-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/nav.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <nav>
            <div class="navbar">
                <i class='bx bx-menu'></i>
                <div class="logo"><a href="#">Friendly Tuttor</a></div>
                <div class="nav-links">
                    <div class="sidebar-logo">
                        <span class="logo-name">CodingLab</span>
                        <i class='bx bx-x' ></i>
                    </div>
                    <ul class="links">
                        <li><a href="./Controlador?accion=NuevoProducto">Nueva Tutoria</a>
                        <li><a href="Pagina1.jsp">Subir Material de Apoyo</a>   
                        <li><a href="indexT.jsp">Chat</a> 




                        <li><a href="vistas/Home/indexhome.jsp">Cerrar Sesion</a></li>

                    </ul>
                </div>
                <div class="search-box">
                    <i class='bx bx-search'></i>
                    <div class="input-box">
                        <input type="text" placeholder="Buscar...">
                    </div>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
    <center>
        <h3>Material de Apoyo</h3>
    </center>

    <%
        PdfDAO emp = new PdfDAO();
        PdfVO pdfvo = new PdfVO();
        ArrayList<PdfVO> listar = emp.Listar_PdfVO();
    %>

    <div class="container">
        <div class="container">
            <a id="mostrar" href="ControllerPdf?action=insert&id=<%=pdfvo.getCodigopdf()%>" class="btn btn-info btn-sm">SUBIR MATERIAL</a>
        </div>
        <br>
        <br>

        <table id="usuario" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Archivo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            
            <tbody>
                <%if (listar.size() > 0) {
                        for (PdfVO listar2 : listar) {
                            pdfvo = listar2;
                %>
                <tr>
                    <td><%=pdfvo.getCodigopdf()%></td>
                    <td><%=pdfvo.getNombrepdf()%></td>
                    <td>
                        <%
                            if (pdfvo.getArchivopdf2() != null) {
                        %>
                        <a href="pdf?id=<%=pdfvo.getCodigopdf()%>" target="_blank"><img src="img/pdf.png" title="pdf" width=="20px" height="50px"/></a>
                            <%
                                } else {
                                    out.print("Vacio");
                                }
                            %>
                    </td>
                    <td>
                        
                        <a href="ControllerPdf?action=edit&id=<%=pdfvo.getCodigopdf()%>" class="btn btn-danger"> EDITAR</a>
                        <a href="ControllerPdf?action=delete&id=<%=pdfvo.getCodigopdf()%>" class="btn btn-dark" > ELIMINAR</a>
                    </td>
                </tr>
                <%}
                    }%>
                    
            
            </tbody>
        </table>
        
    </div>
        
            
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
                    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>  
                    <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script> 
                    
                    <script >
                         
                         $('#usuario').DataTable();
                    </script> 
    
</body>