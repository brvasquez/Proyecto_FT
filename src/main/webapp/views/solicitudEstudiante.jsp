<%@include file="MenuEstudiante.jsp" %>



<div class="flex-fill flex-grow-1 ms-3">

<br>
<main>
<h3 class="text-center">Solicitud</h3>
<br>
<div class="container">


</div>



<div class="recent-orders"> 


	
	<table class="recent-orders" id="datat">
	<br>
	<thead>
	<tr>
		
		<th class="text-center">Nombre</th>
		<th class="text-center">Descripcion</th>
		<th class="text-center">Tutor</th>
		<th class="text-center">Estudiante</th>
		
		<th class="text-center">Estado</th>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${solicitud}" var="s">
	
		<tr>
			
			<td>${s.getNombre()}</td>
			<td>${s.getDescripcion()}</td>
			<td>${s.getUsuario()}</td>
			<td>${s.getEstudianteSolicitante()}</td>
			
			
			
			<c:if test="${s.isEstado()==true}">
				<td>
					
					<a  class="theme-toggler"  role="button"><i class=""></i>inhabilitada</a>
				</td>
			</c:if>
			
			<c:if test="${s.isEstado()==false}">
				<td>
					<a  class="theme-toggler"  role="button"><i class=""></i>En Proceso</a>
				</td>
			</c:if>
			
			
			
			
		
			
		</tr>
	</c:forEach>
</tbody>
</table>
	

</div>
</main>
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
