<%@include file="MenuTutor.jsp" %>



<div class="flex-fill flex-grow-1 ms-3">

<br>
<main>
<h2 class="text-center">Listado de Solicitud Enviada</h2>
<br>
<div class="container">



</div>



<div class="recent-orders"> 


	
	<table class="recent-orders" id="datat">
	<br>
	<thead>
	<tr>
		
		<th class="text-center">Tutoria</th>
		<th class="text-center">Estudiante</th>
		<th class="text-center">Correo</th>
		<th class="text-center">Descripcion Solicitud</th>
		
		<th class="text-center">Estado</th>
		<th class="text-center">Editar</th>
		<th class="text-center">Eliminar</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${solicitudEnviada}" var="s">
	
		<tr>
			
			<td>${s.getNombre()}</td>
			<td>${s.getEstudianteSolicitante()}</td>
			<td>${s.getCorreo()}</td>
			<td>${s.getDescripcionSolicitud()}</td>
			
			
			
			<c:if test="${s.isEstado()==true}">
				<td>
					
					<a  class="theme-toggler" onclick="cambiare(event,${s.getId()},${s.isEstado()},'Solicitud')" role="button"><i class=""></i>activa</a>
				</td>
			</c:if>
			
			<c:if test="${s.isEstado()==false}">
				<td>
					<a  class="theme-toggler" onclick="cambiare(event,${s.getId()},${s.isEstado()},'Solicitud')" role="button"><i class=""></i>inactiva</a>
				</td>
			</c:if>
			
			
			<td>
			<a class="btn  " href="SolicitudEnviadaController?accion=ver&id=${s.getId()}" role="button"><i class="fas fa-user-edit"></i></a>
			</td>
			<td>
			<a class="btn " onclick="borrar(event,${s.getId()},'SolicitudEnviada')" role="button"><i class="fas fa-user-slash"></i></a>
			
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
