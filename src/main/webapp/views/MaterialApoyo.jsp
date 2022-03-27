<head>
 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</head>

<%@include file="MenuTutor.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<br>
<main>
<h1 class="text-center">Listado de Material</h1>
<br>
<div class="container">
    <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Agregar Material
    </button>
   
</div> 



<div class="recent-orders"> 


	
	<table class="recent-orders" id="datat">
	<br>
	<thead>
	<tr>
		
		<th class="text-center">Nombre Material</th>
		<th class="text-center">Descripcion Material</th>
		<th class="text-center">Link Material</th>
		<th class="text-center">Editar</th>
		<th class="text-center">Eliminar</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${materiales}" var="m">
	
		<tr>
			
			<td>${m.getNombre()}</td>
			<td>${m.getDescripcion()}</td>
			<td>${m.getLink()}</td>
			
			
			<td>
			<a  type="button" data-bs-toggle="" class="btn" data-bs-target="" href="MaterialApoyo?accion=ver&id=${m.getId()}"  role="button"><i class="fas fa-user-edit"></i></a>
			</td>
			<td>
			<a class="btn" onclick="borrar(event,${m.getId()},'MaterialApoyo')" role="button"><i class="fas fa-user-slash"></i></a>
			
			</td>
			
		</tr>
	</c:forEach>
</tbody>
</table>
<br>
<br>
  

  
  <!-- Modal Agregar -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Agregar Material</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          
          <form method="post" action="MaterialApoyoController?accion=add">
                <div class="mb-3">
                    <label for="nombre" class="col-form-label">Nombre</label>
  					<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el " onchange="verifyNombre()"/>
                </div>
                <div class="mb-3">
                    <label for="descripcion">Descripción</label>
  					<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la "/>
                </div>
                 <div class="mb-3">
                    <label for="link">Link</label>
  					<input type="text" class="form-control" name="link" id="link" placeholder="Ingrese "/>
                </div>
               
                
                
                <div class="modal-footer">
          		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
         		 <button type="submit" class="btn btn-primary">Guardar cambios</button>
        </div>
               
          </form>
        </div>
        
      </div>
    </div>
  </div>
  
  
  <!-- Modal Editar -->
  <div class="modal fade" id="editModalLabel" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="editModalLabel">Edit Tutoria</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          
          <form method="post" action="TutoriaController?accion=edit">
                <div class="mb-3">
                    <label for="nombre" class="col-form-label">Nombre</label>
  					<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${us.nombreUsuario}"/>
                </div>
                <div class="mb-3">
                    <label for="descripcion">Descripción</label>
  					<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value=""/>
                </div>
                <div class="mb-3">
                    <label for="usuario">Tutor</label>
  					<input type="text" class="form-control" name="usuario" id="usuario" readonly placeholder="Ingrese la descripción" value="${us.nombreUsuario} ${us.apellidoUsuario}"/>
                </div>
                <div class="mb-3">
                    <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
 	 				<label class="form-check-label" for="flexCheckChecked">
   						 Activo
                </div>
                
                <div class="modal-footer">
          		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
         		 <button type="submit" class="btn btn-primary">Guardar cambios</button>
        </div>
               
          </form>
        </div>
        
      </div>
    </div>
  </div>
  
  

		
		
  
	

</div>
</main>

<style>
  .dataTable-input {
    padding: 6px 12px;
    background-color: #ffffff03;
    color: rgb(121 131 141);
    box-shadow: 2px 0px 20px rgb(43 181 233);
    border-radius: 40px;
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

var myTable = document.querySelector("#datat2");
var dataTable = new DataTable("#datat2", {
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
