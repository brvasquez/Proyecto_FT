<%@include file="MenuTutor.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">



<h1>Actualizar Solicitud</h1>

<form method="post" action="SolicitudController?accion=edit">
  	
  	<div class="form-group">
  		<input type="text" readonly class="form-control" name="id" id="id" placeholder="" value="${solicitudes.id}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${solicitudes.nombre}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${solicitudes.descripcion}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Tutor</label>
  		<input type="text" class="form-control" name="usuario" id="usuario" placeholder="Ingrese usuario" value="${solicitudes.usuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Estudiante</label>
  		<input type="text" readonly class="form-control" name="estudianteSolicitante" id="estudianteSolicitante" placeholder="Ingrese usuario" value="${solicitudes.estudianteSolicitante}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Correo</label>
  		<input type="text" readonly class="form-control" name="correo" id="correo" placeholder="Ingrese usuario" value="${solicitudes.correo}"/>
  	</div>
  	  
  	
  	
 
  	
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${solicitudes.estado==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${solicitudes.estado==false ? 'Marca para Activar':'Desmarca para desactivar '}
	  </label>
	  
	</div>


<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>