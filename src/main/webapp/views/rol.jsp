<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">
<br>

<h2 class="text-center">Listado de Roles</h2>
<br>
<br>

<a href="RolController?accion=abrirForm" class="btn btn-dark" role="button"><i class="fas fa-plus"></i></a>
<br>
<br>
<div class="container">
	<table class="table table-light table-bordered border-dark text-center" id="datat">
	
	<tr class="text-center">
		<th class="text-center">iD</th>
		<th class="text-center">Descripción</th>
		<th class="text-center">Estado</th>
		<th class="text-center" colspan="2">Acciones</th>
	</tr>
	
	<c:forEach items="${roles}" var="r">
	
		<tr>
			<td>${r.getIdRol()}</td>
			<td>${r.getDescripcionRol()}</td>
			
			<c:if test="${r.isEstadoRol()==true}">
				<td><span class="badge bg-success"><i class="far fa-smile-beam"></i></span>
					<a class="btn btn-danger btn-sm" onclick="cambiare(event,${r.getIdRol()},${r.isEstadoRol()},'Rol')" role="button"><i class="far fa-sad-tear"></i></a>
				</td>
			</c:if>
			<c:if test="${r.isEstadoRol()==false}">
				<td><span class="badge bg-danger"><i class="far fa-sad-tear"></i></span>
					<a class="btn btn-success btn-sm" onclick="cambiare(event,${r.getIdRol()},${r.isEstadoRol()},'Rol')" role="button"><i class="far fa-sad-tear"></i></a>
				</td>
			</c:if>
			<td>
			<a class="btn btn-warning" href="RolController?accion=ver&id=${r.getIdRol()}" role="button"><i class="fas fa-user-edit"></i></a>
			<a class="btn btn-danger" onclick="borrar(event,${r.getIdRol()},'Rol')" role="button"><i class="fas fa-user-slash"></i></a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>
</div>



<script>

var myTable = document.querySelector("#datat");
var dataTable = new DataTable("#datat", {
    perPage:5,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por página",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<%@include file="footer.jsp" %>