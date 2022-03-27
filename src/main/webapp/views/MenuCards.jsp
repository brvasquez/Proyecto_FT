<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<head>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.4/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.11.4/datatables.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet"> 
	<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/MenuCards.css">
	<link rel="stylesheet" href="MenuCards.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
  
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>

	
	<script src="https://kit.fontawesome.com/4a02ae2b25.js" crossorigin="anonymous"></script>
      
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.css">

	<script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.js"></script>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
	
</head>
<body>
	

	<div class="contenedor">
		<nav>
			<a class="logotipo" href="#">Tutorias Publicadas</a>
			<div class="enlaces">
				<a href="SolicitudController?accion=listarSolicitudesEstudiante">Solicitudes</a>
				<a href="MaterialApoyoController?accion=listarMaterialPublicado">Material de Apoyo</a>
				<a href="UsuarioController?accion=editunicoEstudiante">Ver Peril</a>
				<a href="UsuarioController?accion=logout">Cerrar Sesion</a>
				<button class="switch" id="switch">
					<span><i class="fas "></i></span>
					<span><i class="fas "></i></span>
				</button>
			</div>
		</nav>

		<div class="hidden">
				<form action="SolicitudController?accion=Buscar">
				  <input type="hidden" name="txtBuscar" class="form-control">
				  <input type="hidden" name="buscar" vulue="Buscar" class="btn">
				</form>	
		</div>
		
		
		
		<br>
		 <div class="container">
        <button type="button" class="btn btn-outline-info btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Buscar Tutorias
        </button>
    </div>  
     
       <!-- Modal -->
  <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Tutorias Publicadas</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          Bienvenido! ${us.nombreUsuario} ${us.apellidoUsuario} escoge tu tutoria
          <form>
            <table class="table table-striped text-center" id="datat">
              <thead class="thead-dark">
                <tr>
                 
                  <th class="table-dark" scope="col">Nombre</th>
                  <th class="table-dark" scope="col">Descripcion</th>
                  <th class="table-dark" scope="col">Tutor</th>
                  <th class="table-dark" scope="col">Estado</th>
                  <th class="table-dark"  scope="col">Solicitar</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${tutoria}" var="t">
                <tr>
                  
                  <td>${t.getNombre()}</td>
                  <td>${t.getDescripcion()}</td>
                   <td>${t.getUsuario()}</td>
                  
                  <c:if test="${t.isEstado()==true}">
				<td>
					
					<a  class="text-success"  typr="text"><i class=""></i>Tutoria Activa</a>
				</td>
				 </c:if>
			
				<c:if test="${t.isEstado()==false}">
				<td>
					<a  class="text-danger"   typr="text"><i class=""></i>Tutoria Inactiva</a>
				</td>
				</c:if>
                  <td><a class="btn btn-light btn-sm" href="TutoriaController?accion=verTutoria&id=${t.getIdTutoria()}"><i class="fas fa-user-plus"></i></a></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
          <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Ver en cards</button>
        </div>
      </div>
    </div>
  </div>
		
		
		
		
		
		
		
		<table id="datat">
		
		 <section class="grid">
			<c:forEach items="${tutoria}" var="t">
					
				<div class="card">
					<div class="center-text">
						<div class="contenido-card">
							<h3>${t.getNombre()}</h3>
							
							<p>${t.getDescripcion()}.</p>
							<p class="text-warning">Tutor :<b class="text-secondary">${t.getUsuario()}</b></p>
							  <c:if test="${t.isEstado()==true}">
				
					
					<p  class="text-success" type="text"><i class=""></i>Tutoria Activa</p>
				
				 </c:if>
				<%String hidden=request.getParameter("hidden");%>
				
				<c:if test="${t.isEstado()==false}">
				
					<p  type="hidden" class="text-danger" ><i class=""></i>Tutoria Inactiva</p>
			
				</c:if>
							
							<br>
							<a href="TutoriaController?accion=verTutoria&id=${t.getIdTutoria()}">Solicitar</a>
						</div>
					</div>
				</div>	
					
					
				</c:forEach>
			</section>
		
		</table>
		
		
	
		
		
		</div>
	
	
	<style>

.dataTable-input {
    padding: 1px 5px;
    background-color: #ffffff03;
    color: rgb(121 131 141);
    box-shadow: 2px 0px 20px rgb(43 181 233 / 11%);
    border-radius: 8px;
}

.modal-body {
    position: relative;
    flex: 1 1 auto;
    padding: 1rem;
   
    border-radius: 40px;
}

.modal-content {
    position: relative;
    display: flex;
    flex-direction: column;
    width: 105%;
    pointer-events: auto;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid rgba(0,0,0,.2);
    border-radius: .3rem;
    outline: 0;
    box-shadow: 2px 0px 20px rgb(255 255 255);
    border-radius: 40px;
}
</style>
	
	
<script type="text/javascript" src="main.js"></script>  
	<script src="js/MenuCards.js"></script>
	<script src="MenuCards.js"></script>
 
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>

Swal.fire({
	  title:"!Bienvenido a Frienly Tutor ! ${us.nombreUsuario} ${us.apellidoUsuario}"
	 
	});
	
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>

var myTable = document.querySelector("#datat");
var dataTable = new DataTable("#datat", {
    perPage:4,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por página",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<script>
</script>

	<%@include file="footer.jsp" %>
</body>