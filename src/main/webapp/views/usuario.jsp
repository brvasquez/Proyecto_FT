<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">



<main>

 <h2 class="text-center">Listado de Usuarios</h2>
<br>
<div class="btn  btn-sm">
<a href="UsuarioController?accion=abrirForm" class="btn btn-dark " role="button">  <i class="fas fa-plus"></i> Agregar Usuario</a>
</div>



<div class="recent-orders"> 


	
	<table class="recent-orders" id="datat">
	<thead>
		<tr>
		   
			<th class="text-center">Nombre</th>
			<th class="text-center">Apellido</th>
			<th class="text-center">Correo</th>
			<th class="text-center">Rol <br></th>
			<th class="text-center">Estado</th>
			<th class="text-center">Editar</th>
			<th class="text-center">Eliminar</th>
		</tr>
	</thead>
	<tbody>
			
			<c:forEach items="${user}" var="u">
	
		<tr>
			
			
			<td>${u.getNombreUsuario()}</td>
			<td>${u.getApellidoUsuario()}</td>
			
			
			<td>${u.getCorreoUsuario()}</td>
			<td>${u.rolUs.descripcionRol}</td>
			
			
			
			<c:if test="${u.isEstadoUsuario()==true}">
				<td>
					
					<a  class="theme-toggler" onclick="cambiare(event,${u.getIdUsuario()},${u.isEstadoUsuario()},'Usuario')" role="button"><i class=""></i>Activo</a>
				</td>
			</c:if>
			
			<c:if test="${u.isEstadoUsuario()==false}">
				<td>
					<a  class="theme-toggler" onclick="cambiare(event,${u.getIdUsuario()},${u.isEstadoUsuario()},'Usuario')" role="button"><i class="far fa-sad-tear"></i>Inactivo</a>
				</td>
			</c:if>
			
			<td>
			<a class="message-count" href="UsuarioController?accion=ver&id=${u.getIdUsuario()}" role="button"><i class="fas fa-user-edit"></i></a>
			
			
			
			</td>
			<td>
			
			
			<a class="btn " onclick="borrar(event,${u.getIdUsuario()},'Usuario')" role="button"><i class="fas fa-user-slash"></i></a>
			
			</td>
			
		</tr>
	</c:forEach>
			
	</tbody>
	

</table>
	

</div>


</main>
<style>
  .dataTable-input {
    padding: 6px 12px;
    background-color: #ffffff03;
    color: rgb(121 131 141);
    box-shadow: 2px 0px 20px rgb(43 181 233);
    border-radius: 60px;
}
</style>
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


<%@include file="footer.jsp" %>